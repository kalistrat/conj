package com.jetbrains;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Tree;

/**
 * Created by kalistrat on 28.04.2017.
 */
public class tGameRunningTree extends Tree {

    public tGameRunningTree() {

        this.addItem("Выполнение ходов");
        this.setItemIcon("Выполнение ходов", VaadinIcons.GAMEPAD);
        this.setChildrenAllowed("Выполнение ходов", false);
        this.addItem("Результаты ходов");
        this.setItemIcon("Результаты ходов", VaadinIcons.CHART);
        this.setChildrenAllowed("Результаты ходов", false);


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

        this.select("Выполнение ходов");
    }
}
