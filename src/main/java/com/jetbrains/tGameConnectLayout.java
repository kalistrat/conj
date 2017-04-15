package com.jetbrains;


import com.vaadin.ui.*;



/**
 * Created by kalistrat on 13.04.2017.
 */
public class tGameConnectLayout extends VerticalLayout {

    String iUserLog;

    public tGameConnectLayout(String eUserLog) {

        iUserLog = eUserLog;
        tUploadButtonWindow oUploadButtonWindow = new tUploadButtonWindow(this.iUserLog);
        addComponent(oUploadButtonWindow.upload);
        this.setMargin(true);

    }
}
