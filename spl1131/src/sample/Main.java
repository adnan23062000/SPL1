package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;

public class Main extends Application {

    Stage window;
    Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8;

    public boolean weekend, holiday;

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setTitle("Routine Dynamics");

        Button button1 = new Button("START");
        button1.setTranslateX(600);
        button1.setTranslateY(350);
        button1.setPrefSize(100, 60);

        Button exitBtn = new Button("Exit");
        exitBtn.setTranslateX(600);
        exitBtn.setTranslateY(450);
        exitBtn.setPrefSize(100, 60);
        exitBtn.setOnAction(e -> Platform.exit());

        button1.setOnAction(e -> window.setScene(scene2));

        Button button2 = new Button("Back");
        button2.setTranslateX(20);
        button2.setTranslateY(20);
        button2.setPrefSize(60, 30);

        Button createRoutine = new Button("Create Your Routine");
        createRoutine.setTranslateX(590);
        createRoutine.setTranslateY(330);
        createRoutine.setPrefSize(150, 70);
        createRoutine.setOnAction(e -> regForm());

        Button seePreviousData = new Button("See Previous User Data");
        seePreviousData.setTranslateX(570);
        seePreviousData.setTranslateY(430);
        seePreviousData.setPrefSize(180, 70);
        seePreviousData.setOnAction(e -> GraphMenu());

        Button others = new Button("Others");
        others.setTranslateX(610);
        others.setTranslateY(530);
        others.setPrefSize(100, 60);
        others.setOnAction(e -> createCalendar());

        button2.setOnAction(e -> window.setScene(scene1));

        Pane layout1 = new Pane();
        layout1.getChildren().addAll(button1, exitBtn);


        scene1 = new Scene(layout1, 1300, 650);

        Pane layout2 = new Pane();
        layout2.getChildren().addAll(button2, createRoutine, seePreviousData, others);
        scene2 = new Scene(layout2, 1300, 650);


        Image background = new Image("routine.PNG");
        /*Canvas c = new Canvas(300,400);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(background,0,0);
        layout1.getChildren().add(c);*/

        BackgroundImage bi = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bg = new Background(bi);
        layout1.setBackground(bg);

        Image pageTwo = new Image("abc.PNG");
        BackgroundImage b2 = new BackgroundImage(pageTwo,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bg2 = new Background(b2);
        layout2.setBackground(bg2);

        //Scene scene2 = new Scene(layout1, 600, 300);

        window.setScene(scene1);
        window.show();
    }

    public void regForm()
    {
        Pane layout = new Pane();

        Image pageThree = new Image("pic3.PNG");

        Label label1 = new Label("Name: ");
        label1.setTranslateX(390);
        label1.setTranslateY(100);
        TextField name = new TextField();
        name.setTranslateX(430);
        name.setTranslateY(100);

        Label label2 = new Label("Password: ");
        label2.setTranslateX(375);
        label2.setTranslateY(150);
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Your password");
        passwordField.setTranslateX(430);
        passwordField.setTranslateY(150);

        Button button2 = new Button("Back");
        button2.setTranslateX(20);
        button2.setTranslateY(20);
        button2.setPrefSize(60, 30);

        Button create = new Button("Create Profile");
        create.setTranslateX(800);
        create.setTranslateY(550);
        create.setPrefSize(120, 60);


        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);
        layout.getChildren().addAll(c, label1, name, passwordField, label2, button2, create);

