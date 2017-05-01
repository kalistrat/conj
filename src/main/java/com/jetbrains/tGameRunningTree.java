package com.jetbrains;

import com.vaadin.data.fieldgroup.Caption;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Tree;

/**
 * Created by kalistrat on 28.04.2017.
 */
public class tGameRunningTree extends Tree {

    public tGameRunningTree() {


        this.addItem("Выполнение ходов игры");
        this.setItemIcon("Выполнение ходов игры", VaadinIcons.GAMEPAD);
        this.setChildrenAllowed("Выполнение ходов игры", false);
        this.addItem("Результаты ходов игры");
        this.setItemIcon("Результаты ходов игры", VaadinIcons.CHART);
        this.setChildrenAllowed("Результаты ходов игры", false);


        this.setItemStyleGenerator(new Tree.ItemStyleGenerator() {
            @Override
            public String getStyle(Tree tree, Object o) {
                return "captiontree";
            }
        });

        this.addStyleName("captiontree");


        //setContainerDataSource(this.TreeContainer);

        //Разворачиваю дерево
        for (Object itemId : this.getItemIds()) {
            this.expandItem(itemId);

        }

        this.select("Выполнение ходов игры");
    }
}
