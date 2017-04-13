package com.jetbrains;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import static com.jetbrains.tAppCommonStatic.ResizeAvaImage;

/**
 * Created by kalistrat on 13.04.2017.
 */
public class tGameConnectLayout extends VerticalLayout {

    public tGameConnectLayout(){

        this.addComponent(new Label("Здесь будет форма для подключения к игре"));
        System.out.println(ResizeAvaImage());

    }
}
