package com.jetbrains;

import com.vaadin.data.Property;
import com.vaadin.event.UIEvents;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ClassResource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * Created by kalistrat on 27.04.2017.
 */
public class tGameRunningLayout extends VerticalLayout {

    public int iGameId;
    public tGameRunningTree iGameRunningTree;
    public VerticalLayout RightContentLayout;
    public VerticalLayout LeftContentLayout;
    public tGameAreaLayout iGameAreaLayout;
    public tResultsGraphLayout iResultsGraphLayout;
    public String iUserLog;

    public TextField iWaitingTimeField;
    public TextField iCurrentPlayerBalance;
    public TextField iStepingPlayer;
    public Button MakeStepButton;
    public Button GameExitButton;
    TabSheet iGameMenuTabSheet;


    public tGameRunningLayout(int eGameId,String eUserLog,TabSheet eGameMenuTabSheet){

        this.iGameId = eGameId;
        this.iUserLog = eUserLog;
        iGameMenuTabSheet = eGameMenuTabSheet;

        iWaitingTimeField = new TextField("Время ожидания хода");
        iCurrentPlayerBalance = new TextField("Текущий игровой баланс");
        iStepingPlayer = new TextField("Игрок,выполняющий ход");

        iWaitingTimeField.addStyleName(ValoTheme.TEXTFIELD_TINY);
        iCurrentPlayerBalance.addStyleName(ValoTheme.TEXTFIELD_TINY);
        iStepingPlayer.addStyleName(ValoTheme.TEXTFIELD_TINY);

        iWaitingTimeField.setIcon(VaadinIcons.TIMER);
        iCurrentPlayerBalance.setIcon(VaadinIcons.COIN_PILES);
        iStepingPlayer.setIcon(VaadinIcons.USER_CLOCK);

        iWaitingTimeField.setEnabled(false);
        iStepingPlayer.setEnabled(false);
        iCurrentPlayerBalance.setEnabled(false);

        MakeStepButton = new Button("Выполнить ход");
        MakeStepButton.addStyleName(ValoTheme.BUTTON_LINK);
        MakeStepButton.addStyleName(ValoTheme.BUTTON_SMALL);
        MakeStepButton.setIcon(VaadinIcons.MONEY_EXCHANGE);
        MakeStepButton.setEnabled(false);

        MakeStepButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                makeGameStep();
            }
        });

        GameExitButton = new Button("Покинуть игру");
        GameExitButton.addStyleName(ValoTheme.BUTTON_LINK);
        GameExitButton.addStyleName(ValoTheme.BUTTON_SMALL);
        GameExitButton.setIcon(VaadinIcons.EXIT);
        GameExitButton.setData(this);
        GameExitButton.setEnabled(false);

        GameExitButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI.getCurrent().addWindow(new tGameLeftWindow(iGameId,iUserLog,iGameMenuTabSheet,(tGameRunningLayout) clickEvent.getButton().getData()));
            }
        });


        VerticalLayout GameMenuLayout = new VerticalLayout(
                iStepingPlayer
                ,iCurrentPlayerBalance
                ,iWaitingTimeField
        );
        GameMenuLayout.setSizeUndefined();
        GameMenuLayout.setSpacing(true);

        VerticalLayout GameButtonsLayout = new VerticalLayout(
                MakeStepButton
                ,GameExitButton
                ,new Label()
        );
        GameButtonsLayout.setSizeUndefined();
        GameButtonsLayout.setSpacing(true);


        Image CubeImage = new Image(null, new ClassResource("/pics/g_page_blue.png"));
        CubeImage.setHeight(100,Unit.PIXELS);
        CubeImage.setWidth(90,Unit.PIXELS);

        VerticalLayout CubeImageLayout = new VerticalLayout(CubeImage);
        CubeImageLayout.addStyleName(ValoTheme.LAYOUT_WELL);
        CubeImageLayout.setWidth("120px");
        CubeImageLayout.setHeight("120px");
        CubeImageLayout.setComponentAlignment(CubeImage, Alignment.MIDDLE_CENTER);

        Label LeftContentLabel= new Label();
        LeftContentLabel.setContentMode(ContentMode.HTML);
        LeftContentLabel.setValue(VaadinIcons.PLAY_CIRCLE.getHtml() + " Игра № " + String.valueOf(iGameId));
        LeftContentLabel.addStyleName(ValoTheme.LABEL_SMALL);
        LeftContentLabel.addStyleName(ValoTheme.LABEL_COLORED);
        LeftContentLabel.setSizeUndefined();

        iGameRunningTree = new tGameRunningTree();

        iGameRunningTree.addListener(new Property.ValueChangeListener() {

            public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
                if(event.getProperty().getValue() != null)
                {

                    if (event.getProperty().getValue().equals("Выполнение ходов игры")){
                        RightContentLayout.removeAllComponents();
                        iGameAreaLayout = new tGameAreaLayout(iGameId,iUserLog);
                        RightContentLayout.addComponent(iGameAreaLayout);
                    }

                    if (event.getProperty().getValue().equals("Результаты ходов игры")){
                        RightContentLayout.removeAllComponents();
                        iResultsGraphLayout = new tResultsGraphLayout(iGameId,iUserLog);
                        RightContentLayout.addComponent(iResultsGraphLayout);
                    }

                }
            }
        });



        LeftContentLayout = new VerticalLayout(
                LeftContentLabel
                ,CubeImageLayout
                ,iGameRunningTree
                ,GameMenuLayout
                ,GameButtonsLayout

        );

        LeftContentLayout.setMargin(new MarginInfo(true,false,false,false));
        LeftContentLayout.setComponentAlignment(CubeImageLayout,Alignment.MIDDLE_CENTER);
        LeftContentLayout.setComponentAlignment(LeftContentLabel,Alignment.MIDDLE_CENTER);
        LeftContentLayout.setComponentAlignment(iGameRunningTree,Alignment.MIDDLE_CENTER);
        LeftContentLayout.setComponentAlignment(GameMenuLayout,Alignment.MIDDLE_CENTER);
        LeftContentLayout.setComponentAlignment(GameButtonsLayout,Alignment.MIDDLE_CENTER);

        LeftContentLayout.setSpacing(true);
        LeftContentLayout.setWidth("100%");
        //LeftContentLayout.setHeight("50%");


        iGameAreaLayout = new tGameAreaLayout(this.iGameId,this.iUserLog);
        iResultsGraphLayout = new tResultsGraphLayout(iGameId,iUserLog);

        RightContentLayout = new VerticalLayout(
                iGameAreaLayout
        );

        RightContentLayout.setMargin(true);


        HorizontalSplitPanel UserDataSection = new HorizontalSplitPanel();
        UserDataSection.setHeight("1000px");
        UserDataSection.setWidth("1000px");

        UserDataSection.setFirstComponent(LeftContentLayout);
        UserDataSection.setSecondComponent(RightContentLayout);
        UserDataSection.setSplitPosition(24f,UNITS_PERCENTAGE);
        UserDataSection.setMinSplitPosition(24f,UNITS_PERCENTAGE);
        UserDataSection.setMaxSplitPosition(24f,UNITS_PERCENTAGE);

        VerticalLayout ContentLayout = new VerticalLayout(UserDataSection);
        ContentLayout.setHeight("1000px");
        ContentLayout.setWidth("1000px");
        ContentLayout.addStyleName(ValoTheme.LAYOUT_CARD);



        this.addComponent(new Label());
        this.addComponent(ContentLayout);
        this.addComponent(new Label());

        this.setComponentAlignment(ContentLayout, Alignment.MIDDLE_CENTER);
        //this.setData(this);



        UI.getCurrent().addPollListener(new UIEvents.PollListener() {
            @Override
            public void poll(UIEvents.PollEvent event) {
                getStepingPlayer();
                getCurrentBalance();
                getWatingTime();
                //tGameRunningLayout tComp = (tGameRunningLayout) iGameMenuTabSheet.getSelectedTab();
                //tGameRunningLayout tComp = (tGameRunningLayout) iGameMenuTabSheet.getSelectedTab().getCaption();
                //System.out.println(((tGameRunningLayout) iGameMenuTabSheet.getTab(2).getComponent()).iGameId);

                if (isUserMove() == 1) {
                    MakeStepButton.setEnabled(true);
                    GameExitButton.setEnabled(true);
                } else {
                    MakeStepButton.setEnabled(false);
                    GameExitButton.setEnabled(false);
                }

                //System.out.println("getUserGameStatus " + getUserGameStatus());

                if ((getUserGameStatus().equals("L")) && ((Integer) iGameMenuTabSheet.getData()!=0)) {
                    UI.getCurrent().addWindow(new tGameLostWindow(iGameId
                            ,iUserLog
                            ,iGameMenuTabSheet
                            ,(tGameRunningLayout) iGameMenuTabSheet.getTab(2).getComponent()
                    ));
                }

                if ((getUserGameStatus().equals("W")) && ((Integer) iGameMenuTabSheet.getData()!=0)) {

                    UI.getCurrent().addWindow(new tGameWonWindow(iGameId
                            ,iUserLog
                            ,iGameMenuTabSheet
                            ,(tGameRunningLayout) iGameMenuTabSheet.getTab(2).getComponent()
                    ));

                }

            }
        });

    }

    public void getStepingPlayer(){

        try {

            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement StepingPlayerStmt = Con.prepareCall("{? = call f_get_steping_user_name(?)}");
            StepingPlayerStmt.registerOutParameter (1, Types.VARCHAR);
            StepingPlayerStmt.setInt(2, iGameId);

            StepingPlayerStmt.execute();
            iStepingPlayer.setValue(StepingPlayerStmt.getString(1));
            Con.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

    }

    public void getCurrentBalance(){

        try {

            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement CurrentBalanceStmt = Con.prepareCall("{? = call f_get_current_balance(?,?)}");
            CurrentBalanceStmt.registerOutParameter (1, Types.DECIMAL);
            CurrentBalanceStmt.setInt(2, iGameId);
            CurrentBalanceStmt.setString(3, iUserLog);

            CurrentBalanceStmt.execute();
            iCurrentPlayerBalance.setValue(String.valueOf(CurrentBalanceStmt.getDouble(1)));
            Con.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

    }

    public void getWatingTime(){

        try {

            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement WatingTimeStmt = Con.prepareCall("{? = call f_get_steping_time(?,?)}");
            WatingTimeStmt.registerOutParameter (1, Types.CHAR);
            WatingTimeStmt.setInt(2, iGameId);
            WatingTimeStmt.setString(3, iUserLog);

            WatingTimeStmt.execute();
            iWaitingTimeField.setValue(WatingTimeStmt.getString(1));
            Con.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

    }

    public void makeGameStep(){

        try {

            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement MakeStepStmt = Con.prepareCall("{call p_make_game_step_n(?,?)}");
            MakeStepStmt.setInt(1, iGameId);
            MakeStepStmt.setString(2, iUserLog);
            MakeStepStmt.execute();
            Con.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

    }

    public int isUserMove(){
        int aMyMove = 0;
        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement MyMoveStmt = conn.prepareCall("{? = call f_itsmyturn(?,?)}");
            MyMoveStmt.registerOutParameter(1,Types.INTEGER);
            MyMoveStmt.setInt(2, iGameId);
            MyMoveStmt.setString(3, iUserLog);
            MyMoveStmt.execute();
            aMyMove = MyMoveStmt.getInt(1);
            conn.close();

        } catch (SQLException se3) {
            //Handle errors for JDBC
            se3.printStackTrace();
        } catch (Exception e13) {
            //Handle errors for Class.forName
            e13.printStackTrace();
        }


        return aMyMove;
    }

    public String getUserGameStatus(){
        String aGameUserStatus = "";
        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement GameUserStatusStmt = conn.prepareCall("{? = call f_web_user_status(?,?)}");
            GameUserStatusStmt.registerOutParameter(1,Types.CHAR);
            GameUserStatusStmt.setInt(2, iGameId);
            GameUserStatusStmt.setString(3, iUserLog);
            GameUserStatusStmt.execute();
            if (GameUserStatusStmt.getString(1) == null) {
                aGameUserStatus = "";
            } else {
                aGameUserStatus = GameUserStatusStmt.getString(1);
            }

            conn.close();

        } catch (SQLException se3) {
            //Handle errors for JDBC
            se3.printStackTrace();
        } catch (Exception e13) {
            //Handle errors for Class.forName
            e13.printStackTrace();
        }


        return aGameUserStatus;
    }

}
