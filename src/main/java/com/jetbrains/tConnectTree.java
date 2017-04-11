package com.jetbrains;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Tree;

/**
 * Created by kalistrat on 11.04.2017.
 */
public class tConnectTree extends Tree {

    public HierarchicalContainer TreeContainer;

    public tConnectTree(){

        //this.TreeContainer = tTreeGetData(eUserLog);

        TreeContainer = new HierarchicalContainer();

        TreeContainer.addContainerProperty(1, String.class, null);
        TreeContainer.getItem(TreeContainer.addItem())
                .getItemProperty(1).setValue("Создание новой игры");
        TreeContainer.getItem(TreeContainer.addItem())
                .getItemProperty(1).setValue("Подключение к игре");
        TreeContainer.getItem(TreeContainer.addItem())
                .getItemProperty(1).setValue("Приглашения в игру");

        setItemCaptionPropertyId(1);

        setContainerDataSource(this.TreeContainer);

        //Разворачиваю дерево
        for (Object id : this.rootItemIds()) {
            this.expandItemsRecursively(id);
        }

        this.select(1);

         //Добавляю слушатель для каждого листочка дерева
        this.addListener(new Property.ValueChangeListener() {

            public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
                if(event.getProperty().getValue() != null)
                {
                    Item SelectedItem = TreeContainer.getItem(event.getProperty().getValue());

                }
            }
        });
    }
}
