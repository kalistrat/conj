package ua.net.freecode.vaadin7.demo;

import javax.servlet.annotation.WebServlet;

import ua.net.freecode.chart.AxisSystem;
import ua.net.freecode.chart.Chart;
import ua.net.freecode.chart.CurvePresentation;
import ua.net.freecode.chart.Marker;
import ua.net.freecode.chart.AxisSystem.AxisHorizontal;
import ua.net.freecode.chart.AxisSystem.AxisVertical;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;

import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("charts")
public class ChartUI extends UI {

	private static final long serialVersionUID = 1L;
	private Chart chart;
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = ChartUI.class,
			widgetset="ua.net.freecode.vaadin7.demo.widgetset.MyWidgetset")
	public static class Servlet extends VaadinServlet {
		private static final long serialVersionUID = 1L;
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		Label label1 = new Label("<BR/> &nbsp; &nbsp; In this demo you can see how to use this library as a d3 wrapper <BR/><BR/>",
				   ContentMode.HTML);
		VerticalLayout panel1Layout = new VerticalLayout();
		Panel panel1 = new Panel(panel1Layout);
		panel1Layout.addComponent(label1);
		layout.addComponent(panel1);
		Label label2 = new Label("<BR/><BR/>",ContentMode.HTML);
		layout.addComponent(label2);
		chartInit();
		VerticalLayout controlForm = new VerticalLayout();
		HorizontalSplitPanel panel = new HorizontalSplitPanel(chart,controlForm);
	
		panel.setWidth("100%");
		panel.setHeight("600px");
		panel.setSplitPosition(800, Unit.PIXELS);
		layout.addComponent(panel);
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