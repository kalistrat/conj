package com.jetbrains;


import com.vaadin.ui.*;

import java.sql.*;
import java.util.List;

/**
 * Created by SemenovNA on 09.08.2016.
 */
public class g_step_layout extends VerticalLayout {

    BalanceField CurrentBalanceField;
    TextField WaitingTimeField = new TextField("Время ожидания хода");
    StepUserField StepingUserField;
    Button StepButton = new Button("Выполнить ход");
    Button OutGameButton = new Button("Покинуть игру");


    TimerMinSec Tim = new TimerMinSec(0,0);

    static final private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final private String DB_URL = "jdbc:mysql://localhost/conjuncture";
    static final private String USER = "gumbler";
    static final private String PASS = "tutunia";

    static private CallableStatement stmt = null;

    public Integer iGameId;
    public String iPlayerLog;
    g_area_table jGAT;
    g_user_rates_table jGURT;
    g_trand_chart jGTRCH;
    RateLayout jGRATCH;
    g_results_chart jResChart;

    StepButtonEnableThread StepButThr;
    TimerThread TimThr;


    public g_step_layout(g_area_table GAT,g_user_rates_table GURT,g_trand_chart GTRCH,RateLayout GRATCH,g_results_chart GRESCHART){


        this.iGameId = GAT.InsGameId;
        this.jGURT = GURT;
        this.jGTRCH = GTRCH;
        this.iPlayerLog = GAT.InsUserName;
        this.jGAT = GAT;
        this.jGRATCH = GRATCH;
        this.jResChart = GRESCHART;

        WaitingTimeField.setValue(Tim.getStrTime());
        StepButton.setEnabled(false);

        CurrentBalanceField = new BalanceField(this.iGameId,this.iPlayerLog);
        CurrentBalanceField.setCaption("Ваш текущий баланс");

        StepingUserField = new StepUserField(this.iGameId);
        StepingUserField.setCaption("Игрок, выполняющий ход");



        StepButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                TimThr.interrupt();
                try {
                    Class.forName(JDBC_DRIVER);
                    Connection ConMS = DriverManager.getConnection(DB_URL,USER,PASS);
                    CallableStatement StepStmt = ConMS.prepareCall("{call p_make_game_step_n(?, ?)}");
                    StepStmt.setInt(1, iGameId);
                    StepStmt.setString(2, iPlayerLog);
                    StepStmt.execute();
                    ConMS.close();
                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception e) {
                    //Handle errors for Class.forName
                    e.printStackTrace();
                }

                clickEvent.getButton().setEnabled(false);

                Tim.ToZeros();
                WaitingTimeField.setValue(Tim.getStrTime());

                StepButThr = new StepButtonEnableThread();
                StepButThr.start();
            }
        });

        Window subwindow = new Window("Выход из игры");
        // let's give it a size (optional)
        subwindow.setWidth("300px");
        subwindow.setHeight("200px");

        Button close = new Button("Закрыть", new Button.ClickListener() {
            // inline click-listener
            public void buttonClick(Button.ClickEvent event) {
                // close the window by removing it from the parent window
                subwindow.close();
            }
        });

        VerticalLayout windowlay = new VerticalLayout();
        windowlay.addComponent(close);
        subwindow.setContent(windowlay);

        OutGameButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    Class.forName(JDBC_DRIVER);
                    Connection ConMS1 = DriverManager.getConnection(DB_URL,USER,PASS);

                    ConMS1.close();
                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception e) {
                    //Handle errors for Class.forName
                    e.printStackTrace();
                }

                   UI.getCurrent().addWindow(subwindow);

                // Center the window
                subwindow.center();

           }
        });


        WaitingTimeField.setEnabled(false);
        CurrentBalanceField.setEnabled(false);
        StepingUserField.setEnabled(false);


        StepButThr = new StepButtonEnableThread();
        StepButThr.start();
        HorizontalLayout LayFields = new HorizontalLayout(CurrentBalanceField,WaitingTimeField,StepingUserField);
        HorizontalLayout LayButtons = new HorizontalLayout(StepButton,OutGameButton);
        LayFields.setSpacing(true);
        LayButtons.setSpacing(true);

        addComponent(LayFields);
        addComponent(LayButtons);

        setSpacing(true);
    }

    class TimerThread extends Thread {
        int count2 = 0;

        @Override
        public void run() {
            try {
                // Update the data for a while
                while (count2 < 1000) {
                    Thread.sleep(1000);

                    getUI().access(new Runnable() {
                        @Override
                        public void run() {
                            count2=count2+1;
                            Tim.AddOneSecond();
                            WaitingTimeField.setValue(Tim.getStrTime());
                            getUI().push();
                        }
                    });

                }

                try{
                    Class.forName(JDBC_DRIVER);
                    Connection conn1 = DriverManager.getConnection(DB_URL,USER,PASS);

//                    List<String> buys1 = jGAT.engage_index;
//                    XStream xStream1 = new XStream(new DomDriver());
//                    String buysAsXML1 = xStream1.toXML(buys1);
//                    System.out.println("buysAsXML1 = " + buysAsXML1);

                    CallableStatement StepStmt = conn1.prepareCall("{call p_make_game_step_n(?, ?)}");
                    StepStmt.setInt(1, iGameId);
                    StepStmt.setString(2, iPlayerLog);
                    //StepStmt.setString(3, buysAsXML1);

                    StepStmt.execute();
                    conn1.close();
                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception e) {
                    //Handle errors for Class.forName
                    e.printStackTrace();
                }

                StepButton.setEnabled(false);
                Tim.ToZeros();
                WaitingTimeField.setValue(Tim.getStrTime());
                getUI().push();
                StepButThr = new StepButtonEnableThread();
                StepButThr.start();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                //assert false;

            }
        }

    }

    class StepButtonEnableThread extends Thread {
        int IsMyTurn = 0;

        @Override
        public void run() {
            try {
                // Update the data for a while
                while (IsMyTurn == 0) {
                    Thread.sleep(1000);

                    getUI().access(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Class.forName(JDBC_DRIVER);
                                Connection conn2 = DriverManager.getConnection(DB_URL,USER,PASS);
                                CallableStatement TurnStmt = conn2.prepareCall("{? = call f_itsmyturn(?, ?)}");
                                TurnStmt.registerOutParameter (1, Types.INTEGER);
                                TurnStmt.setInt(2, iGameId);
                                TurnStmt.setString(3, iPlayerLog);
                                TurnStmt.execute();
                                IsMyTurn = TurnStmt.getInt(1);
                                jGAT.AreaContainerRefresh(0);
                                CurrentBalanceField.RefreshValue();
                                StepingUserField.RefreshValue();
                                jGURT.RefreshData();
                                jGTRCH.refreshGraph();
                                jGRATCH.refreshMultyGraph();
                                jResChart.refreshResGraph();
                                conn2.close();
                            }catch(SQLException se){
                                //Handle errors for JDBC
                                se.printStackTrace();
                            }catch(Exception e) {
                                //Handle errors for Class.forName
                                e.printStackTrace();
                            }
                            getUI().push();
                        }
                    });

                }

                StepButton.setEnabled(true);
                jGAT.AreaContainerRefresh(1);
                CurrentBalanceField.RefreshValue();
                StepingUserField.RefreshValue();
                jGURT.RefreshData();
                jGTRCH.refreshGraph();
                jGRATCH.refreshMultyGraph();
                jResChart.refreshResGraph();
                getUI().push();
                //System.out.println("IsMyTurn = " + IsMyTurn);
                TimThr = new TimerThread();
                TimThr.start();

            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                //assert false;
            }
        }
    }
}
