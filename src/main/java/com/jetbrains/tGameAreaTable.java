package com.jetbrains;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SemenovNA on 08.08.2016.
 */
public class tGameAreaTable extends Table {


    public String InsUserName;
    public Integer InsGameId;


    List<String> engage_index = new ArrayList<>();
    IndexedContainer GameAreaContainer;


    public tGameAreaTable(Integer jGameId, String jCurrentUser){

        int jAreaSize = GetGameAreaSize(jGameId);
        this.InsGameId = jGameId;
        this.InsUserName = jCurrentUser;
        this.GameAreaContainer = new IndexedContainer();


        for (int i = 0; i < jAreaSize; i++) {
            GameAreaContainer.addContainerProperty(Integer.toString(i + 1), Button.class, null);
        }
        String jUserSym = jCurrentUser.toUpperCase().substring(0,1);

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            String AreaSql = "select af.field_index\n" +
                    ",ft.filed_color\n" +
                    ",ft.field_value\n" +
                    ",(\n" +
                    "select p.player_log\n" +
                    "from game_field gf\n" +
                    "join game_player gp on gp.game_player_id=gf.game_player_id\n" +
                    "join player p on p.player_id=gp.player_id\n" +
                    "where gf.field_index=af.field_index\n" +
                    "and gf.game_id=?\n" +
                    ") field_owner_log\n" +
                    "from area_type aty\n" +
                    "join area_field af on af.area_type_id=aty.area_type_id\n" +
                    "join field_type ft on ft.field_type_id=af.field_type_id\n" +
                    "where aty.area_size = ?\n" +
                    "order by af.field_index";

            PreparedStatement AreaSqlStmt = conn.prepareStatement(AreaSql);
            AreaSqlStmt.setInt(1,jGameId);
            AreaSqlStmt.setInt(2,jAreaSize);
            ResultSet AreaSqlRs = AreaSqlStmt.executeQuery();
            int CntRowItems = 0;
            int RowNum = 1;
            Item newItem = GameAreaContainer.getItem(GameAreaContainer.addItem());

            while (AreaSqlRs.next()) {

                if (CntRowItems <= jAreaSize - 1) {
                    CntRowItems = CntRowItems + 1;
                } else {
                    CntRowItems = 1;
                    RowNum = RowNum + 1;
                    newItem = GameAreaContainer.getItem(GameAreaContainer.addItem());
                }

                String AreaFieldIndex = AreaSqlRs.getString(1);
                String AreaFieldColor = AreaSqlRs.getString(2);
                Double AreaFieldVal = AreaSqlRs.getDouble(3);
                String AreaFieldOwner = AreaSqlRs.getString(4);

                String Field_RateX = String.valueOf(AreaFieldVal.intValue())+"x";

                Button ButtonField = new Button(Field_RateX);
                ButtonField.setHeight("25px");
                ButtonField.setWidth("50px");

                //System.out.println("jCurrentUser  = " + jCurrentUser);

                if ((jCurrentUser.equals(AreaFieldOwner)) || (null  == AreaFieldOwner)) {
                    ButtonField.setEnabled(true);
                } else {
                    ButtonField.setEnabled(false);
                }

                ButtonField.addStyleName(AreaFieldColor);

                ButtonField.setData(new BuAttach(AreaFieldIndex,Field_RateX,jUserSym));


                ButtonField.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent clickEvent) {
                        BuAttach ButVal = (BuAttach) clickEvent.getButton().getData();

                        if (clickEvent.getButton().getCaption().equals(ButVal.field_rate)) {

                                if (IsPossibleToBuy(InsGameId,InsUserName,ButVal.field_index)) {
                                   clickEvent.getButton().setCaption(ButVal.field_user_create_sym);
                                    ButVal.BuAttachChangeOwner(ButVal.field_user_create_sym);
                                    BuyGameField(InsGameId, InsUserName, ButVal.field_index);
                                } else {
                                    Notification.show("Ваш баланс недостаточен");
                                }

                        } else {
                            clickEvent.getButton().setCaption(ButVal.field_rate);

                            SellGameField(InsGameId,InsUserName,ButVal.field_index);

                        }
                    }
                });

                newItem.getItemProperty(Integer.toString(CntRowItems)).setValue(ButtonField);
            }
            conn.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

        for (int i=0;i<engage_index.size();i++){
            System.out.println("engage_index  = " + engage_index.get(i));
        }

        setContainerDataSource(GameAreaContainer);
        setColumnHeaderMode(COLUMN_HEADER_MODE_HIDDEN);
        setPageLength(GameAreaContainer.size());


    }

    public Button AreaContainerFindByIndex(String jIndex){
        Integer NumRow = Integer.parseInt(jIndex.substring(0,1)) + 1;
        Integer NumCol = Integer.parseInt(jIndex.substring(1,2)) + 1;
        return  (Button) this.GameAreaContainer.getContainerProperty(NumRow,String.valueOf(NumCol)).getValue();
    }

    public void AreaContainerRefresh(int IsUserStepping){

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection ConRef = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            String AreaRefreshSql = "select gf.field_index\n" +
                    ", gf.field_value\n" +
                    ", gp.player_sym\n" +
                    "from game_field gf\n" +
                    "left join game_player gp on gp.game_player_id=gf.game_player_id\n" +
                    "left join player p on p.player_id=gp.player_id\n" +
                    "where gf.game_id=?";

            PreparedStatement AreaRefStmt = ConRef.prepareStatement(AreaRefreshSql);
            AreaRefStmt.setInt(1,this.InsGameId);
            ResultSet AreaRefRes = AreaRefStmt.executeQuery();

            while (AreaRefRes.next()) {

                String AreaFieldIndex = AreaRefRes.getString(1);
                Double AreaFieldVal = AreaRefRes.getDouble(2);
                String AreaFieldOwnerSym = AreaRefRes.getString(3);
                //System.out.println("AreaContainerFindByIndex  = " + AreaContainerFindByIndex(AreaFieldIndex).getCaption());

                BuAttach ButtonSData = (BuAttach) this.AreaContainerFindByIndex(AreaFieldIndex).getData();

                //ButtonSData.BuAttachChangeOwner(AreaFieldOwnerSym);

                if (AreaFieldOwnerSym != null) {
                    this.AreaContainerFindByIndex(AreaFieldIndex).setCaption(AreaFieldOwnerSym);
                    ButtonSData.BuAttachChangeOwner(AreaFieldOwnerSym);
                }


                if (IsUserStepping == 0){
                    this.AreaContainerFindByIndex(AreaFieldIndex).setEnabled(false);
                } else {

                    if (!ButtonSData.field_user_owner_sym.equals(ButtonSData.field_user_create_sym)) {
                        this.AreaContainerFindByIndex(AreaFieldIndex).setEnabled(false);
                    } else {
                        this.AreaContainerFindByIndex(AreaFieldIndex).setEnabled(true);
                    }
                }

                }


            ConRef.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public void BuyGameField(int qGameId,String qPlayerLog,String qFieldIndex) {

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection ConBuy = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement BuyStmt = ConBuy.prepareCall("{call p_buy_game_field_n(?, ?, ?)}");
            BuyStmt.setInt(1, qGameId);
            BuyStmt.setString(2, qPlayerLog);
            BuyStmt.setString(3, qFieldIndex);
            BuyStmt.execute();
            ConBuy.close();

        } catch (SQLException se1) {
            //Handle errors for JDBC
            se1.printStackTrace();
        } catch (Exception e11) {
            //Handle errors for Class.forName
            e11.printStackTrace();
        }
    }

    public void SellGameField(int qGameId,String qPlayerLog,String qFieldIndex) {

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection SellBuy = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement SellStmt = SellBuy.prepareCall("{call p_sell_game_field_n(?, ?, ?)}");
            SellStmt.setInt(1, qGameId);
            SellStmt.setString(2, qPlayerLog);
            SellStmt.setString(3, qFieldIndex);
            SellStmt.execute();
            SellBuy.close();

        } catch (SQLException se2) {
            //Handle errors for JDBC
            se2.printStackTrace();
        } catch (Exception e12) {
            //Handle errors for Class.forName
            e12.printStackTrace();
        }
    }

    public boolean IsPossibleToBuy(int qGameId,String qPlayerLog,String qFieldIndex){
        boolean IsPossible = false;


        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection BalCon = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement BalStmt = BalCon.prepareCall("{? = call f_is_possible_to_buy(?, ?, ?)}");
            BalStmt.registerOutParameter(1,Types.BOOLEAN);
            BalStmt.setInt(2, qGameId);
            BalStmt.setString(3, qPlayerLog);
            BalStmt.setString(4, qFieldIndex);
            BalStmt.execute();
            IsPossible = BalStmt.getBoolean(1);
            BalCon.close();

        } catch (SQLException se3) {
            //Handle errors for JDBC
            se3.printStackTrace();
        } catch (Exception e13) {
            //Handle errors for Class.forName
            e13.printStackTrace();
        }


        return IsPossible;
    }

    public int GetGameAreaSize(int qGameId){
        int aSize = 0;

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement SizeStmt = conn.prepareCall("{? = call f_get_game_size(?)}");
            SizeStmt.registerOutParameter(1,Types.INTEGER);
            SizeStmt.setInt(2, qGameId);
            SizeStmt.execute();
            aSize = SizeStmt.getInt(1);
            conn.close();

        } catch (SQLException se3) {
            //Handle errors for JDBC
            se3.printStackTrace();
        } catch (Exception e13) {
            //Handle errors for Class.forName
            e13.printStackTrace();
        }


        return aSize;
    }

}