        create.setOnAction(e -> {
            try {
                inputData();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        button2.setOnAction(e -> window.setScene(scene2));
        scene3 = new Scene(layout, 1300, 650);
        window.setScene(scene3);
    }

    public void inputData() throws FileNotFoundException {

        File_Operations obj = new File_Operations();
        obj.File_Subjects();

        MultipleRegression objj = new MultipleRegression();
        objj.multiRegression();

        LinearRegression obj2 = new LinearRegression();
        obj2.xyMethod();
        obj2.setMeanXY();
        obj2.summationXY();
        obj2.AlphaBetaCalc();

        Label label1 = new Label("Enter Study Hour:  ");
        label1.setTranslateX(390);
        label1.setTranslateY(100);

        Label label2 = new Label("Enter Your Marks: ");
        label2.setTranslateX(390);
        label2.setTranslateY(200);

        Label label3 = new Label("Math ->  ");
        label3.setTranslateX(390);
        label3.setTranslateY(230);

        Label label4 = new Label("Physics ->  ");
        label4.setTranslateX(390);
        label4.setTranslateY(260);

        Label label5 = new Label("ICT ->  ");
        label5.setTranslateX(390);
        label5.setTranslateY(290);

        Label label6 = new Label("Enter Your IQ: ");
        label6.setTranslateX(390);
        label6.setTranslateY(380);

        Label label7 = new Label("Enter Your Preferable Study Time");
        label7.setTranslateX(390);
        label7.setTranslateY(473);

        Label label8 = new Label("Do You Study in weekends?  ");
        Label label9 = new Label("Do You Study in Holidays?  ");
        label8.setTranslateX(390);
        label8.setTranslateY(500);
        label9.setTranslateX(390);
        label9.setTranslateY(540);

        TextField textMath = new TextField();
        textMath.setTranslateX(450);
        textMath.setTranslateY(230);
        TextField textPhy = new TextField();
        textPhy.setTranslateX(450);
        textPhy.setTranslateY(260);
        TextField textICT = new TextField();
        textICT.setTranslateX(450);
        textICT.setTranslateY(290);

        Button submit = new Button("Submit");
        Button markResult = new Button();
        Button markResult2 = new Button();
        Button markResult3 = new Button();
        Button markResult4 = new Button();
        markResult.setTranslateX(800);
        markResult.setTranslateY(240);
        markResult.setPrefSize(150, 60);
        markResult2.setTranslateX(800);
        markResult2.setTranslateY(80);
        markResult2.setPrefSize(150, 60);
        markResult3.setTranslateX(800);
        markResult3.setTranslateY(360);
        markResult4.setTranslateX(800);
        markResult4.setTranslateY(450);
        markResult2.setPrefSize(150, 60);
        markResult3.setPrefSize(150, 60);
        markResult4.setPrefSize(150, 60);
        submit.setTranslateX(480);
        submit.setTranslateY(320);

        submit.setOnAction(e -> {
            double math = Double.parseDouble(textMath.getText());
            double physics = Double.parseDouble(textPhy.getText());
            double ict = Double.parseDouble(textICT.getText());

            markResult.setText(objj.CGCalc2(math, physics, ict));
        });

        final Slider slider = new Slider(0, 24, 0);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(5);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setTranslateX(550);
        slider.setTranslateY(100);

        slider.valueProperty().addListener(
                new ChangeListener<Number>() {

                    public void changed(ObservableValue <? extends Number >
                                                observable, Number oldValue, Number newValue)
                    {
                        double value = slider.getValue();
                        markResult2.setText(obj2.CGCalc(value));
                    }
                });

        String st[] = { "120", "130", "140", "150" };

        ChoiceBox cbIQ = new ChoiceBox(FXCollections.observableArrayList(st));
        cbIQ.setTranslateX(480);
        cbIQ.setTranslateY(380);
        cbIQ.setPrefSize(100, 30);

        cbIQ.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                // set the text for the label to the selected item
                String x = st[new_value.intValue()];
                int xx = Integer.parseInt(x);
                if(xx==120)
                    markResult3.setText("CG: 3.35");
                if(xx==130)
                    markResult3.setText("CG: 3.50");
                if(xx==140)
                    markResult3.setText("CG: 3.75");
                if(xx==150)
                    markResult3.setText("CG: 4.00");
            }
        });

        String ab[] = { "Morning", "Noon", "Afternoon", "Evening", "Night" };

        ChoiceBox studyTime = new ChoiceBox(FXCollections.observableArrayList(ab));
        studyTime.setTranslateX(580);
        studyTime.setTranslateY(470);
        studyTime.setPrefSize(100, 30);

        studyTime.getSelectionModel().selectedIndexProperty().addListener((ov, value, new_value) -> {
            // set the text for the label to the selected item
            String x = ab[new_value.intValue()];
        });

        Image pageThree = new Image("pic3.PNG");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        Button button2 = new Button("Back");
        button2.setTranslateX(20);
        button2.setTranslateY(20);
        button2.setPrefSize(60, 30);

        RadioButton r1 = new RadioButton("Yes");
        r1.setTranslateX(580);
        r1.setTranslateY(500);
        RadioButton r2 = new RadioButton("Yes");
        r2.setTranslateX(580);
        r2.setTranslateY(540);
        RadioButton r3 = new RadioButton("No");
        r3.setTranslateX(620);
        r3.setTranslateY(500);
        RadioButton r4 = new RadioButton("No");
        r4.setTranslateX(620);
        r4.setTranslateY(540);

        if(r1.isSelected())
            weekend = true;
        if(r2.isSelected())
            holiday = true;
        if(r3.isSelected())
            weekend = false;
        if(r4.isSelected())
            holiday = false;

        System.out.println("\nweekend  " + weekend + "\nHoliday  " + holiday);

        Pane layout = new Pane();
        layout.getChildren().addAll(c, label1, slider, label2, label3, label4, label5, label6, label7, label8, label9, textMath, textPhy, textICT, submit, markResult, markResult2, markResult3, cbIQ, studyTime, r1, r2, r3, r4, button2);

