package com.jetbrains;


import com.vaadin.data.fieldgroup.Caption;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by kalistrat on 13.04.2017.
 */
public class tGameConnectLayout extends VerticalLayout {

    public tGameConnectLayout() {

        tUploadButtonWindow oUploadButtonWindow = new tUploadButtonWindow();


        addComponent(oUploadButtonWindow.upload);

        this.setMargin(true);

    }
}
