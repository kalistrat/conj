package com.jetbrains;


import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by SemenovNA on 03.08.2016.
 */
public class GMainView extends CustomComponent implements View {

    public static final String NAME = "";

    String CurrentUsr;

    Button LogOutButton = new Button("Выйти", new Button.ClickListener() {
        @Override
        public void buttonClick(Button.ClickEvent event) {
            // "Logout" the user
            getSession().setAttribute("user", null);
            // Refresh this view, should redirect to login view
            getUI().getNavigator().navigateTo(NAME);
        }
    });

    TabSheet GameMenuTabSheet;

    public GMainView(){

    }

    public void enter(ViewChangeListener.ViewChangeEvent event) {

        CurrentUsr = (String) getSession().getAttribute("user");

        LogOutButton.addStyleName(ValoTheme.BUTTON_LINK);
        LogOutButton.setIcon(VaadinIcons.SIGN_OUT);

        Label GameNameHeader = new Label();
        GameNameHeader.setContentMode(ContentMode.HTML);
        GameNameHeader.setValue(VaadinIcons.MONEY_EXCHANGE.getHtml() + "    Коньюктура");
        //GameNameHeader.addStyleName(ValoTheme.LABEL_HUGE);
        //GameNameHeader.addStyleName("MAINHEADER");


        HorizontalLayout TopSectionLayout = new HorizontalLayout(
                new Label()
                //,GameNameHeader
                ,LogOutButton
        );
        //TopSectionLayout.setComponentAlignment(GameNameHeader,Alignment.MIDDLE_CENTER);
        TopSectionLayout.setComponentAlignment(LogOutButton,Alignment.MIDDLE_RIGHT);
        TopSectionLayout.setSpacing(true);

        TopSectionLayout.setWidth("100%");
        TopSectionLayout.setHeight("50px");

        GameMenuTabSheet = new TabSheet();
        tUserDataLayout oUserDataLayout = new tUserDataLayout(CurrentUsr);
        tMainGameConnectLayout oMainGameConnectLayout = new tMainGameConnectLayout(CurrentUsr);

        GameMenuTabSheet.addTab(oMainGameConnectLayout, "Подключение к игре", VaadinIcons.CONNECT);
        GameMenuTabSheet.addTab(oUserDataLayout, "Личные данные",VaadinIcons.HOME);
        GameMenuTabSheet.addTab(new Label("Здесь будет архив"), "История игр",VaadinIcons.ARCHIVE);


        VerticalLayout MainViewContentLayout = new VerticalLayout(
                TopSectionLayout
                ,GameMenuTabSheet
        );
        setCompositionRoot(MainViewContentLayout);
    }
}
