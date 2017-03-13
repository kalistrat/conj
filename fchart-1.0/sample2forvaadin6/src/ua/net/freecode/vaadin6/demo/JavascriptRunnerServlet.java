/**
 * Copyright by Freecode (vaadin@freecode.net.ua) 2013
 * Author: Volodymyr Dobryvechir
 */
package ua.net.freecode.vaadin6.demo;

import java.io.BufferedWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.ApplicationServlet;
import com.vaadin.ui.Window;


public class JavascriptRunnerServlet extends ApplicationServlet {

	private static final long serialVersionUID = 1L;
    @Override
    protected void writeAjaxPageHtmlVaadinScripts(Window window,
            String themeName, Application application, BufferedWriter page,
            String appUrl, String themeUri, String appId,
            HttpServletRequest request) throws ServletException, IOException {
    	page.write("<link href=\""+ appUrl + "/VAADIN/charts/fchart.css\" rel=\"stylesheet\" type=\"text/css\" />");
    	page.write("<script type=\"text/javascript\" src=\""+ appUrl + "/VAADIN/charts/d3.v3.min.js\" charset=\"utf-8\"></script>");
        page.write("<script type=\"text/javascript\" src=\""+ appUrl + "/VAADIN/charts/fchart-1.0.js\"  charset=\"utf-8\"></script>");
    	super.writeAjaxPageHtmlVaadinScripts(window, themeName, application,
                page, appUrl, themeUri, appId, request);
    }
}
