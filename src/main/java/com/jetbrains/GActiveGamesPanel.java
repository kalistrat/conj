package com.jetbrains;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.Action;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;

import java.sql.*;

/**
 * Created by SemenovNA on 04.08.2016.
 */
public class GActiveGamesPanel extends Panel {

    static final private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final private String DB_URL = "jdbc:mysql://localhost/conjuncture";
    static final private String USER = "gumbler";
    static final private String PASS = "tutunia";

    static final Action ACTION_CONNECT = new Action("Подключиться");
    static final Action[] ACTIONS_CONNECT = new Action[] {ACTION_CONNECT};
    Integer iGameId = null;

    public GActiveGamesPanel(GUserMainPanel iMainPanel){
        Table ActiveGamesTable = new Table();

        IndexedContainer ActiveGamesContainer = new IndexedContainer();

        ActiveGamesContainer.addContainerProperty(1, Integer.class, null);
        ActiveGamesContainer.addContainerProperty(2, Date.class, null);
        ActiveGamesContainer.addContainerProperty(3, String.class, null);
        ActiveGamesContainer.addContainerProperty(4, String.class, null);
        ActiveGamesContainer.addContainerProperty(5, Integer.class, null);
        ActiveGamesContainer.addContainerProperty(6, Double.class, null);
        ActiveGamesContainer.addContainerProperty(7, Timestamp.class, null);


        ActiveGamesTable.setColumnHeader(1, "Номер игры");
        ActiveGamesTable.setColumnHeader(2, "Дата создания");
        ActiveGamesTable.setColumnHeader(3, "Создатель игры");
        ActiveGamesTable.setColumnHeader(4, "Размер поля");
        ActiveGamesTable.setColumnHeader(5, "Количество игроков");
        ActiveGamesTable.setColumnHeader(6, "Общая сумма игры");
        ActiveGamesTable.setColumnHeader(7, "Время последнего хода");

        try {

                Class.forName(JDBC_DRIVER);
                Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                String ActiveGamesSql = "select g.game_id\n" +
                        ",g.date_from\n" +
                        ",p.player_log\n" +
                        ",concat(art.area_size,'x',art.area_size) size\n" +
                        ",(\n" +
                        "select count(*)\n" +
                        "from game_player gp\n" +
                        "where gp.game_id=g.game_id\n" +
                        ") cnt_players\n" +
                        ",(\n" +
                        "select sum(gp.in_passiv_value)\n" +
                        "from game_player gp\n" +
                        "where gp.game_id=g.game_id\n" +
                        ") sum_players\n" +
                        ",g.last_activity_date\n" +
                        "from game g\n" +
                        "join player p on p.player_id=g.create_player_id\n" +
                        "join area_type art on art.area_type_id=g.area_type_id\n" +
                        "where g.game_id > 40\n" +
                        "order by g.game_id";

                PreparedStatement ActiveGamesStmt = conn.prepareStatement(ActiveGamesSql);
                ResultSet ActiveGameslRes = ActiveGamesStmt.executeQuery();

                while (ActiveGameslRes.next()) {

                Item newItem = ActiveGamesContainer.getItem(ActiveGamesContainer.addItem());

                Integer game_id_val = ActiveGameslRes.getInt(1);
                Date date_from_val = ActiveGameslRes.getDate(2);
                String player_log_val = ActiveGameslRes.getString(3);
                String area_size_val = ActiveGameslRes.getString(4);
                Integer cnt_players_val = ActiveGameslRes.getInt(5);
                Double sum_players_val = ActiveGameslRes.getDouble(6);
                    Timestamp last_activity_date_val = ActiveGameslRes.getTimestamp(7);

                newItem.getItemProperty(1).setValue(game_id_val);
                newItem.getItemProperty(2).setValue(date_from_val);
                newItem.getItemProperty(3).setValue(player_log_val);
                newItem.getItemProperty(4).setValue(area_size_val);
                newItem.getItemProperty(5).setValue(cnt_players_val);
                newItem.getItemProperty(6).setValue(sum_players_val);
                    newItem.getItemProperty(7).setValue(last_activity_date_val);

                }

        }catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
        }catch(Exception e) {
        //Handle errors for Class.forName
        e.printStackTrace();
        }

        ActiveGamesTable.setContainerDataSource(ActiveGamesContainer);
        ActiveGamesTable.setPageLength(15);

        ActiveGamesTable.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                Integer NumRow = (Integer) valueChangeEvent.getProperty().getValue();
                iGameId = (Integer) ActiveGamesContainer.getContainerProperty(NumRow,1).getValue();
            }
        });

        // Actions (context menu)
        ActiveGamesTable.addActionHandler(new Action.Handler() {
            public Action[] getActions(Object target, Object sender) {
                return ACTIONS_CONNECT;
            }

            public void handleAction(Action action, Object sender, Object target) {
                if (ACTION_CONNECT == action) {
                    //System.out.println("connected into  = " + iGameId);
                    if ((iGameId != null) && (iMainPanel.Is_Game_Create_Connect == 0)){
                        Notification.show("Подключено к игре: " + iGameId);
                        iMainPanel.addTab(new Label(String.valueOf(iGameId)), "Активная игра");
                        iMainPanel.Is_Game_Create_Connect = 1;
                        ActiveGamesTable.setSelectable(false);
                    } else {
                        if ((iGameId == null)) {
                            Notification.show("Активная игра не выбрана");
                        } else {
                            Notification.show("Активная игра уже создана");
                        }
                    }
                }
            }

        });

        setContent(ActiveGamesTable);
        setCaption("Активные игры");
        setSizeFull();

    }
}
