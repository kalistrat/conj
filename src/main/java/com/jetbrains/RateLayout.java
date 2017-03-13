package com.jetbrains;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.ValoTheme;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kalistrat on 26.09.2016.
 */
public class RateLayout extends HorizontalLayout {

    static final private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final private String DB_URL = "jdbc:mysql://localhost/conjuncture";
    static final private String USER = "gumbler";
    static final private String PASS = "tutunia";

    public String iUserName;
    public Integer iGameId;

    List<MultiGraphData> RatesData;
    Button LeftMove;
    Button RightMove;
    HorizontalLayout LeftSec;
    HorizontalLayout RightSec;
    HorizontalLayout MidSec;
    Integer GraphNumber;


    public RateLayout(int wGameId,String wUserName){


        this.iGameId = wGameId;
        this.iUserName = wUserName;

        RatesData = new ArrayList<MultiGraphData>();
        this.GetRatesData();


//        List<Double> xr = new ArrayList<Double>();
//        List<Double> yr = new ArrayList<Double>();
//        xr.add(0,0.0);
//        xr.add(1,1.0);
//        yr.add(0,0.0);
//        yr.add(1,1.0);

//        List<Double> xb = new ArrayList<Double>();
//        List<Double> yb = new ArrayList<Double>();
//        xb.add(0,0.0);
//        xb.add(1,1.0);
//        yb.add(0,0.0);
//        yb.add(1,1.0);
//
//        List<Double> xg = new ArrayList<Double>();
//        List<Double> yg = new ArrayList<Double>();
//        xg.add(0,0.0);
//        xg.add(1,1.0);
//        yg.add(0,0.0);
//        yg.add(1,1.0);
//
//        this.RatesData.add(new MultiGraphData(xr,yr,"RED"));
//        this.RatesData.add(new MultiGraphData(xb,yb,"BLUE"));
//        this.RatesData.add(new MultiGraphData(xg,yg,"GREEN"));

        GraphNumber = 0;

        this.LeftMove = new Button("<");
        this.RightMove = new Button(">");
        this.LeftSec = new HorizontalLayout();
        this.MidSec = new HorizontalLayout();
        this.RightSec = new HorizontalLayout();

        this.LeftMove.setData(this);
        this.RightMove.setData(this);

        this.LeftMove.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                RateLayout RLo = (RateLayout) clickEvent.getButton().getData();
                RLo.MidSec.removeAllComponents();
                if (RLo.GraphNumber == 0) {
                    GraphNumber = RLo.RatesData.size()-1;
                } else {
                    GraphNumber = GraphNumber - 1;
                }
                RLo.MidSec.addComponent(new Graph("Изменение тренда","Шаги игры","Значение ставки",RLo.RatesData.get(GraphNumber).XData,RLo.RatesData.get(GraphNumber).YData,RLo.RatesData.get(GraphNumber).LineColor));
            }
        });

        this.RightMove.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                RateLayout RLo = (RateLayout) clickEvent.getButton().getData();
                RLo.MidSec.removeAllComponents();
                if (RLo.GraphNumber == RLo.RatesData.size()-1) {
                    GraphNumber = 0;
                } else {
                    GraphNumber = GraphNumber + 1;
                }
                RLo.MidSec.addComponent(new Graph("Изменение тренда","Шаги игры","Значение ставки",RLo.RatesData.get(GraphNumber).XData,RLo.RatesData.get(GraphNumber).YData,RLo.RatesData.get(GraphNumber).LineColor));
            }
        });


        this.LeftSec.addComponent(LeftMove);
        this.addComponent(LeftSec);

        this.MidSec.addComponent(new Graph("Изменение тренда","Шаги игры","Значение ставки",this.RatesData.get(GraphNumber).XData,this.RatesData.get(GraphNumber).YData,this.RatesData.get(GraphNumber).LineColor));
        this.addComponent(MidSec);

        this.RightSec.addComponent(RightMove);
        this.addComponent(RightSec);

        this.LeftMove.setHeight("70px");
        this.RightMove.setHeight("70px");
        this.LeftMove.addStyleName(ValoTheme.BUTTON_LINK);
        this.RightMove.addStyleName(ValoTheme.BUTTON_LINK);
        this.setComponentAlignment(LeftSec, Alignment.MIDDLE_LEFT);
        this.setComponentAlignment(RightSec, Alignment.MIDDLE_RIGHT);
        this.setComponentAlignment(MidSec,Alignment.MIDDLE_CENTER);


        this.setSizeFull();

    }

    public void GetRatesData(){

        try {
            String GraphColor;
            int sj = 0;
            int si = 0;
            //List<Double> xD = new ArrayList<Double>();
            //List<Double> yD = new ArrayList<Double>();

            Class.forName(JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(DB_URL, USER, PASS);

            String RateListSql = "select ft.filed_color\n" +
                    "from game_field gf\n" +
                    "join field_type ft on ft.field_type_id=gf.field_type_id\n" +
                    "where gf.game_id=?\n" +
                    "group by ft.filed_color";

            PreparedStatement RateListStmt = Con.prepareStatement(RateListSql);
            RateListStmt.setInt(1,this.iGameId);

            ResultSet RateListRs = RateListStmt.executeQuery();

            while (RateListRs.next()) {
                GraphColor = RateListRs.getString(1);

                String RateCntSql = "select @num:=@num+1 rownum\n" +
                        ",(\n" +
                        "select ifnull(sum(gphi.fields_count),0)\n" +
                        "from game_rate_hist gphi\n" +
                        "join game_player gpl on gpl.game_player_id=gphi.game_player_id \n" +
                        "join player p on p.player_id=gpl.player_id\n" +
                        "join field_type fit on fit.field_type_id=gphi.field_type_id\n" +
                        "where p.player_log=?\n" +
                        "and gphi.game_step_id=t.game_step_id\n" +
                        "and gphi.game_id=t.game_id\n" +
                        "and fit.filed_color=?\n" +
                        ") cnt_rates\n" +
                        "from (\n" +
                        "select grh.game_step_id\n" +
                        ",grh.game_id\n" +
                        "from game_rate_hist grh\n" +
                        "where grh.game_id=?\n" +
                        "group by grh.game_step_id,grh.game_id\n" +
                        ") t\n" +
                        "join (select @num:=0) num";

                PreparedStatement RateCntStmt = Con.prepareStatement(RateCntSql);
                RateCntStmt.setString(1,this.iUserName);
                RateCntStmt.setString(2,GraphColor);
                RateCntStmt.setInt(3,this.iGameId);

                ResultSet RateCntRs = RateCntStmt.executeQuery();

                List<Double> xD = new ArrayList<Double>();
                List<Double> yD = new ArrayList<Double>();

                xD.add(si,0.0);
                yD.add(si,0.0);

                while (RateCntRs.next()) {
                    si = si + 1;
                    double StepId = (double) RateCntRs.getInt(1);
                    double StepVal = (double) RateCntRs.getInt(2);
                    xD.add(si,StepId);
                    yD.add(si,StepVal);
                }

                this.RatesData.add(sj,new MultiGraphData(xD,yD,GraphColor));
                //xD.clear();
                //yD.clear();
                sj = sj + 1;
                si = 0;
            }
            Con.close();
        } catch (SQLException se3) {
            se3.printStackTrace();
        } catch (Exception e13) {
            e13.printStackTrace();
        }
    }

    public void refreshMultyGraph(){
        this.MidSec.removeAllComponents();
        this.RatesData.removeAll(this.RatesData);
        this.GetRatesData();
        this.MidSec.addComponent(new Graph("Изменение тренда","Шаги игры","Значение ставки",this.RatesData.get(0).XData,this.RatesData.get(0).YData,this.RatesData.get(0).LineColor));
        //this.setSizeFull();
    }
}
