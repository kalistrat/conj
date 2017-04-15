package com.jetbrains;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by kalistrat on 15.04.2017.
 */
public class tUploadWindow extends Window {

    public HorizontalLayout ProcessingLayout;
    public Label status;
    public ProgressBar pi;
    public Button cancelProcessing;
    public tUploadButtonWindow iUploadButtonWindow;

    public tUploadWindow(tUploadButtonWindow MyUploadButtonWindow){

        iUploadButtonWindow = MyUploadButtonWindow;
        cancelProcessing = new Button("Закрыть");
        cancelProcessing.setIcon(VaadinIcons.CLOSE_CIRCLE);

        cancelProcessing.setData(this);
        cancelProcessing.addStyleName(ValoTheme.BUTTON_SMALL);
        cancelProcessing.addStyleName(ValoTheme.BUTTON_LINK);

        status = new Label();
        pi = new ProgressBar();
        status.addStyleName(ValoTheme.LABEL_SMALL);

        this.setIcon(VaadinIcons.UPLOAD);
        this.setCaption(" Загрузка файла");

        ProcessingLayout = new HorizontalLayout(
            pi
            ,cancelProcessing
        );
        ProcessingLayout.setSpacing(true);
        ProcessingLayout.setComponentAlignment(pi, Alignment.MIDDLE_LEFT);
        ProcessingLayout.setSizeUndefined();


        cancelProcessing.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                ((tUploadWindow) clickEvent.getButton().getData()).close();
            }
        });


        VerticalLayout WindowContentLayout = new VerticalLayout(
                status
                ,ProcessingLayout
        );
        WindowContentLayout.setSpacing(true);
        WindowContentLayout.setMargin(true);
        WindowContentLayout.setComponentAlignment(ProcessingLayout,Alignment.MIDDLE_CENTER);
        WindowContentLayout.setComponentAlignment(status,Alignment.TOP_RIGHT);
        WindowContentLayout.addStyleName(ValoTheme.LAYOUT_WELL);


        this.setContent(WindowContentLayout);
        this.setSizeUndefined();
        this.setModal(true);


    }
}