        button2.setOnAction(e -> window.setScene(scene3));
        scene4 = new Scene(layout, 1300, 650);
        window.setScene(scene4);
    }

    public void GraphMenu()
    {
        Image pageThree = new Image("pic3.PNG");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        Button button1 = new Button("See Linear Regression Graph");
        button1.setTranslateX(600);
        button1.setTranslateY(350);
        button1.setPrefSize(250, 60);
        button1.setOnAction(e -> {
            try {
                scatterDiagram();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        Button button2 = new Button("See Multiple Regression Graph");
        button2.setTranslateX(600);
        button2.setTranslateY(450);
        button2.setPrefSize(250, 60);
        button2.setOnAction(e -> {
            try {
                lineChart();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        Button button3 = new Button("Back");
        button3.setTranslateX(20);
        button3.setTranslateY(20);
        button3.setPrefSize(60, 30);
        button3.setOnAction(e -> window.setScene(scene2));

        Pane layout = new Pane();
        layout.getChildren().addAll(c, button1, button2, button3);
        scene5 = new Scene(layout, 1300, 650);
        window.setScene(scene5);
    }

    public void scatterDiagram() throws FileNotFoundException
    {

        File_Operations objj = new File_Operations();
        objj.File_Subjects();

        NumberAxis xAxis = new NumberAxis(0, 20, 3);
        xAxis.setLabel("Study Hour");

        NumberAxis yAxis = new NumberAxis(2.5, 5, 20);
        yAxis.setLabel("CGPA");

        ScatterChart<String, Number> scatterChart = new ScatterChart(xAxis, yAxis);

        XYChart.Series series = new XYChart.Series();

        objj.list.forEach(user -> {
            series.getData().add(new XYChart.Data(user.getStudyHour(), user.getGPA()));
        });
        scatterChart.getData().addAll(series);

        Pane layout = new Pane();

        LinearRegression obj = new LinearRegression();
        obj.xyMethod();
        obj.setMeanXY();
        obj.summationXY();
        obj.AlphaBetaCalc();

        Button button2 = new Button("Back");
        button2.setTranslateX(10);
        button2.setTranslateY(10);
        button2.setPrefSize(60, 30);

        button2.setOnAction(e -> {
            GraphMenu();
        });

        Button eqn = new Button(obj.showEquation());
        eqn.setTranslateX(720);
        eqn.setTranslateY(40);
        eqn.setPrefSize(250, 100);

        Label label1 = new Label("The Equation is: ");
        label1.setTranslateX(720);
        label1.setTranslateY(20);

        layout.getChildren().addAll(scatterChart, label1, eqn, button2);

        scene6 = new Scene(layout, 1300, 650);
        window.setScene(scene6);
    }

    public void lineChart() throws FileNotFoundException {

        File_Operations obj = new File_Operations();
        obj.File_Subjects();

        NumberAxis xAxis = new NumberAxis(50, 100, 3);
        xAxis.setLabel("Marks");

        NumberAxis yAxis = new NumberAxis(2.5, 5, 20);
        yAxis.setLabel("CGPA");

        LineChart linechart = new LineChart(xAxis, yAxis);
        XYChart.Series series = new XYChart.Series();
        series.setName("Physics");
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Math");
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("ICT");

        obj.list.forEach(user -> {

            series.getData().add(new XYChart.Data(user.getPhysics(), user.getGPA()));
            series2.getData().add(new XYChart.Data(user.getMath(), user.getGPA()));
            series3.getData().add(new XYChart.Data(user.getIct(), user.getGPA()));
        });

        linechart.getData().addAll(series, series2, series3);

        Label label1 = new Label("The Equation is: ");
        label1.setTranslateX(720);
        label1.setTranslateY(20);

        MultipleRegression obj2 = new MultipleRegression();
        obj2.multiRegression();

        Button button2 = new Button("Back");
        button2.setTranslateX(10);
        button2.setTranslateY(10);
        button2.setPrefSize(60, 30);

        button2.setOnAction(e -> {
            GraphMenu();
        });

        Button eqn = new Button(obj2.showEqn());
        eqn.setTranslateX(600);
        eqn.setTranslateY(50);
        eqn.setPrefSize(600, 100);

        Pane layout = new Pane();
        layout.getChildren().addAll(linechart, label1, eqn, button2);

        scene7 = new Scene(layout, 1300, 650);
        window.setScene(scene7);

    }

    public void createCalendar()
    {
        Button prev = new Button(" <-- ");
        prev.setTranslateX(520);
        prev.setTranslateY(50);
        Button next = new Button(" --> ");
        next.setTranslateX(680);
        next.setTranslateY(50);
        Button monthB = new Button();
        monthB.setTranslateX(580);
        monthB.setTranslateY(50);
        monthB.setPrefSize(80, 30);

        int sunb=360, monb=440, tueb=520, wedb=600, thub=680, frib=760, satb=840;

        Button sun = new Button("SUN");
        sun.setTranslateX(sunb);
        sun.setTranslateY(120);

        Button mon = new Button("MON");
        mon.setTranslateX(monb);
        mon.setTranslateY(120);

        Button tue = new Button("TUE");
        tue.setTranslateX(tueb);
        tue.setTranslateY(120);

        Button wed = new Button("WED");
        wed.setTranslateX(wedb);
        wed.setTranslateY(120);

        Button thu = new Button("THU");
        thu.setTranslateX(thub);
        thu.setTranslateY(120);

        Button fri = new Button("FRI");
        fri.setStyle("-fx-base: red;");
        fri.setTranslateX(frib);
        fri.setTranslateY(120);

        Button sat = new Button("SAT");
        sat.setStyle("-fx-base: red;");
        sat.setTranslateX(satb);
        sat.setTranslateY(120);

        Button year = new Button();
        year.setTranslateX(595);
        year.setTranslateY(20);

        String[] monthName = {"January", "February",
                "March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};

        Calendar cal = Calendar.getInstance();
        //String month = monthName[cal.get(Calendar.MONTH)];
        monthB.setText(monthName[(cal.get(Calendar.MONTH))]);
        year.setText(String.valueOf(cal.get(Calendar.YEAR)));

        Pane layout = new Pane();
        layout.getChildren().addAll(prev, next, monthB, sun, mon, tue, wed, thu, fri, sat, year);
        setDates(cal.get(Calendar.MONTH), cal.get(Calendar.YEAR), layout);

        prev.setOnAction(e -> {

            cal.add(Calendar.MONTH, -1);
            monthB.setText(monthName[(cal.get(Calendar.MONTH))]);
            year.setText(String.valueOf(cal.get(Calendar.YEAR)));
            setDates(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), layout);
            scene8 = new Scene(layout, 1300, 650);
            window.setScene(scene8);

        });

        next.setOnAction(e -> {
            cal.add(Calendar.MONTH, 1);
            monthB.setText(monthName[(cal.get(Calendar.MONTH))]);
            year.setText(String.valueOf(cal.get(Calendar.YEAR)));
            setDates(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), layout);
            scene8 = new Scene(layout, 1300, 650);
            window.setScene(scene8);
        });

        //Pane layout = new Pane();
        //layout.getChildren().addAll(prev, next, monthB, sun, mon, tue, wed, thu, fri, sat, year);

        scene8 = new Scene(layout, 1300, 650);
        window.setScene(scene8);

    }

    public void setDates(int month, int year, Pane layout)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 1);
        ArrayList<Button> buttonList  = new ArrayList<Button>();

        int sunb=360, monb=440, tueb=520, wedb=600, thub=680, frib=760, satb=840;
        int sunby=160, monby=160, tueby=160, wedby=160, thuby=160, friby=160, satby=160;

        while (cal.get(Calendar.MONTH) == month){
            int day = cal.get(Calendar.DAY_OF_WEEK);

            if(day == Calendar.SATURDAY) {
                Button button = new Button(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
                buttonList.add(button);
                button.setTranslateX(satb);
                button.setTranslateY(satby);
                button.setStyle("-fx-base: red;");
                satby+=40;
                sunby+=40;
                monby+=40;
                tueby+=40;
                wedby+=40;
                thuby+=40;
                friby+=40;
            }
            else if(day == Calendar.SUNDAY)
            {
                Button button = new Button(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
                buttonList.add(button);
                button.setTranslateX(sunb);
                button.setTranslateY(sunby);
                //sunby+=40;
            }
            else if(day == Calendar.MONDAY)
            {
                Button button = new Button(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
                buttonList.add(button);
                button.setTranslateX(monb);
                button.setTranslateY(monby);
                //monby+=40;
            }
            else if(day == Calendar.TUESDAY)
            {
                Button button = new Button(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
                buttonList.add(button);
                button.setTranslateX(tueb);
                button.setTranslateY(tueby);
                //tueby+=40;
            }
            else if(day == Calendar.WEDNESDAY)
            {
                Button button = new Button(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
                buttonList.add(button);
                button.setTranslateX(wedb);
                button.setTranslateY(wedby);
                //wedby+=40;
            }
            else if(day == Calendar.THURSDAY)
            {
                Button button = new Button(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
                buttonList.add(button);
                button.setTranslateX(thub);
                button.setTranslateY(thuby);
                //thuby+=40;
            }
            else if(day == Calendar.FRIDAY)
            {
                Button button = new Button(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
                buttonList.add(button);
                button.setTranslateX(frib);
                button.setTranslateY(friby);
                button.setStyle("-fx-base: red;");
                //friby+=40;
            }


            cal.add(Calendar.DAY_OF_YEAR, 1);
        }

        buttonList.forEach(value -> {
            layout.getChildren().add(value);
        });



    }

    public static void main(String[] args) {
        launch(args);
    }
}
