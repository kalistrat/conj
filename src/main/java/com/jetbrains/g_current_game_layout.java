package com.jetbrains;

import com.vaadin.ui.*;

/**
 * Created by SemenovNA on 08.08.2016.
 */
public class g_current_game_layout extends HorizontalLayout {

    VerticalLayout LeftSec = new VerticalLayout();
    VerticalLayout MidSec = new VerticalLayout();
    HorizontalLayout CommSec = new HorizontalLayout();
    //HorizontalLayout RightSec = new HorizontalLayout();
    //TextField CurList = new TextField();

    public g_current_game_layout(String iCurrentUser,Integer iGameId,int iAreaSize,int iIsSingleGame){

        this.setSpacing(true);
        this.addComponent(LeftSec);


        tTrandChartLayout gtchart = new tTrandChartLayout(iGameId,iCurrentUser);
        tUserRatesChartsLayout r_lo = new tUserRatesChartsLayout(iGameId,iCurrentUser);
        g_results_chart greschart = new g_results_chart(iGameId,iCurrentUser);
        LeftSec.addComponent(gtchart);
        LeftSec.addComponent(r_lo);
        LeftSec.addComponent(greschart);
        LeftSec.setComponentAlignment(gtchart,Alignment.MIDDLE_CENTER);
        LeftSec.setComponentAlignment(r_lo,Alignment.MIDDLE_CENTER);
        LeftSec.setComponentAlignment(greschart,Alignment.MIDDLE_CENTER);

        this.setComponentAlignment(LeftSec, Alignment.MIDDLE_LEFT);
        //TopSec.setSizeFull();


        tGameAreaTable gti = new tGameAreaTable(iGameId,iCurrentUser);
        tUserRatesTable gurt = new tUserRatesTable(iGameId,iCurrentUser);
        g_step_layout gsli = new g_step_layout(gti,gurt,gtchart,r_lo,greschart);
        MidSec.addComponent(gti);
        MidSec.addComponent(gurt);
        MidSec.addComponent(gsli);
        MidSec.setSpacing(true);
        this.addComponent(MidSec);
        this.setComponentAlignment(MidSec,Alignment.MIDDLE_RIGHT);
        //MidSec.setSizeFull();

        //this.CommSec.setSizeFull();

        //this.addComponent(CommSec);
        //this.setHeight("1500px");
        //this.setWidthUndefined();
        //this.setComponentAlignment(CommSec,Alignment.MIDDLE_CENTER);


    }
}
