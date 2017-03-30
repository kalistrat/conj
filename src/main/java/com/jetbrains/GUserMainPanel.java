package com.jetbrains;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by SemenovNA on 03.08.2016.
 */
public class GUserMainPanel extends TabSheet {

    Panel MainDataPanel = new Panel();
    Panel GameDataPanel = new Panel();
    Integer Is_Game_Create_Connect;
    tUserDataLayout oUserDataLayout;

    public GUserMainPanel(String CurUser){
        Is_Game_Create_Connect = 0;

        UserDataPanel iUserDataPanel = new UserDataPanel(CurUser);
        GActiveGamesPanel iGActiveGamesPanel = new GActiveGamesPanel(this);
        GCreateGameAccordion iGCreateGameAccordion = new GCreateGameAccordion(this,CurUser);
        Panel iCreateGame = new Panel(iGCreateGameAccordion);

        VerticalLayout MidSec = new VerticalLayout(iGActiveGamesPanel,iCreateGame);
        MidSec.setSizeFull();

        VerticalLayout RightSec = new VerticalLayout();
        RightSec.setSizeFull();

        HorizontalLayout FullSec = new HorizontalLayout(iUserDataPanel,MidSec,RightSec);
        FullSec.setSizeFull();
        FullSec.setExpandRatio(iUserDataPanel,1);
        FullSec.setExpandRatio(MidSec,4);
        FullSec.setExpandRatio(RightSec,1);

        MainDataPanel.setContent(FullSec);

        oUserDataLayout = new tUserDataLayout();



//        Panel MainDataPanel = new Panel(FullSec);
//        Panel GameDataPanel = new Panel();

        addTab(MainDataPanel, "Подключение к игре");
        addTab(oUserDataLayout, "Личные данные");
        addTab(GameDataPanel, "История игр");
        setSizeFull();

    }
}
