package com.jetbrains;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by kalistrat on 13.04.2017.
 */
public class tGameInvitesLayout extends VerticalLayout {

    String iUserLog;
    Table InComingInvitesTable;
    Table OutComingInvitesTable;
    IndexedContainer InComingInvitesContainer;
    IndexedContainer OutComingInvitesContainer;
    TabSheet iMainTabSheet;

    public tGameInvitesLayout(String eUserLog,TabSheet eMainTabSheet){

        iUserLog = eUserLog;
        iMainTabSheet = eMainTabSheet;

        InComingInvitesTable = new Table();

        InComingInvitesTable.setColumnHeader(1, "№<br/>игры");
        InComingInvitesTable.setColumnHeader(2, "От кого");
        InComingInvitesTable.setColumnHeader(3, "Дата");
        InComingInvitesTable.setColumnHeader(4, "Статус");
        InComingInvitesTable.setColumnHeader(5, "");

        InComingInvitesContainer = new IndexedContainer();

        InComingInvitesContainer.addContainerProperty(1, Integer.class, null);
        InComingInvitesContainer.addContainerProperty(2, String.class, null);
        InComingInvitesContainer.addContainerProperty(3, String.class, null);
        InComingInvitesContainer.addContainerProperty(4, String.class, null);
        InComingInvitesContainer.addContainerProperty(5, VerticalLayout.class, null);

        GetInComingInvites();

        InComingInvitesTable.setContainerDataSource(InComingInvitesContainer);

        InComingInvitesTable.setPageLength(3);


        InComingInvitesTable.setCellStyleGenerator(new Table.CellStyleGenerator() {
            @Override
            public String getStyle(Table components, Object itemId, Object columnId) {
                return "mytabletext";
            }
        });

        InComingInvitesTable.addStyleName(ValoTheme.TABLE_SMALL);
        InComingInvitesTable.addStyleName(ValoTheme.TABLE_COMPACT);
        InComingInvitesTable.addStyleName("mytabletext");

        Label InComingInvitesHeader = new Label();
        InComingInvitesHeader.setContentMode(ContentMode.HTML);
        InComingInvitesHeader.setValue(VaadinIcons.ENVELOPE_OPEN_O.getHtml() + " Входящие приглашения");
        InComingInvitesHeader.addStyleName(ValoTheme.LABEL_SMALL);
        InComingInvitesHeader.addStyleName(ValoTheme.LABEL_COLORED);


        OutComingInvitesTable = new Table();

        OutComingInvitesTable.setColumnHeader(1, "№<br/>игры");
        OutComingInvitesTable.setColumnHeader(2, "Кому");
        OutComingInvitesTable.setColumnHeader(3, "Дата");
        OutComingInvitesTable.setColumnHeader(4, "Статус");
        OutComingInvitesTable.setColumnHeader(5, "");

        OutComingInvitesContainer = new IndexedContainer();

        OutComingInvitesContainer.addContainerProperty(1, Integer.class, null);
        OutComingInvitesContainer.addContainerProperty(2, String.class, null);
        OutComingInvitesContainer.addContainerProperty(3, String.class, null);
        OutComingInvitesContainer.addContainerProperty(4, String.class, null);
        OutComingInvitesContainer.addContainerProperty(5, Button.class, null);

        GetOutComingInvites();

        OutComingInvitesTable.setContainerDataSource(OutComingInvitesContainer);

        OutComingInvitesTable.setPageLength(3);


        OutComingInvitesTable.setCellStyleGenerator(new Table.CellStyleGenerator() {
            @Override
            public String getStyle(Table components, Object itemId, Object columnId) {
                return "mytabletext";
            }
        });

        OutComingInvitesTable.addStyleName(ValoTheme.TABLE_SMALL);
        OutComingInvitesTable.addStyleName(ValoTheme.TABLE_COMPACT);
        OutComingInvitesTable.addStyleName("mytabletext");

        Label OutComingInvitesHeader = new Label();
        OutComingInvitesHeader.setContentMode(ContentMode.HTML);
        OutComingInvitesHeader.setValue(VaadinIcons.ENVELOPE_OPEN.getHtml() + " Исходящие приглашения");
        OutComingInvitesHeader.addStyleName(ValoTheme.LABEL_SMALL);
        OutComingInvitesHeader.addStyleName(ValoTheme.LABEL_COLORED);


        VerticalLayout ContentLayout = new VerticalLayout(
                InComingInvitesHeader
                ,InComingInvitesTable
                ,new Label()
                ,OutComingInvitesHeader
                ,OutComingInvitesTable

        );
        ContentLayout.setSpacing(true);

        this.addComponent(ContentLayout);


    }

