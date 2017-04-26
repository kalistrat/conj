package com.jetbrains;

import com.vaadin.data.util.converter.StringToIntegerConverter;
import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ClassResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.sql.*;

import static com.jetbrains.tAppCommonStatic.StrToIntValue;

/**
 * Created by kalistrat on 12.04.2017.
 */
public class tNewGameFormLayout extends VerticalLayout {

    Button CreateTheGameButton;
    TextField GameBalanceField;
    tSelectGameAreaGrid iSelectGameAreaGrid;
    String iUserLog;
    Integer iGameId;
    TabSheet iMainTabSheet;


    public tNewGameFormLayout(String eUserLog,TabSheet eMainTabSheet){

        iUserLog = eUserLog;
        iMainTabSheet = eMainTabSheet;

        GameBalanceField = new TextField("Начальный баланс игры :");
        GameBalanceField.setIcon(VaadinIcons.MONEY);
        GameBalanceField.setConverter(new StringToIntegerConverter());
        GameBalanceField.addValidator(new IntegerRangeValidator("Значение может изменяться от 100 до 10000000", 100, 10000000));
        GameBalanceField.setConversionError("Введённое значение не является целочисленным");
        GameBalanceField.setNullRepresentation("");
        GameBalanceField.setInputPrompt("введите целое число > 100");
        //GameBalanceField.setValue("");

        TextField MaxPlayersField = new TextField("Предельное количество игроков :");
        MaxPlayersField.setIcon(VaadinIcons.GROUP);
        MaxPlayersField.setEnabled(false);
        MaxPlayersField.setInputPrompt("введите целое число > 1");

        TextField MaxRatesField = new TextField("Количество ставок за один ход :");
        MaxRatesField.setIcon(VaadinIcons.COINS);
        MaxRatesField.setEnabled(false);
        MaxRatesField.setInputPrompt("введите целое число > 1");


        FormLayout GameParametersFormLayout = new FormLayout(
                GameBalanceField
                ,MaxPlayersField
                ,MaxRatesField
        );
        GameParametersFormLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);

        Label AttrGameHeader = new Label();
        AttrGameHeader.setContentMode(ContentMode.HTML);
        AttrGameHeader.setValue(VaadinIcons.START_COG.getHtml()+" Основные параметры игры");
        AttrGameHeader.addStyleName(ValoTheme.LABEL_SMALL);
        AttrGameHeader.addStyleName(ValoTheme.LABEL_COLORED);

        Label GameModeSelectHeader = new Label();
        GameModeSelectHeader.setContentMode(ContentMode.HTML);
        GameModeSelectHeader.setValue(VaadinIcons.USER_CHECK.getHtml()+" Режим игры");
        GameModeSelectHeader.addStyleName(ValoTheme.LABEL_SMALL);
        GameModeSelectHeader.addStyleName(ValoTheme.LABEL_COLORED);

        Label GameAreaSelectHeader = new Label();
        GameAreaSelectHeader.setContentMode(ContentMode.HTML);
        GameAreaSelectHeader.setValue(VaadinIcons.GRID_SMALL.getHtml()+" Размер игрового поля");
        GameAreaSelectHeader.addStyleName(ValoTheme.LABEL_SMALL);
        GameAreaSelectHeader.addStyleName(ValoTheme.LABEL_COLORED);


        OptionGroup GameModeSelect = new OptionGroup();
        GameModeSelect.addItem("Однопользовательская игра");
        GameModeSelect.setItemIcon("Однопользовательская игра",VaadinIcons.USER);
        GameModeSelect.addItem("Многопользовательская игра");
        GameModeSelect.setItemIcon("Многопользовательская игра",VaadinIcons.USERS);
        GameModeSelect.addStyleName(ValoTheme.OPTIONGROUP_SMALL);
        GameModeSelect.addStyleName(ValoTheme.OPTIONGROUP_HORIZONTAL);
        GameModeSelect.select("Однопользовательская игра");
        GameModeSelect.setNullSelectionAllowed(false);

        iSelectGameAreaGrid = new tSelectGameAreaGrid();


        CreateTheGameButton = new Button("Создать игру");
        CreateTheGameButton.setIcon(VaadinIcons.PLAY);
        CreateTheGameButton.addStyleName(ValoTheme.BUTTON_LINK);
        CreateTheGameButton.addStyleName(ValoTheme.BUTTON_SMALL);

        CreateTheGameButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                String GameModeVal = (String) GameModeSelect.getValue();
                String GameAreaType = iSelectGameAreaGrid.SelectedAreaType;

                String sErrorMessage = "";

                if (GameModeVal == null){
                    sErrorMessage = "Не выбран режим игры\n";
                }

                if (GameAreaType.equals("")) {
                    sErrorMessage = sErrorMessage + "Не выбран размер игрового поля\n";
                }

                if (StrToIntValue(GameBalanceField.getValue()) == null) {
                    sErrorMessage = sErrorMessage + "Не задан начальный баланс игры";
                }

                if (!sErrorMessage.equals("")){
                    Notification.show("Ошибка создания новой игры:",
                            sErrorMessage,
                            Notification.Type.TRAY_NOTIFICATION);
                } else {

                    iGameId = fNewGameCreate(GameAreaType,StrToIntValue(GameBalanceField.getValue()),GameModeVal);
                    System.out.println("iGameId " + iGameId);

                    Notification.show("Новая игра создана!",
                            null,
                            Notification.Type.TRAY_NOTIFICATION);
                }

            }
        });

        VerticalLayout ContentLayout = new VerticalLayout(
                AttrGameHeader
                ,GameParametersFormLayout
                ,GameModeSelectHeader
                ,GameModeSelect
                ,new Label()
                ,GameAreaSelectHeader
                ,iSelectGameAreaGrid
                ,new Label()
                ,CreateTheGameButton
        );
        ContentLayout.setSpacing(true);

        this.addComponent(ContentLayout);


    }

    public int fNewGameCreate(String GameSize,Integer InitialBalanceValue,String GameMode)  {

        int iGameId = 0;
        int IntGameSize = 0;
        int IsSingleGame = 0;

        if (GameSize.equals("6x6")){
            IntGameSize = 6;
        }
        if (GameSize.equals("8x8")){
            IntGameSize = 8;
        }
        if (GameSize.equals("10x10")){
            IntGameSize = 10;
        }

        if (GameMode.equals("Однопользовательская игра")) {
            IsSingleGame = 1;
        }

        try {

            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement CreateGameStmt = Con.prepareCall("{? = call f_game_create(?, ?, ?, ?, ?)}");
            CreateGameStmt.registerOutParameter (1, Types.INTEGER);
            CreateGameStmt.setString(2, this.iUserLog);
            CreateGameStmt.setInt(3, IntGameSize);
            CreateGameStmt.setDouble(4, InitialBalanceValue);
            CreateGameStmt.setString(5, this.iUserLog + "1");
            CreateGameStmt.setInt(6, IsSingleGame);

            CreateGameStmt.execute();
            iGameId = CreateGameStmt.getInt(1);
            Con.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

        return iGameId;
    }

}
