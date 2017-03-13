package com.jetbrains;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kalistrat on 26.09.2016.
 */
public class MultiGraphData {
    List<Double> XData = new ArrayList<Double>();
    List<Double> YData = new ArrayList<Double>();
    String LineColor;

    public  MultiGraphData(List<Double> xData,List<Double> yData,String lineColor){
        this.XData = xData;
        this.YData = yData;
        this.LineColor = lineColor;
    }
}