    public void GetInComingInvites() {

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            String InComingInvitesSql = "select i.invite_id\n" +
                    ",i.game_id\n" +
                    ",outp.player_log\n" +
                    ",i.date_from\n" +
                    ",i.status_value\n" +
                    "from invites i\n" +
                    "join player inp on inp.player_id=i.player_to\n" +
                    "join player outp on outp.player_id=i.player_from\n" +
                    "where inp.player_log=?";

            PreparedStatement InComingInvitesStmt = Con.prepareStatement(InComingInvitesSql);
            InComingInvitesStmt.setString(1,this.iUserLog);
            ResultSet InComingInvitesRes = InComingInvitesStmt.executeQuery();

            while (InComingInvitesRes.next()) {

                Item newItem = InComingInvitesContainer.getItem(InComingInvitesContainer.addItem());

                Button AcceptButton = new Button("Подтвердить");
                AcceptButton.setIcon(VaadinIcons.PLUG);
                AcceptButton.addStyleName(ValoTheme.BUTTON_LINK);
                AcceptButton.addStyleName(ValoTheme.BUTTON_TINY);
                //AcceptButton.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
                //AcceptButton.addStyleName("greenicon");
                AcceptButton.setHeight("20px");
                AcceptButton.setWidth("120px");
                AcceptButton.setData(InComingInvitesRes.getInt(1));

                Button CancelButton = new Button("Отклонить");
                CancelButton.setIcon(VaadinIcons.CLOSE_CIRCLE_O);
                CancelButton.addStyleName(ValoTheme.BUTTON_LINK);
                CancelButton.addStyleName(ValoTheme.BUTTON_TINY);
                //CancelButton.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
                //CancelButton.addStyleName("redicon");
                CancelButton.setHeight("20px");
                CancelButton.setWidth("120px");
                CancelButton.setData(InComingInvitesRes.getInt(1));

                VerticalLayout TableCellLayout = new VerticalLayout(
                        AcceptButton
                        ,CancelButton
                );
                TableCellLayout.setSizeUndefined();
                TableCellLayout.setSpacing(true);


                newItem.getItemProperty(1).setValue(InComingInvitesRes.getInt(2));
                newItem.getItemProperty(2).setValue(InComingInvitesRes.getString(3));
                newItem.getItemProperty(3).setValue(df.format(new java.util.Date(InComingInvitesRes.getTimestamp(4).getTime())));
                newItem.getItemProperty(4).setValue(InComingInvitesRes.getString(5));
                newItem.getItemProperty(5).setValue(TableCellLayout);


            }

            Con.close();

        } catch (SQLException se3) {
            //Handle errors for JDBC
            se3.printStackTrace();
        } catch (Exception e13) {
            //Handle errors for Class.forName
            e13.printStackTrace();
        }


    }

    public void GetOutComingInvites() {

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            String OutComingInvitesSql = "select i.invite_id\n" +
                    ",i.game_id\n" +
                    ",inp.player_log\n" +
                    ",i.date_from\n" +
                    ",i.status_value\n" +
                    "from invites i\n" +
                    "join player inp on inp.player_id=i.player_to\n" +
                    "join player outp on outp.player_id=i.player_from\n" +
                    "where outp.player_log=?";

            PreparedStatement OutComingInvitesStmt = Con.prepareStatement(OutComingInvitesSql);
            OutComingInvitesStmt.setString(1,this.iUserLog);
            ResultSet OutComingInvitesRes = OutComingInvitesStmt.executeQuery();

            while (OutComingInvitesRes.next()) {

                Item newItem = OutComingInvitesContainer.getItem(OutComingInvitesContainer.addItem());

                Button AcceptButton = new Button("Подтвердить");
                AcceptButton.setIcon(VaadinIcons.PLUG);
                AcceptButton.addStyleName(ValoTheme.BUTTON_LINK);
                AcceptButton.addStyleName(ValoTheme.BUTTON_TINY);
                AcceptButton.setHeight("20px");
                AcceptButton.setData(OutComingInvitesRes.getInt(1));


                newItem.getItemProperty(1).setValue(OutComingInvitesRes.getInt(2));
                newItem.getItemProperty(2).setValue(OutComingInvitesRes.getString(3));
                newItem.getItemProperty(3).setValue(df.format(new java.util.Date(OutComingInvitesRes.getTimestamp(4).getTime())));
                newItem.getItemProperty(4).setValue(OutComingInvitesRes.getString(5));
                newItem.getItemProperty(5).setValue(AcceptButton);


            }

            Con.close();

        } catch (SQLException se3) {
            //Handle errors for JDBC
            se3.printStackTrace();
        } catch (Exception e13) {
            //Handle errors for Class.forName
            e13.printStackTrace();
        }


    }

}
