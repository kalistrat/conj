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
		
		Label label1 = new Label("<BR/> &nbsp; &nbsp; In this demo you can move the mouse over points at the chart to see their exact values, you can move the right border of the chart by pulling it, you can set the options at the right<BR/><BR/>",
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
		initControlForm(controlForm);
		layout.addComponent(panel);
	}
	private void initControlForm(VerticalLayout controlForm)
 	{
		
		final CheckBox disableAllValueShowCheckBox = new CheckBox("Disable all value showing");
		controlForm.addComponent(disableAllValueShowCheckBox);
		disableAllValueShowCheckBox.setValue(true);
		disableAllValueShowCheckBox.setImmediate(true);
		disableAllValueShowCheckBox.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				if (disableAllValueShowCheckBox.getValue() instanceof Boolean
						&& ((Boolean) disableAllValueShowCheckBox.getValue()).booleanValue()) {
					disableAllValueShowing(true);
				}
				else disableAllValueShowing(false);
			}
		}); 
		final CheckBox disablePopUpValueIndicatorCheckBox = new CheckBox("Disable pop-up value indicator");
		controlForm.addComponent(disablePopUpValueIndicatorCheckBox);
		disablePopUpValueIndicatorCheckBox.setValue(false);
		disablePopUpValueIndicatorCheckBox.setImmediate(true);
		disablePopUpValueIndicatorCheckBox.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				if (disablePopUpValueIndicatorCheckBox.getValue() instanceof Boolean
						&& ((Boolean) disablePopUpValueIndicatorCheckBox.getValue()).booleanValue()) {
					disablePopUpValueIndicator(true);
				}
				else disablePopUpValueIndicator(false);
			}
		}); 
		final CheckBox disableLegendCheckBox = new CheckBox("Disable legend");
		controlForm.addComponent(disableLegendCheckBox);
		disableLegendCheckBox.setValue(false);
		disableLegendCheckBox.setImmediate(true);
		disableLegendCheckBox.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				if (disableLegendCheckBox.getValue() instanceof Boolean
						&& ((Boolean) disableLegendCheckBox.getValue()).booleanValue()) {
					disableLegend(true);
				}
				else disableLegend(false);
			}
		}); 
		final CheckBox disableGeneralCaptionCheckBox = new CheckBox("Disable the general capture");
		controlForm.addComponent(disableGeneralCaptionCheckBox);
		disableGeneralCaptionCheckBox.setValue(false);
		disableGeneralCaptionCheckBox.setImmediate(true);
		disableGeneralCaptionCheckBox.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				if (disableGeneralCaptionCheckBox.getValue() instanceof Boolean
						&& ((Boolean) disableGeneralCaptionCheckBox.getValue()).booleanValue()) {
					disableGeneralCaption(true);
				}
				else disableGeneralCaption(false);
			}
		}); 
		final CheckBox disableWholeChartCheckBox = new CheckBox("Disable the whole chart");
		controlForm.addComponent(disableWholeChartCheckBox);
		disableWholeChartCheckBox.setValue(false);
		disableWholeChartCheckBox.setImmediate(true);
		disableWholeChartCheckBox.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				if (disableWholeChartCheckBox.getValue() instanceof Boolean
						&& ((Boolean) disableWholeChartCheckBox.getValue()).booleanValue()) {
					disableWholeChart(true);
				}
				else disableWholeChart(false);
			}
		}); 
		final CheckBox colorAscendingDescendingCheckBox = new CheckBox("Color ascending and descending parts");
		controlForm.addComponent(colorAscendingDescendingCheckBox);
		colorAscendingDescendingCheckBox.setValue(false);
		colorAscendingDescendingCheckBox.setImmediate(true);
		colorAscendingDescendingCheckBox.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				if (colorAscendingDescendingCheckBox.getValue() instanceof Boolean
						&& ((Boolean) colorAscendingDescendingCheckBox.getValue()).booleanValue()) {
					colorAscendingDescendingParts(true);
				}
				else colorAscendingDescendingParts(false);
			}
		}); 
 	}
	private void chartInit()
	{
		chart = new Chart();
		chart.addStyleName("UniqueColorsBlueGreenRedScheme");
		chart.setWidth("100%");
		chart.setHeight("400px");
		//20 pixels at the right is necessary because we have long labels at the bottom axis and when
		//there is no legend, they are cut if we do not provide some additional space at the right
		chart.setMinRightMargin(20);
		//our labels at the bottom axis are at the angle of 45 and they need 100-pixel height of the space
		chart.setAxisLabelStringHeight(100);
		chart.setGeneralTitle("Sample General Chart Header");
		chart.setLegendData(new String[]{"Freecode","OST Ltd.","IT Ltd.","Dobryvechir"});
		//The value of legend item width is adjusted according to the longest string in the legend data,
		//which can be chosen experimentally
		chart.setLegendItemWidth(112);
		AxisSystem axisSystem = chart.createAxisSystem(AxisHorizontal.Bottom, AxisVertical.Left);
		//our range is 0..1000 (it is not necessary to specify 0 as minimum since it is the default)
		axisSystem.setVerticalAxisMaxValue(1000);
		//the angle for each label at the bottom axis is 45 degrees
		axisSystem.setHorizontalAxisLabelAngle(45);
		axisSystem.setHorizontalAxisTitle("Year 2012");
		axisSystem.setVerticalAxisTitle("Incomes and losses of the company");
		axisSystem.setCurvePresentation(new CurvePresentation[]{
				new CurvePresentation(new Marker(Marker.MarkerShape.Circle),0,CurvePresentation.CurveKind.VerticalBar),
				new CurvePresentation(new Marker(Marker.MarkerShape.Rectangle),0,CurvePresentation.CurveKind.VerticalBar),
				new CurvePresentation(new Marker(Marker.MarkerShape.Square),2,CurvePresentation.CurveKind.Line),
				new CurvePresentation(new Marker(Marker.MarkerShape.NoMarker),1,CurvePresentation.CurveKind.Area),
		});
		axisSystem.setXDiscreteValues(new String[]{"January 2012",
				"February 2012","March 2012","April 2012","May 2012","June 2012",
				"July 2012", "August 2012","September 2012","October 2012",
				"November 2012","December 2012"});
		axisSystem.setYDiscreteValuesForAllSeries(new double[][]{
				new double[]{300,400,450,500,657,450,230,100,500,200,300,500},
				new double[]{196,20,212,302,0,12,30,33,64,100,200,212},
				new double[]{0,100,1500,1750,187,155,-190,1900,199,1200,-5,300,-5,300},
				new double[]{0,72,500,100,20,100,500,88,150,160,10,200}
		});
	}
	private void disableAllValueShowing(boolean disabled)
	{
		chart.setDisabledAllValueShowing(disabled);
	}
	private void disablePopUpValueIndicator(boolean disabled)
	{
		chart.setDisabledPopUpValueIndicator(disabled);
	}
	private void disableLegend(boolean disabled)
	{
		chart.setDisabledLegend(disabled);
	}
	private void disableGeneralCaption(boolean disabled)
	{
		chart.setDisabledGeneralCaption(disabled);
	}
	private void disableWholeChart(boolean disabled)
	{
		chart.setDisabledWholeChart(disabled);
	}
	private void colorAscendingDescendingParts(boolean differentColors)
	{
		if (differentColors)
		{
			chart.removeStyleName("UniqueColorsBlueGreenRedScheme");
			chart.addStyleName("AscendingDescendingRedBlueYellowGreenScheme");
		}
		else
		{
			chart.removeStyleName("AscendingDescendingRedBlueYellowGreenScheme");
			chart.addStyleName("UniqueColorsBlueGreenRedScheme");	
		}
	}
}