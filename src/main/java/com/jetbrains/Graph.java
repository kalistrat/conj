package com.jetbrains;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.hezamu.canvas.Canvas;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by kalistrat on 08.09.2016.
 */
public class Graph extends VerticalLayout {
    Canvas Cnvs;
    //Label TitleStr;

    public Graph(String sTitle,String xTitle,String yTitle,List<Double> Xvals,List<Double> Yvals,String graphColor) {

        //TitleStr = new Label(sTitle);
        Cnvs = new Canvas();

        int GraphWidth = 300;
        int GraphHeight = 150;
        int GraphNx = 10;
        int GraphNy = 4;
        int PadVal = 120;

        Cnvs.setWidth(String.valueOf(GraphWidth+PadVal)+"px");
        Cnvs.setHeight(String.valueOf(GraphHeight+PadVal)+"px");

        Double MaxYval = MaxAbsValList(Yvals);

        Double MaxXval = MaxAbsValList(Xvals);

        Cnvs.beginPath();
        Cnvs.setLineWidth(0.5);
        Cnvs.setStrokeStyle("black");

        int StepX = (int) Math.round(GraphWidth/GraphNx);
        int StepY = (int) Math.round(GraphHeight/GraphNy);
        GraphWidth = StepX*GraphNx;
        GraphHeight = StepY*GraphNy;

        double YScale = Math.abs((2*MaxYval)/GraphHeight);
        double XScale = Math.abs(MaxXval/GraphWidth);

        for (int i = 0; i<GraphNx+1; i++ ) {
            Cnvs.moveTo(StepX*i+Math.round(PadVal/2), Math.round(PadVal/2));
            Cnvs.lineTo(StepX*i+Math.round(PadVal/2), GraphHeight+Math.round(PadVal/2));
        }

        for (int j = 0; j<GraphNy+1; j++ ) {
            Cnvs.moveTo(Math.round(PadVal/2), StepY*j+Math.round(PadVal/2));
            Cnvs.lineTo(GraphWidth+Math.round(PadVal/2), StepY*j+Math.round(PadVal/2));
        }
        Cnvs.stroke();
        Cnvs.closePath();

        Cnvs.beginPath();
        Cnvs.setLineWidth(3);
        Cnvs.setStrokeStyle(graphColor);
        Cnvs.moveTo(Xvals.get(0)+Math.round(PadVal/2), Math.round(0.5*GraphHeight-Yvals.get(0))+Math.round(PadVal/2));

        for (int k = 0; k<Yvals.size()-1; k++ ) {
            Cnvs.lineTo(Math.round(Xvals.get(k+1)/XScale)+Math.round(PadVal/2), Math.round((0.5*GraphHeight)-(Yvals.get(k+1)/YScale))+Math.round(PadVal/2));
        }
        Cnvs.stroke();
        Cnvs.closePath();

        String pattern = "##0.0";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);


        for (int i = 0; i<GraphNx+1; i++ ) {
            //double MarkVal01 = 0.1*Math.round(10*StepX*i*XScale);
            //double MarkVal = Math.round(StepX*i*XScale);

            String MarkX = decimalFormat.format(0.1*Math.round(10*StepX*i*XScale));
            //if (MarkVal01==MarkVal) {
            Cnvs.fillText(MarkX,StepX*i+Math.round(PadVal/2),GraphHeight+Math.round(PadVal/2)+15,100);
            //}
        }

        for (int j = 0; j<GraphNy+1; j++ ) {
            //double MarkValY01 = 0.1*Math.round(10*(0.5*GraphHeight-StepY*j)*YScale);
            //double MarkValY = Math.round((0.5*GraphHeight-StepY*j)*YScale);

            String MarkY = decimalFormat.format(0.1*Math.round(10*(0.5*GraphHeight-StepY*j)*YScale));
            //if (MarkValY01==MarkValY) {
            Cnvs.fillText(MarkY,Math.round(PadVal/2)-20,StepY*j+Math.round(PadVal/2),100);
            //}
        }


        Cnvs.fillText(xTitle,0.5*GraphWidth+PadVal/2-20,GraphHeight+Math.round(PadVal/2)+35,100);

        Cnvs.translate(PadVal/2-45,GraphHeight+20);
        Cnvs.rotate(-0.5*Math.PI);

        //Cnvs.fillText("Значение тренда",PadVal/2-20,0.5*GraphHeight+Math.round(PadVal/2),100);

        Cnvs.fillText(yTitle,0,0,100);

        Cnvs.restoreContext();

        //this.setSizeFull();
        //this.setSpacing(true);
        //this.addComponent(this.TitleStr);
        this.addComponent(this.Cnvs);

    }

    public double closest(double of, List<Double> in) {
        double min = Double.MAX_VALUE;
        double closest = of;

        for (double v : in) {
            final double diff = Math.abs(v - of);

            if (diff < min) {
                min = diff;
                closest = v;
            }
        }

        return closest;
    }

    public double MaxAbsValList(List<Double> in) {
        List<Double> AbsList = new ArrayList<Double>();
        int k = 0;

        for (double v : in) {
            AbsList.add(k,Math.abs(v));
            k = k + 1;
        }

        return Collections.max(AbsList);
    }
}
