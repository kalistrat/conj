package com.jetbrains;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.*;

import java.sql.*;

/**
 * Created by SemenovNA on 04.08.2016.
 */
public class GCreateGameAccordion extends Accordion {

    TabSheet t1 = new TabSheet();
    TabSheet t2 = new TabSheet();
    ComboBox SelectArea = new ComboBox("Выберите размер поля");
    SpinnerTextField IssueGameSum = new SpinnerTextField();

    CheckBox cb = new CheckBox("Одиночная игра");

    String CurrentUser;
    int CreatedGameId;



    static final private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final private String DB_URL = "jdbc:mysql://localhost/conjuncture";
    static final private String USER = "gumbler";
    static final private String PASS = "tutunia";


    public GCreateGameAccordion(GUserMainPanel jMainPanel,String jCurrentUser){

        Button CreateButton = new Button("Создать");
        CreateButton.setData(this);
        this.CurrentUser = jCurrentUser;
        CreatedGameId = 0;

        CreateButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                GCreateGameAccordion p1 = (GCreateGameAccordion) clickEvent.getButton().getData();
                String SelectedAreaType = (String) p1.SelectArea.getValue();
                Integer SelectedPassivVal = Integer.parseInt(p1.IssueGameSum.tf.getValue());

                int IntSize = 0;

                if (SelectedAreaType.equals("6x6")){
                    IntSize = 6;
                }

                if (SelectedAreaType.equals("8x8")){
                    IntSize = 8;
                }

                if (SelectedAreaType.equals("10x10")){
                    IntSize = 10;
                }
                //System.out.println("SelectedAreaType  = " + SelectedAreaType);
                int IsSingleGame;
                if (p1.cb.getValue()) {
                    IsSingleGame = 1;
                } else {
                    IsSingleGame = 0;
                }

                if (jMainPanel.Is_Game_Create_Connect == 0) {

                    try {

                        Class.forName(JDBC_DRIVER);
                        Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);

                        CallableStatement CreateGameStmt = conn.prepareCall("{? = call f_game_create(?, ?, ?, ?, ?)}");
                        CreateGameStmt.registerOutParameter (1, Types.INTEGER);
                        CreateGameStmt.setString(2, p1.CurrentUser);
                        CreateGameStmt.setInt(3, IntSize);
                        CreateGameStmt.setDouble(4, SelectedPassivVal);
                        CreateGameStmt.setString(5, p1.CurrentUser.toUpperCase().substring(0,1));
                        CreateGameStmt.setInt(6, IsSingleGame);

                        CreateGameStmt.execute();
                        p1.CreatedGameId = CreateGameStmt.getInt(1);
                        conn.close();

                        //System.out.println("UserSymGenerate  = " + p1.CurrentUser.toUpperCase().substring(0,1));


                    }catch(SQLException se){
                        //Handle errors for JDBC
                        se.printStackTrace();
                    }catch(Exception e) {
                        //Handle errors for Class.forName
                        e.printStackTrace();
                    }

                    Notification.show("Создана игра: " + p1.CreatedGameId);
                    jMainPanel.Is_Game_Create_Connect = 1;
                    g_current_game_layout cur_game = new g_current_game_layout(p1.CurrentUser,p1.CreatedGameId,IntSize,IsSingleGame);

                    jMainPanel.addTab(cur_game, "Активная игра");
                } else {
                    Notification.show("Активная игра уже создана");
                }
            }
        });

        Button ReturnButton = new Button("Свернуть");
        ReturnButton.setData(this);

        ReturnButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                GCreateGameAccordion p = (GCreateGameAccordion) clickEvent.getButton().getData();
                p.setSelectedTab(p.t2);
            }
        });


        HorizontalLayout FieldsSection = new HorizontalLayout();
        HorizontalLayout ButtonsSection = new HorizontalLayout();

        IndexedContainer AreaSizeContainer = new IndexedContainer();
        AreaSizeContainer.addContainerProperty("AreaSize", String.class, null);
        AreaSizeContainer.addItem("6x6");
        AreaSizeContainer.addItem("8x8");
        AreaSizeContainer.addItem("10x10");

        SelectArea.setContainerDataSource(AreaSizeContainer);
        SelectArea.setNullSelectionAllowed(false);
        SelectArea.setTextInputAllowed(false);
        SelectArea.setValue("6x6");
        cb.setValue(false);

        FieldsSection.addComponent(IssueGameSum);
        FieldsSection.addComponent(SelectArea);
        ButtonsSection.addComponent(cb);
        ButtonsSection.addComponent(ReturnButton);
        ButtonsSection.addComponent(CreateButton);
        ButtonsSection.setComponentAlignment(cb,Alignment.MIDDLE_LEFT);
        ButtonsSection.setComponentAlignment(ReturnButton,Alignment.MIDDLE_CENTER);
        ButtonsSection.setComponentAlignment(CreateButton,Alignment.MIDDLE_RIGHT);

        ButtonsSection.setSpacing(true);
        FieldsSection.setSpacing(true);

        VerticalLayout FullSection = new VerticalLayout(FieldsSection,ButtonsSection);
        t1.addComponent(FullSection);
        FullSection.setSpacing(true);
        FullSection.setComponentAlignment(FieldsSection,Alignment.MIDDLE_CENTER);
        FullSection.setComponentAlignment(ButtonsSection,Alignment.MIDDLE_CENTER);
        t2.setHeight("1px");



        addTab(t1, "Создать новую игру", null);
        addTab(t2, "^", null);
        setSelectedTab(t2);
        setSizeFull();


    }
}
