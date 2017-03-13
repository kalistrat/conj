1. Create a new Vaadin 6 project in Eclipse
2. Replace your project's src folder with this src folder
3. Replace your project's WebContent/WEB-INF/web.xml file 
  with this web.xml file
4. Copy 
  chartlib/charts/d3.v3.min.js      to   <YOUR PROJECT>/WebContent/VAADIN/charts/d3.v3.min.js
  chartlib/charts/chart_1.0.js      to   <YOUR PROJECT>/WebContent/VAADIN/charts/chart_1.0.js
  chartlib/charts/fchart.css   to   <YOUR PROJECT>/WebContent/VAADIN/charts/fchart.css
  chartlib/libforvaadin6/fchart-1.0.jar  to   <YOUR PROJECT>/WebContent/WEB-INF/lib/fchart-1.0.jar
Note: if any folder does not exist in your project, create it!
5. Refresh the project in Eclipse (left click on the project and press F5)
6. Specify that fchart-1.0.jar is one of required libraries:
   Right-click on the project in Eclipse -> Properties -> Java Build Path
  -> Libraries -> Add JARs -> find fchart-1.0.jar in your project tree
  -> Ok
  Also in Java Build Path -> Order and Export -> check fchart-1.0.jar

7. Compile your java code (for example,  Project -> Clean -> your project,
   check immediate rebuild)
Note: if you have the error: internal validation error for d3.v3.min.js, see Trouble-Shooting Guide to solve this problem.
8. Compile Vaadin widgets (Press button in Eclipse: Compile Vaadin Widgets)
9. Run the application on the server  (for example, on Tomcat)
Note: the Eclipse's embedded browser does not show the chart correctly,
use any modern browser.

   