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
    public String iUserLog;

    public TextField iWaitingTimeField;
    public TextField iCurrentPlayerBalance;
    public TextField iStepingPlayer;
    public Button MakeStepButton;
    public Button GameExitButton;


    public tGameRunningLayout(int eGameId,String eUserLog){

        this.iGameId = eGameId;
        this.iUserLog = eUserLog;

        iWaitingTimeField = new TextField("Время ожидания хода");
        iCurrentPlayerBalance = new TextField("Текущий игровой баланс");
        iStepingPlayer = new TextField("Игрок,выполняющий ход");

        iWaitingTimeField.addStyleName(ValoTheme.TEXTFIELD_TINY);
        iCurrentPlayerBalance.addStyleName(ValoTheme.TEXTFIELD_TINY);
        iStepingPlayer.addStyleName(ValoTheme.TEXTFIELD_TINY);

        iWaitingTimeField.setIcon(VaadinIcons.TIMER);
        iCurrentPlayerBalance.setIcon(VaadinIcons.COIN_PILES);
        iStepingPlayer.setIcon(VaadinIcons.USER_CLOCK);

        MakeStepButton = new Button("Выполнить ход");
        MakeStepButton.addStyleName(ValoTheme.BUTTON_LINK);
        MakeStepButton.addStyleName(ValoTheme.BUTTON_SMALL);
        MakeStepButton.setIcon(VaadinIcons.MONEY_EXCHANGE);

        GameExitButton = new Button("Покинуть игру");
        GameExitButton.addStyleName(ValoTheme.BUTTON_LINK);
        GameExitButton.addStyleName(ValoTheme.BUTTON_SMALL);
        GameExitButton.setIcon(VaadinIcons.EXIT);

        GameExitButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI.getCurrent().addWindow(new tGameLeftWindow(iGameId,iUserLog));
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
                        RightContentLayout.addComponent(new tGameAreaLayout(iGameId,iUserLog));
                    }

                    if (event.getProperty().getValue().equals("Результаты ходов игры")){
                        RightContentLayout.removeAllComponents();
                        RightContentLayout.addComponent(new tResultsGraphLayout(iGameId,iUserLog));
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

        UI.getCurrent().addPollListener(new UIEvents.PollListener() {
            @Override
            public void poll(UIEvents.PollEvent event) {
                //getLastUserGame(iUserLog);
                getStepingPlayer();
                getCurrentBalance();
                getWatingTime();
                iGameAreaLayout.iTrandChartLayout.refreshGraph();
                //System.out.println("do refresh..");
            }
        });

    }

    public static int getLastUserGame(String eUserLog){
        int gameid = 0;

        try {

            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement CurrentGameStmt = Con.prepareCall("{? = call f_current_game_by_user(?)}");
            CurrentGameStmt.registerOutParameter (1, Types.INTEGER);
            CurrentGameStmt.setString(2, eUserLog);

            CurrentGameStmt.execute();
            gameid = CurrentGameStmt.getInt(1);
            //System.out.println(gameid);
            Con.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

        return gameid;
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
            WatingTimeStmt.registerOutParameter (1, Types.TIME);
            WatingTimeStmt.setInt(2, iGameId);
            WatingTimeStmt.setString(3, iUserLog);

            WatingTimeStmt.execute();
            iWaitingTimeField.setValue(new SimpleDateFormat("mm:ss").format(WatingTimeStmt.getTime(1)));
            Con.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

    }

}
