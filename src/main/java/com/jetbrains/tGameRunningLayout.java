package com.jetbrains;

import com.vaadin.data.Property;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ClassResource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.sql.*;

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


    public tGameRunningLayout(int eGameId,String eUserLog){

        this.iGameId = eGameId;
        this.iUserLog = eUserLog;

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
        LeftContentLabel.setValue(VaadinIcons.PLAY_CIRCLE.getHtml());
        LeftContentLabel.addStyleName(ValoTheme.LABEL_SMALL);
        LeftContentLabel.addStyleName(ValoTheme.LABEL_COLORED);
        LeftContentLabel.setSizeUndefined();

        iGameRunningTree = new tGameRunningTree();

        iGameRunningTree.addListener(new Property.ValueChangeListener() {

            public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
                if(event.getProperty().getValue() != null)
                {

                    if (event.getProperty().getValue().equals("Приглашения в игру")){
                        RightContentLayout.removeAllComponents();
                        //RightContentLayout.addComponent(new tGameConnectLayout(iUserLog,(Integer) iMainTabSheet.getData()));
                    }

                    if (event.getProperty().getValue().equals("Подключение к игре")){
                        RightContentLayout.removeAllComponents();
                        //RightContentLayout.addComponent(new tGameInvitesLayout(iUserLog,iMainTabSheet));
                    }

                    if (event.getProperty().getValue().equals("Создание новой игры")){
                        RightContentLayout.removeAllComponents();
                        //RightContentLayout.addComponent(new tNewGameFormLayout(iUserLog,iMainTabSheet));
                    }

                }
            }
        });



        LeftContentLayout = new VerticalLayout(
                LeftContentLabel
                ,CubeImageLayout
                ,iGameRunningTree
        );

        LeftContentLayout.setMargin(new MarginInfo(true,false,false,false));
        LeftContentLayout.setComponentAlignment(CubeImageLayout,Alignment.MIDDLE_CENTER);
        LeftContentLayout.setComponentAlignment(LeftContentLabel,Alignment.MIDDLE_CENTER);
        LeftContentLayout.setSpacing(true);
        LeftContentLayout.setWidth("100%");

        iGameAreaLayout = new tGameAreaLayout(this.iGameId,this.iUserLog);


        RightContentLayout = new VerticalLayout(
                iGameAreaLayout
        );

        RightContentLayout.setMargin(true);


        HorizontalSplitPanel UserDataSection = new HorizontalSplitPanel();
        UserDataSection.setHeight("750px");
        UserDataSection.setWidth("870px");
        UserDataSection.setFirstComponent(LeftContentLayout);
        UserDataSection.setSecondComponent(RightContentLayout);
        UserDataSection.setSplitPosition(24f,UNITS_PERCENTAGE);
        //UserDataSection.setMinSplitPosition(24f,UNITS_PERCENTAGE);
        //UserDataSection.setMaxSplitPosition(24f,UNITS_PERCENTAGE);

        VerticalLayout ContentLayout = new VerticalLayout(UserDataSection);
        ContentLayout.setHeight("750px");
        ContentLayout.setWidth("870px");
        ContentLayout.addStyleName(ValoTheme.LAYOUT_CARD);



        this.addComponent(new Label());
        this.addComponent(ContentLayout);
        this.addComponent(new Label());

        this.setComponentAlignment(ContentLayout, Alignment.MIDDLE_CENTER);

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
}
