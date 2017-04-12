package com.jetbrains;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ClassResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by kalistrat on 12.04.2017.
 */
public class tNewGameFormLayout extends VerticalLayout {

    public tNewGameFormLayout(){

        TextField GameBalanceField = new TextField("Начальный баланс игры :");
        GameBalanceField.setIcon(VaadinIcons.MONEY);

        TextField MaxPlayersField = new TextField("Предельное количество игроков :");
        MaxPlayersField.setIcon(VaadinIcons.GROUP);

        TextField MaxRatesField = new TextField("Количество ставок за один ход :");
        MaxRatesField.setIcon(VaadinIcons.COINS);


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


        OptionGroup GameModeSelect = new OptionGroup();
        //GameModeSelect.setIcon(VaadinIcons.USER_CHECK);
        GameModeSelect.addItem("Однопользовательская игра");
        GameModeSelect.setItemIcon("Однопользовательская игра",VaadinIcons.USER);

        GameModeSelect.addItem("Многопользовательская игра");
        GameModeSelect.setItemIcon("Многопользовательская игра",VaadinIcons.USERS);

        GameModeSelect.addStyleName(ValoTheme.OPTIONGROUP_SMALL);
        GameModeSelect.addStyleName(ValoTheme.OPTIONGROUP_HORIZONTAL);


        MenuBar oMenuBar = new MenuBar();
        //oMenuBar.addStyleName(ValoTheme.ME);


        VerticalLayout ContentLayout = new VerticalLayout(
                AttrGameHeader
                ,GameParametersFormLayout
                ,GameModeSelectHeader
                ,GameModeSelect
                //,GameAreaSelect
        );
        ContentLayout.setSpacing(true);

        this.addComponent(ContentLayout);


    }
}
