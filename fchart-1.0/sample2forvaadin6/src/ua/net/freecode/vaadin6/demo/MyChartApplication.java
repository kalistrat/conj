package ua.net.freecode.vaadin6.demo;

import ua.net.freecode.chart.Chart;

import com.vaadin.Application;
import com.vaadin.ui.*;

public class MyChartApplication extends Application {
	
	private static final long serialVersionUID = 1L;
	private Chart chart;
	@Override
	public void init() {
		Window mainWindow = new Window("Freecode chart demo");
		Panel panel1 = new Panel();
		Label label1 = new Label("In this demo you can see how to use this library as a d3 wrapper");
		panel1.addComponent(label1);
		mainWindow.addComponent(panel1);
		Label label2 = new Label("<BR/><BR/>",Label.CONTENT_RAW);
		mainWindow.addComponent(label2);
		HorizontalSplitPanel panel = new HorizontalSplitPanel();
		panel.setWidth("1200px");
		panel.setSplitPosition(800, HorizontalSplitPanel.UNITS_PIXELS);
		chartInit();
		panel.addComponent(chart);
		VerticalLayout controlForm = new VerticalLayout();
		panel.addComponent(controlForm);
		mainWindow.addComponent(panel);
		setMainWindow(mainWindow);
	}
	private void chartInit()
	{
		chart = new Chart();
		chart.addStyleName("chart1");
		chart.setWidth("100%");
		chart.setHeight("500px");
		chart.setDisabledWholeChart(true);
		chart.addExecutableJavascript("d3.select(\".chart1 g.chart-data-box-low\").append(\"path\").attr(\"d\",\"M 300 230 l 0 -200 a 200 200 0 0 1 173.2 300 Z\").attr(\"fill\",\"blue\").attr(\"stroke\",\"#FFFFFF\").attr(\"stroke-width\",1).attr(\"stroke-linejoin\",\"round\")");
		chart.addExecutableJavascript("d3.select(\".chart1 g.chart-data-box-low\").append(\"path\").attr(\"d\",\"M 300 230 l 173.2 100 a 200 200 0 0 1 -346.4 0 Z\").attr(\"fill\",\"red\").attr(\"stroke\",\"#FFFFFF\").attr(\"stroke-width\",1).attr(\"stroke-linejoin\",\"round\")");
		chart.addExecutableJavascript("d3.select(\".chart1 g.chart-data-box-low\").append(\"path\").attr(\"d\",\"M 300 230 l -173.2 100 a 200 200 0 0 1 173.2 -300 Z\").attr(\"fill\",\"green\").attr(\"stroke\",\"#FFFFFF\").attr(\"stroke-width\",1).attr(\"stroke-linejoin\",\"round\")");
		chart.addExecutableJavascript("d3.select(\".chart1 g.chart-data-box-low\").append(\"text\").text(\"Freedom\").attr(\"x\",290).attr(\"y\",330).attr(\"fill\",\"yellow\").attr(\"style\",\"font-size:14px\")");
		chart.addExecutableJavascript("d3.select(\".chart1 g.chart-data-box-low\").append(\"text\").text(\"Faith\").attr(\"x\",400).attr(\"y\",190).attr(\"fill\",\"yellow\").attr(\"style\",\"font-size:14px\")");
		chart.addExecutableJavascript("d3.select(\".chart1 g.chart-data-box-low\").append(\"text\").text(\"Moral\").attr(\"x\",190).attr(\"y\",190).attr(\"fill\",\"yellow\").attr(\"style\",\"font-size:14px\")");
	}
	/***
	 * This is an alternative chart init if you decide not to use redrawing capabilities
	private void chartInit()
	{
		chart = new Chart();
		chart.addStyleName("chart1");
		chart.setWidth("100%");
		chart.setHeight("500px");
		chart.setDisabledWholeChart(true);
		chart.addExecutableJavascriptToRunOnce("d3.select(\".chart1 svg\").append(\"path\").attr(\"d\",\"M 300 230 l 0 -200 a 200 200 0 0 1 173.2 300 Z\").attr(\"fill\",\"blue\").attr(\"stroke\",\"#FFFFFF\").attr(\"stroke-width\",1).attr(\"stroke-linejoin\",\"round\")");
		chart.addExecutableJavascriptToRunOnce("d3.select(\".chart1 svg\").append(\"path\").attr(\"d\",\"M 300 230 l 173.2 100 a 200 200 0 0 1 -346.4 0 Z\").attr(\"fill\",\"red\").attr(\"stroke\",\"#FFFFFF\").attr(\"stroke-width\",1).attr(\"stroke-linejoin\",\"round\")");
		chart.addExecutableJavascriptToRunOnce("d3.select(\".chart1 svg\").append(\"path\").attr(\"d\",\"M 300 230 l -173.2 100 a 200 200 0 0 1 173.2 -300 Z\").attr(\"fill\",\"green\").attr(\"stroke\",\"#FFFFFF\").attr(\"stroke-width\",1).attr(\"stroke-linejoin\",\"round\")");
		chart.addExecutableJavascriptToRunOnce("d3.select(\".chart1 svg\").append(\"text\").text(\"Freedom\").attr(\"x\",290).attr(\"y\",330).attr(\"fill\",\"yellow\").attr(\"style\",\"font-size:14px\")");
		chart.addExecutableJavascriptToRunOnce("d3.select(\".chart1 svg\").append(\"text\").text(\"Faith\").attr(\"x\",400).attr(\"y\",190).attr(\"fill\",\"yellow\").attr(\"style\",\"font-size:14px\")");
		chart.addExecutableJavascriptToRunOnce("d3.select(\".chart1 svg\").append(\"text\").text(\"Moral\").attr(\"x\",190).attr(\"y\",190).attr(\"fill\",\"yellow\").attr(\"style\",\"font-size:14px\")");
	}
	***/

}
