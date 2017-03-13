package com.jetbrains;

import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.*;

import java.io.File;

/**
 * Created by SemenovNA on 08.08.2016.
 */
public class SpinnerTextField extends VerticalLayout {

    TextField tf = new TextField();
    Button pb = new Button(">");
    Button mb = new Button("<");

    public SpinnerTextField(){

        Label FieldName = new Label("Начальная ставка");
        tf.setEnabled(false);
        tf.setValue("100");


        pb.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Integer cur_val = Integer.parseInt(tf.getValue());
                Integer next_val = cur_val + 100;
                tf.setValue(String.valueOf(next_val));
            }
        });

        mb.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Integer cur_val = Integer.parseInt(tf.getValue());
                Integer next_val = cur_val - 100;
                tf.setValue(String.valueOf(next_val));
            }
        });

        pb.setSizeFull();
        mb.setSizeFull();
        HorizontalLayout bsec = new HorizontalLayout(mb,pb);
        bsec.setSizeFull();
        bsec.setSpacing(false);
        bsec.setExpandRatio(pb,1);
        bsec.setExpandRatio(mb,1);

        HorizontalLayout BotSec = new HorizontalLayout(tf,bsec);
        BotSec.setComponentAlignment(tf, Alignment.MIDDLE_LEFT);
        BotSec.setComponentAlignment(bsec,Alignment.MIDDLE_RIGHT);

        addComponents(FieldName,BotSec);
        setComponentAlignment(FieldName,Alignment.MIDDLE_CENTER);

    }
}
