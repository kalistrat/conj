package com.jetbrains;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;
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

    public GMainView(){

    }

    public void enter(ViewChangeListener.ViewChangeEvent event) {

        CurrentUsr = (String) getSession().getAttribute("user");

        setSizeFull();

        GUserMainPanel GUserMainPanelIns = new GUserMainPanel(CurrentUsr);
        LogOutButton.addStyleName(ValoTheme.BUTTON_LINK);

        VerticalLayout GMainViewLayOut = new VerticalLayout();
        GMainViewLayOut.setSizeFull();

        GMainViewLayOut.addComponent(LogOutButton);
        GMainViewLayOut.addComponent(GUserMainPanelIns);
        GMainViewLayOut.setComponentAlignment(LogOutButton, Alignment.TOP_RIGHT);

        GMainViewLayOut.setExpandRatio(LogOutButton,1);
        GMainViewLayOut.setExpandRatio(GUserMainPanelIns,17);

        setCompositionRoot(GMainViewLayOut);
    }
}
