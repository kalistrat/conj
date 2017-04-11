package com.jetbrains;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Component;
import com.vaadin.ui.Tree;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by kalistrat on 11.04.2017.
 */
public class tConnectTree extends Tree {

    //public HierarchicalContainer TreeContainer;

    public tConnectTree(){

        //this.TreeContainer = tTreeGetData(eUserLog);

        //TreeContainer = new HierarchicalContainer();

//        TreeContainer.addContainerProperty(1, String.class, null);
//        TreeContainer.getItem(TreeContainer.addItem())
//                .getItemProperty(1).setValue("Создание новой игры");
//        TreeContainer.getItem(TreeContainer.addItem())
//                .getItemProperty(1).setValue("Подключение к игре");
//        TreeContainer.getItem(TreeContainer.addItem())
//                .getItemProperty(1).setValue("Приглашения в игру");

        //this.setCaption("Captionnn");
        this.addItem("Создание новой игры");
        this.setItemIcon("Создание новой игры", VaadinIcons.PLUS_SQUARE_LEFT_O);
        this.setChildrenAllowed("Создание новой игры", false);
        this.addItem("Подключение к игре");
        this.setItemIcon("Подключение к игре", VaadinIcons.PLUG);
        this.setChildrenAllowed("Подключение к игре", false);
        this.addItem("Приглашения в игру");
        this.setItemIcon("Приглашения в игру", VaadinIcons.CHAT);
        this.setChildrenAllowed("Приглашения в игру", false);

        this.setItemStyleGenerator(new ItemStyleGenerator() {
            @Override
            public String getStyle(Tree tree, Object o) {
                return "captiontree";
            }
        });

        this.addStyleName("captiontree");



        //setContainerDataSource(this.TreeContainer);

        //Разворачиваю дерево
        for (Object itemId: this.getItemIds()) {
            this.expandItem(itemId);

        }

        this.select("Создание новой игры");


    }

}
