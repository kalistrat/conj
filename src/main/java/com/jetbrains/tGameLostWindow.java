package com.jetbrains;

import com.vaadin.event.UIEvents;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Collection;

/**
 * Created by kalistrat on 08.05.2017.
 */
public class tGameLostWindow extends Window {

    tLeftGameTable iLeftGameTable;
    int iGameId;
    String iUserLog;
    Button CloseButton;
    TabSheet iGameMenuTabSheet;
    tGameRunningLayout iGameRunningLayout;


    public tGameLostWindow(int eGameId,String eUserLog,TabSheet eGameMenuTabSheet,tGameRunningLayout eGameRunningLayout){

        iGameId = eGameId;
        iUserLog = eUserLog;
        iGameMenuTabSheet = eGameMenuTabSheet;
        iGameRunningLayout = eGameRunningLayout;


        //tAppCommonStatic.closeGamePlayer(iGameId,iUserLog);
        iGameMenuTabSheet.removeTab(iGameMenuTabSheet.getTab(iGameRunningLayout));
        Collection<?> listeners = UI.getCurrent().getListeners(UIEvents.PollEvent.class);
        //System.out.println("listeners :" + listeners.size());

        for(Object listener : listeners){
            UI.getCurrent().removePollListener((UIEvents.PollListener) listener);
        }
        iGameRunningLayout.removeAllComponents();
        iGameRunningLayout = null;
        System.gc();
        iGameMenuTabSheet.setData(0);



        this.setIcon(VaadinIcons.FLAG_CHECKERED);
        this.setCaption(" Вы проиграли и покидаете игру");

        Label LeftGameHeader = new Label(
                "В результате выхода из игры,\n"
                        + "Ваш общий баланс будет увеличен.\n"
                        + "Составляющие перечисляемой\n"
                        + "суммы приведены ниже:"
        );
        LeftGameHeader.setContentMode(ContentMode.PREFORMATTED);
        LeftGameHeader.addStyleName(ValoTheme.LABEL_SMALL);

        iLeftGameTable = new tLeftGameTable(iGameId,iUserLog);

        CloseButton = new Button("Закрыть окно");

        CloseButton.setData(this);

        CloseButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI.getCurrent().removeWindow((tGameLostWindow) clickEvent.getButton().getData());
            }
        });

        HorizontalLayout ButtonsLayout = new HorizontalLayout(
                CloseButton
        );

        ButtonsLayout.setSizeUndefined();
        ButtonsLayout.setSpacing(true);

        VerticalLayout MessageLayout = new VerticalLayout(
                LeftGameHeader
                ,iLeftGameTable
        );
        MessageLayout.setSpacing(true);
        MessageLayout.setSizeUndefined();
        MessageLayout.setMargin(new MarginInfo(false,true,true,true));
        MessageLayout.setComponentAlignment(LeftGameHeader, Alignment.TOP_CENTER);
        MessageLayout.setComponentAlignment(iLeftGameTable, Alignment.MIDDLE_CENTER);
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

}
