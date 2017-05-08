package com.jetbrains;

import com.vaadin.data.util.converter.StringToIntegerConverter;
import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

import static com.jetbrains.tAppCommonStatic.StrToIntValue;

/**
 * Created by kalistrat on 08.05.2017.
 */
public class tGameConnectWindow extends Window {
    //tLeftGameTable iLeftGameTable;
    int iGameId;
    String iUserLog;
    Button ConnectButton;
    Button CloseButton;
    TabSheet iGameMenuTabSheet;
    TextField iGameBalanceField;
    tGameRunningLayout iGameRunningLayout;

    public tGameConnectWindow(int eGameId,String eUserLog,TabSheet eGameMenuTabSheet){

        iGameId = eGameId;
        iUserLog = eUserLog;
        iGameMenuTabSheet = eGameMenuTabSheet;


        this.setIcon(VaadinIcons.CONNECT);
        this.setCaption(" Подключение к игре");

        Label GameConnectHeader = new Label(
                "Производится подключение игрока "+iUserLog+" \n"
                        + "к игре №" +iGameId
        );

        GameConnectHeader.setContentMode(ContentMode.PREFORMATTED);
        GameConnectHeader.addStyleName(ValoTheme.LABEL_SMALL);

        iGameBalanceField = new TextField("Начальный игровой баланс");
        iGameBalanceField.addStyleName(ValoTheme.TEXTFIELD_SMALL);

        iGameBalanceField.setIcon(VaadinIcons.MONEY);

        StringToIntegerConverter plainIntegerConverter = new StringToIntegerConverter() {
            protected java.text.NumberFormat getFormat(Locale locale) {
                NumberFormat format = super.getFormat(locale);
                format.setGroupingUsed(false);
                return format;
            };
        };
        iGameBalanceField.setConverter(plainIntegerConverter);
        iGameBalanceField.addValidator(new IntegerRangeValidator("Значение может изменяться от 100 до 10000000", 100, 10000000));
        iGameBalanceField.setConversionError("Введённое значение не является целочисленным");
        iGameBalanceField.setNullRepresentation("");
        iGameBalanceField.setInputPrompt("введите целое число > 100");


        ConnectButton = new Button("Подключиться");
        ConnectButton.addStyleName(ValoTheme.BUTTON_TINY);
        ConnectButton.setIcon(VaadinIcons.CONNECT);
        ConnectButton.setData(this);

        ConnectButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                String sErrorMessage = "";

                if (StrToIntValue(iGameBalanceField.getValue()) == null) {
                    sErrorMessage = sErrorMessage + "Не задан начальный баланс игры\n";
                } else {

                    if ((StrToIntValue(iGameBalanceField.getValue()).intValue() < 100) || (StrToIntValue(iGameBalanceField.getValue()).intValue() > 10000000)) {
                        sErrorMessage = sErrorMessage + "Не задан начальный баланс игры\n";
                    }
                }

                if (!sErrorMessage.equals("")){
                    Notification.show("Ошибка подключения к игре:",
                            sErrorMessage,
                            Notification.Type.TRAY_NOTIFICATION);
                } else {

                    createGamePlayer(StrToIntValue(iGameBalanceField.getValue()));
                    iGameRunningLayout = new tGameRunningLayout(iGameId,iUserLog,iGameMenuTabSheet);
                    iGameMenuTabSheet.addTab(iGameRunningLayout, "Активная игра",VaadinIcons.PLAY_CIRCLE,2);
                    iGameMenuTabSheet.setData(iGameId);

                    Notification.show("Подключение произведено!",
                            null,
                            Notification.Type.TRAY_NOTIFICATION);

                    UI.getCurrent().removeWindow((tGameConnectWindow) clickEvent.getButton().getData());

                }

            }
        });

        CloseButton = new Button("Закрыть");
        CloseButton.addStyleName(ValoTheme.BUTTON_TINY);
        CloseButton.setIcon(VaadinIcons.EXIT);
        CloseButton.setData(this);

        CloseButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI.getCurrent().removeWindow((tGameConnectWindow) clickEvent.getButton().getData());
            }
        });

        HorizontalLayout ButtonsLayout = new HorizontalLayout(
                ConnectButton
                ,CloseButton
        );

        ButtonsLayout.setSizeUndefined();
        ButtonsLayout.setSpacing(true);

        VerticalLayout MessageLayout = new VerticalLayout(
                GameConnectHeader
                ,iGameBalanceField
        );
        MessageLayout.setSpacing(true);
        MessageLayout.setSizeUndefined();
        MessageLayout.setMargin(new MarginInfo(false,true,true,true));
        MessageLayout.setComponentAlignment(GameConnectHeader, Alignment.TOP_CENTER);
        MessageLayout.setComponentAlignment(iGameBalanceField, Alignment.MIDDLE_CENTER);
        MessageLayout.addStyleName(ValoTheme.LAYOUT_WELL);

        VerticalLayout WindowContentLayout = new VerticalLayout(
                MessageLayout
                ,ButtonsLayout
        );
        WindowContentLayout.setSizeUndefined();
        WindowContentLayout.setSpacing(true);
        WindowContentLayout.setMargin(true);
        WindowContentLayout.setComponentAlignment(ButtonsLayout, Alignment.BOTTOM_CENTER);

        this.setContent(WindowContentLayout);
        this.setSizeUndefined();
        this.setModal(true);
    }

    public void createGamePlayer(Integer InitialGameBalance){

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement createGameStmt = Con.prepareCall("{call p_game_player_insert(?, ?, ?)}");
            createGameStmt.setInt(1, iGameId);
            createGameStmt.setDouble(2,InitialGameBalance);
            createGameStmt.setString(3, iUserLog);
            createGameStmt.execute();

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
