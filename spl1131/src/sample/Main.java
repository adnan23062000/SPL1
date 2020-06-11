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
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Main extends Application {

    Stage window;
    Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8, scene9, scene10, scene11;

    Calendar cal = Calendar.getInstance();
    public static double[] CGs = new double[3];

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
        createRoutine.setTranslateX(660);
        createRoutine.setTranslateY(280);
        createRoutine.setPrefSize(150, 70);
        createRoutine.setStyle("-fx-base: black;");
        createRoutine.setOnAction(e -> regForm());

        Button seePreviousData = new Button("See Previous User Data");
        seePreviousData.setTranslateX(645);
        seePreviousData.setTranslateY(380);
        seePreviousData.setPrefSize(180, 70);
        seePreviousData.setStyle("-fx-base: black;");
        seePreviousData.setOnAction(e -> GraphMenu());

        Button others = new Button("Others");
        others.setTranslateX(680);
        others.setTranslateY(480);
        others.setPrefSize(100, 60);
        others.setStyle("-fx-base: black;");
        others.setOnAction(e -> {
            try {
                createCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

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

        Image pageTwo = new Image("abc.jpg");
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

        Image pageThree = new Image("pic3.jpg");

        Label label1 = new Label("Name: ");
        label1.setTranslateX(480);
        label1.setTranslateY(150);
        TextField name = new TextField();
        name.setTranslateX(540);
        name.setTranslateY(150);

        Label label2 = new Label("Password: ");
        label2.setTranslateX(480);
        label2.setTranslateY(200);
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Your password");
        passwordField.setTranslateX(540);
        passwordField.setTranslateY(200);

        Button button2 = new Button("Back");
        button2.setTranslateX(20);
        button2.setTranslateY(20);
        button2.setPrefSize(60, 30);

        Button create = new Button("Create Profile");
        create.setTranslateX(800);
        create.setTranslateY(510);
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
        label1.setTranslateX(450);
        label1.setTranslateY(150);

        Label label2 = new Label("Enter Your Marks: ");
        label2.setTranslateX(450);
        label2.setTranslateY(250);

        Label label3 = new Label("Math ->  ");
        label3.setTranslateX(450);
        label3.setTranslateY(280);

        Label label4 = new Label("Physics ->  ");
        label4.setTranslateX(450);
        label4.setTranslateY(310);

        Label label5 = new Label("ICT ->  ");
        label5.setTranslateX(450);
        label5.setTranslateY(340);

        Label label6 = new Label("Enter Your IQ: ");
        label6.setTranslateX(450);
        label6.setTranslateY(430);

        Label label7 = new Label("Enter Your Preferable Study Time: ");
        label7.setTranslateX(450);
        label7.setTranslateY(485);

        TextField textMath = new TextField();
        textMath.setTranslateX(530);
        textMath.setTranslateY(280);
        TextField textPhy = new TextField();
        textPhy.setTranslateX(530);
        textPhy.setTranslateY(310);
        TextField textICT = new TextField();
        textICT.setTranslateX(530);
        textICT.setTranslateY(340);

        Button submit = new Button("Submit");
        Button markResult = new Button();
        Button markResult2 = new Button();
        Button markResult3 = new Button();
        Button markResult4 = new Button();
        markResult.setTranslateX(800);
        markResult.setTranslateY(300);
        markResult.setPrefSize(150, 40);
        markResult2.setTranslateX(800);
        markResult2.setTranslateY(140);
        markResult2.setPrefSize(150, 40);
        markResult3.setTranslateX(800);
        markResult3.setTranslateY(420);
        markResult4.setTranslateX(800);
        markResult4.setTranslateY(450);
        //markResult2.setPrefSize(150, 40);
        markResult3.setPrefSize(150, 40);
        markResult4.setPrefSize(150, 40);
        submit.setTranslateX(600);
        submit.setTranslateY(380);

        Button cgEstimate = new Button("ENTER");
        cgEstimate.setTranslateX(1130);
        cgEstimate.setTranslateY(300);
        cgEstimate.setPrefSize(80, 80);
        cgEstimate.setStyle("-fx-base: black;");

        cgEstimate.setOnAction(e ->{
            cgShow();
        });


        submit.setOnAction(e -> {
            double math = Double.parseDouble(textMath.getText());
            double physics = Double.parseDouble(textPhy.getText());
            double ict = Double.parseDouble(textICT.getText());

            CGs[1] = objj.CGCalc22(math, physics, ict);
            markResult.setText(objj.CGCalc2(math, physics, ict));
        });

        final Slider slider = new Slider(0, 24, 0);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(5);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setTranslateX(560);
        slider.setTranslateY(150);

        slider.valueProperty().addListener(
                new ChangeListener<Number>() {

                    public void changed(ObservableValue <? extends Number >
                                                observable, Number oldValue, Number newValue)
                    {
                        double value = slider.getValue();
                        CGs[0] = obj2.CGCalc1(value);
                        markResult2.setText(obj2.CGCalc(value));
                    }
                });

        String st[] = { "120", "130", "140", "150" };

        ChoiceBox cbIQ = new ChoiceBox(FXCollections.observableArrayList(st));
        cbIQ.setTranslateX(550);
        cbIQ.setTranslateY(425);
        cbIQ.setPrefSize(100, 30);

        cbIQ.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                // set the text for the label to the selected item
                String x = st[new_value.intValue()];
                int xx = Integer.parseInt(x);
                if(xx==120){
                    CGs[2] = 3.35;
                    markResult3.setText("CG: 3.35");}
                if(xx==130){
                    CGs[2] = 3.50;
                    markResult3.setText("CG: 3.50");}
                if(xx==140){
                    CGs[2] = 3.75;
                    markResult3.setText("CG: 3.75");}
                if(xx==150){
                    CGs[2] = 4.00;
                    markResult3.setText("CG: 4.00");}
            }
        });

        String ab[] = { "Morning", "Noon", "Afternoon", "Evening", "Night" };

        ChoiceBox studyTime = new ChoiceBox(FXCollections.observableArrayList(ab));
        studyTime.setTranslateX(640);
        studyTime.setTranslateY(480);
        studyTime.setPrefSize(100, 30);

        studyTime.getSelectionModel().selectedIndexProperty().addListener((ov, value, new_value) -> {
            // set the text for the label to the selected item
            String x = ab[new_value.intValue()];
        });

        Image pageThree = new Image("pic3.jpg");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        Button button2 = new Button("Back");
        button2.setTranslateX(20);
        button2.setTranslateY(20);
        button2.setPrefSize(60, 30);

        System.out.println("\nweekend  " + weekend + "\nHoliday  " + holiday);

        Pane layout = new Pane();
        layout.getChildren().addAll(c, cgEstimate, label1, slider, label2, label3, label4, label5, label6, label7, textMath, textPhy, textICT, submit, markResult, markResult2, markResult3, cbIQ, studyTime, button2);

        button2.setOnAction(e -> window.setScene(scene3));
        scene4 = new Scene(layout, 1300, 650);
        window.setScene(scene4);
    }

    public void cgShow()
    {
        Image pageThree = new Image("pic3.jpg");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        Button createRoutine = new Button("Create Routine");
        createRoutine.setTranslateX(1130);
        createRoutine.setTranslateY(280);
        createRoutine.setPrefSize(90, 140);
        createRoutine.setStyle("-fx-base: black;");

        createRoutine.setOnAction(e -> {
            try {
                createCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        Button button2 = new Button("Back");
        button2.setTranslateX(20);
        button2.setTranslateY(20);
        button2.setPrefSize(60, 30);

        Label estimation = new Label("Your Estimated CGPA is:");
        estimation.setTranslateX(480);
        estimation.setTranslateY(200);
        //estimation.setStyle(" -fx-background-color: pink;");
        estimation.setFont(new Font("Algerian", 26));
        estimation.setMinWidth(100);
        estimation.setMinHeight(60);

        Label userI = new Label("Enter Your Expected CGPA: ");
        userI.setFont(new Font("Algerian", 22));
        userI.setStyle("-fx-text-fill: black");
        userI.setStyle(" -fx-background-color: cyan;");
        userI.setTranslateX(480);
        userI.setTranslateY(350);

        TextField text = new TextField();
        text.setTranslateX(850);
        text.setTranslateY(350);

        Button submit = new Button("Submit");
        submit.setTranslateX(650);
        submit.setTranslateY(390);
        submit.setFont(new Font("Ariel", 18));
        submit.setStyle("-fx-text-fill: black");
        submit.setStyle(" -fx-background-color: grey;");

        Label label3 = new Label();

        submit.setOnAction(e -> {
            double value = Double.parseDouble(text.getText());
            double est = (CGs[0]+CGs[1]+CGs[2])/3;
            if(Math.abs(value-est)<=.2)
            {
                label3.setText("* The Difference is NOT Significant ");
                label3.setTranslateX(450);
                label3.setTranslateY(470);
                label3.setFont(new Font("Bauhaus 93", 36));
            }
            else
            {
                label3.setText("* The Difference IS Significant ");
                label3.setTranslateX(450);
                label3.setTranslateY(470);
                label3.setFont(new Font("Bauhaus 93", 36));
            }

        });

        Button eCG = new Button();
        //eCG.setText(String.valueOf((CGs[0]+CGs[1]+CGs[2])/3));
        DecimalFormat df = new DecimalFormat("#.##");
        eCG.setText(df.format((CGs[0]+CGs[1]+CGs[2])/3));
        eCG.setPrefSize(100, 60);
        eCG.setFont(new Font("Algerian", 22));
        eCG.setStyle("-fx-text-fill: black");
        eCG.setStyle(" -fx-background-color: cyan;");
        eCG.setTranslateX(850);
        eCG.setTranslateY(200);

        Pane layout = new Pane();
        layout.getChildren().addAll(c, button2, estimation, eCG, userI, text, submit, label3, createRoutine);

        scene9 = new Scene(layout, 1300, 650);
        window.setScene(scene9);
    }

    public void GraphMenu()
    {
        Image pageThree = new Image("pic4.jpg");
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
        eqn.setTranslateY(140);
        eqn.setPrefSize(200, 100);

        Label label1 = new Label("The Equation is: ");
        label1.setTranslateX(720);
        label1.setTranslateY(100);

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
        label1.setTranslateY(100);

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
        eqn.setTranslateY(140);
        eqn.setPrefSize(400, 100);

        Pane layout = new Pane();
        layout.getChildren().addAll(linechart, label1, eqn, button2);

        scene7 = new Scene(layout, 1300, 650);
        window.setScene(scene7);

    }

    public void createCalendar(int year1, int month1) throws FileNotFoundException {

        Button prev = new Button(" <-- ");
        prev.setTranslateX(750);
        prev.setTranslateY(110);
        prev.setPrefSize(50, 30);
        prev.setStyle(" -fx-background-color: orange;");
        Button next = new Button(" --> ");
        next.setTranslateX(920);
        next.setTranslateY(110);
        next.setPrefSize(50, 30);
        next.setStyle(" -fx-background-color: orange;");
        Button monthB = new Button();
        monthB.setTranslateX(820);
        monthB.setTranslateY(110);
        monthB.setPrefSize(80, 30);
        monthB.setStyle(" -fx-background-color: orange;");

        int sunb=580, monb=660, tueb=740, wedb=820, thub=900, frib=980, satb=1060;

        Button sun = new Button("SUN");
        sun.setTranslateX(sunb);
        sun.setTranslateY(200);
        sun.setPrefSize(42, 30);
        sun.setStyle(" -fx-background-color: pink;");

        Button mon = new Button("MON");
        mon.setTranslateX(monb);
        mon.setTranslateY(200);
        mon.setPrefSize(46, 30);
        mon.setStyle(" -fx-background-color: pink;");

        Button tue = new Button("TUE");
        tue.setTranslateX(tueb);
        tue.setTranslateY(200);
        tue.setPrefSize(42, 30);
        tue.setStyle(" -fx-background-color: pink;");

        Button wed = new Button("WED");
        wed.setTranslateX(wedb);
        wed.setTranslateY(200);
        wed.setPrefSize(42, 30);
        wed.setStyle(" -fx-background-color: pink;");

        Button thu = new Button("THU");
        thu.setTranslateX(thub);
        thu.setTranslateY(200);
        thu.setPrefSize(42, 30);
        thu.setStyle(" -fx-background-color: pink;");

        Button fri = new Button("FRI");
        fri.setStyle("-fx-base: red;");
        fri.setTranslateX(frib);
        fri.setTranslateY(200);
        fri.setPrefSize(42, 30);

        Button sat = new Button("SAT");
        sat.setStyle("-fx-base: red;");
        sat.setTranslateX(satb);
        sat.setTranslateY(200);
        sat.setPrefSize(42, 30);

        Button year = new Button();
        year.setTranslateX(830);
        year.setTranslateY(80);
        year.setPrefSize(60, 20);
        year.setStyle(" -fx-background-color: orange;");

        String[] monthName = {"January", "February",
                "March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};
        //String month = monthName[cal.get(Calendar.MONTH)];
        monthB.setText(monthName[month1]);
        year.setText(String.valueOf(year1));

        Image pageThree = new Image("calendar.jpg");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        Pane layout = new Pane();
        layout.getChildren().addAll(c, prev, next, monthB, sun, mon, tue, wed, thu, fri, sat, year);
        setDates(cal.get(Calendar.MONTH), cal.get(Calendar.YEAR), layout);

        prev.setOnAction(e -> {

            cal.add(Calendar.MONTH, -1);
            monthB.setText(monthName[(cal.get(Calendar.MONTH))]);
            year.setText(String.valueOf(cal.get(Calendar.YEAR)));
            try {
                setDates(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), layout);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            try {
                createCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        next.setOnAction(e -> {
            cal.add(Calendar.MONTH, 1);
            monthB.setText(monthName[(cal.get(Calendar.MONTH))]);
            year.setText(String.valueOf(cal.get(Calendar.YEAR)));
            try {
                setDates(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), layout);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            try {
                createCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        //Pane layout = new Pane();
        //layout.getChildren().addAll(prev, next, monthB, sun, mon, tue, wed, thu, fri, sat, year);

        scene8 = new Scene(layout, 1300, 650);
        window.setScene(scene8);

    }

    public void setDates(int month, int year, Pane layout) throws FileNotFoundException {

        Calendar today = Calendar.getInstance();
        int yearT = today.get(Calendar.YEAR);
        int monthT = today.get(Calendar.MONTH);
        int dayT = today.get(Calendar.DAY_OF_MONTH);

         System.out.println(dayT + " " + monthT + " " + yearT);

        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 1);
        ArrayList<Button> buttonList  = new ArrayList<Button>();

        HolidayCheck obj = new HolidayCheck();

        int sunb=580, monb=660, tueb=740, wedb=820, thub=900, frib=980, satb=1060;
        //int sunb=360, monb=440, tueb=520, wedb=600, thub=680, frib=760, satb=840;
        int sunby=260, monby=260, tueby=260, wedby=260, thuby=260, friby=260, satby=260;

        while (cal.get(Calendar.MONTH) == month){

            int day = cal.get(Calendar.DAY_OF_WEEK);
            int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

            if(day == Calendar.SATURDAY) {
                Button button = new Button(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
                String s = String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) + "-" + String.valueOf(cal.get(Calendar.MONTH)+1) + "-" + String.valueOf(cal.get(Calendar.YEAR));
                if(obj.IsHoliday(s))
                {
                    //String str = obj.HolidayName();

                    Label label = new Label(obj.HolidayName());
                    label.setTranslateX(400);
                    label.setTranslateY(250);
                    label.setStyle(" -fx-background-color: pink;");
                    label.setFont(new Font("Arial", 24));
                    label.setMinWidth(100);
                    label.setMinHeight(60);
                    Popup popup = new Popup();
                    popup.getContent().add(label);
                    popup.setAutoHide(true);
                    button.setOnAction(e ->{
                        if (!popup.isShowing()) {
                            popup.show(window);
                        }
                    });
                }
                buttonList.add(button);
                button.setTranslateX(satb);
                button.setTranslateY(satby);
                if(dayT==dayOfMonth && monthT==month && yearT==year)
                {
                    button.setStyle("-fx-base: cyan;");
                    button.setOnAction(e -> {
                        try {
                            ExtraSubject(2);
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        }
                    });
                }
                else
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
                String s = String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) + "-" + String.valueOf(cal.get(Calendar.MONTH)+1) + "-" + String.valueOf(cal.get(Calendar.YEAR));
                if(obj.IsHoliday(s))
                {
                    if(dayT==dayOfMonth && monthT==month && yearT==year)
                {
                    button.setStyle("-fx-base: cyan;");
                    button.setOnAction(e -> {
                        try {
                            ExtraSubject(1);
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        }
                    });
                }
                else
                    button.setStyle("-fx-base: red;");

                Label label = new Label(obj.HolidayName());
                label.setStyle(" -fx-background-color: pink;");
                label.setFont(new Font("Arial", 24));
                label.setMinWidth(120);
                label.setMinHeight(70);
                label.setTranslateX(400);
                label.setTranslateY(250);
                Popup popup = new Popup();
                popup.getContent().add(label);
                popup.setAutoHide(true);
                button.setOnAction(e ->{
                    if (!popup.isShowing()) {
                            popup.show(window);
                    }
                    });
                }
                if(dayT==dayOfMonth && monthT==month && yearT==year)
                {
                    button.setStyle("-fx-base: cyan;");
                    button.setOnAction(e -> {
                        try {
                            ExtraSubject(2);
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        }
                    });
                }
                buttonList.add(button);
                button.setTranslateX(sunb);
                button.setTranslateY(sunby);
                //sunby+=40;
            }
            else if(day == Calendar.MONDAY)
            {
                Button button = new Button(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
                String s = String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) + "-" + String.valueOf(cal.get(Calendar.MONTH)+1) + "-" + String.valueOf(cal.get(Calendar.YEAR));
                if(obj.IsHoliday(s))
                {
                    //String str = obj.HolidayName();
                    if(dayT==dayOfMonth && monthT==month && yearT==year)
                    {
                        button.setStyle("-fx-base: blue;");
                        button.setOnAction(e -> {
                            try {
                                ExtraSubject(2);
                            } catch (FileNotFoundException fileNotFoundException) {
                                fileNotFoundException.printStackTrace();
                            }
                        });
                    }
                    else
                        button.setStyle("-fx-base: red;");
                    Label label = new Label(obj.HolidayName());
                    label.setStyle(" -fx-background-color: pink;");
                    label.setFont(new Font("Arial", 24));
                    label.setMinWidth(120);
                    label.setMinHeight(70);
                    label.setTranslateX(400);
                    label.setTranslateY(250);
                    Popup popup = new Popup();
                    popup.getContent().add(label);
                    popup.setAutoHide(true);
                    button.setOnAction(e ->{
                        if (!popup.isShowing()) {
                            popup.show(window);
                        }
                    });
                }
                if(dayT==dayOfMonth && monthT==month && yearT==year)
                {
                    button.setStyle("-fx-base: cyan;");
                    button.setOnAction(e -> {
                        try {
                            ExtraSubject(2);
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        }
                    });
                }
                buttonList.add(button);
                button.setTranslateX(monb);
                button.setTranslateY(monby);
                //monby+=40;
            }
            else if(day == Calendar.TUESDAY)
            {
                Button button = new Button(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
                String s = String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) + "-" + String.valueOf(cal.get(Calendar.MONTH)+1) + "-" + String.valueOf(cal.get(Calendar.YEAR));
                if(obj.IsHoliday(s))
                {
                    //String str = obj.HolidayName();
                    if(dayT==dayOfMonth && monthT==month && yearT==year)
                    {
                        button.setStyle("-fx-base: cyan;");
                        button.setOnAction(e -> {
                            try {
                                ExtraSubject(2);
                            } catch (FileNotFoundException fileNotFoundException) {
                                fileNotFoundException.printStackTrace();
                            }
                        });
                    }
                    else
                        button.setStyle("-fx-base: red;");
                    Label label = new Label(obj.HolidayName());
                    label.setStyle(" -fx-background-color: pink;");
                    label.setFont(new Font("Arial", 24));
                    label.setMinWidth(120);
                    label.setMinHeight(70);
                    label.setTranslateX(400);
                    label.setTranslateY(250);
                    Popup popup = new Popup();
                    popup.getContent().add(label);
                    popup.setAutoHide(true);
                    button.setOnAction(e ->{
                        if (!popup.isShowing()) {
                            popup.show(window);
                        }
                    });
                }
                if(dayT==dayOfMonth && monthT==month && yearT==year)
                {
                    button.setStyle("-fx-base: cyan;");
                    button.setOnAction(e -> {
                        try {
                            ExtraSubject(2);
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        }
                    });
                }
                buttonList.add(button);
                button.setTranslateX(tueb);
                button.setTranslateY(tueby);
                //tueby+=40;
            }
            else if(day == Calendar.WEDNESDAY)
            {
                Button button = new Button(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
                String s = String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) + "-" + String.valueOf(cal.get(Calendar.MONTH)+1) + "-" + String.valueOf(cal.get(Calendar.YEAR));
                if(obj.IsHoliday(s))
                {
                    //String str = obj.HolidayName();
                    if(dayT==dayOfMonth && monthT==month && yearT==year)
                    {
                        button.setStyle("-fx-base: cyan;");
                        button.setOnAction(e -> {
                            try {
                                ExtraSubject(2);
                            } catch (FileNotFoundException fileNotFoundException) {
                                fileNotFoundException.printStackTrace();
                            }
                        });
                    }
                    else
                        button.setStyle("-fx-base: red;");
                    Label label = new Label(obj.HolidayName());
                    label.setStyle(" -fx-background-color: pink;");
                    label.setFont(new Font("Arial", 24));
                    label.setMinWidth(120);
                    label.setMinHeight(70);
                    label.setTranslateX(400);
                    label.setTranslateY(250);
                    Popup popup = new Popup();
                    popup.getContent().add(label);
                    popup.setAutoHide(true);
                    button.setOnAction(e ->{
                        if (!popup.isShowing()) {
                            popup.show(window);
                        }
                    });
                }
                if(dayT==dayOfMonth && monthT==month && yearT==year)
                {
                    button.setStyle("-fx-base: cyan;");
                    button.setOnAction(e -> {
                        try {
                            ExtraSubject(2);
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        }
                    });
                }
                buttonList.add(button);
                button.setTranslateX(wedb);
                button.setTranslateY(wedby);
                //wedby+=40;
            }
            else if(day == Calendar.THURSDAY)
            {
                Button button = new Button(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
                String s = String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) + "-" + String.valueOf(cal.get(Calendar.MONTH)+1) + "-" + String.valueOf(cal.get(Calendar.YEAR));
                if(obj.IsHoliday(s))
                {
                    //String str = obj.HolidayName();
                    if(dayT==dayOfMonth && monthT==month && yearT==year)
                    {
                        button.setStyle("-fx-base: cyan;");
                        button.setOnAction(e -> {
                            try {
                                ExtraSubject(2);
                            } catch (FileNotFoundException fileNotFoundException) {
                                fileNotFoundException.printStackTrace();
                            }
                        });
                    }
                    else
                        button.setStyle("-fx-base: red;");
                    Label label = new Label(obj.HolidayName());
                    label.setStyle(" -fx-background-color: pink;");
                    label.setFont(new Font("Arial", 24));
                    label.setMinWidth(120);
                    label.setMinHeight(70);
                    label.setTranslateX(400);
                    label.setTranslateY(250);
                    Popup popup = new Popup();
                    popup.getContent().add(label);
                    popup.setAutoHide(true);
                    button.setOnAction(e ->{
                        if (!popup.isShowing()) {
                            popup.show(window);
                        }
                    });
                }
                if(dayT==dayOfMonth && monthT==month && yearT==year)
                {
                    button.setStyle("-fx-base: cyan;");
                    button.setOnAction(e -> {
                        try {
                            ExtraSubject(2);
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        }
                    });
                }
                buttonList.add(button);
                button.setTranslateX(thub);
                button.setTranslateY(thuby);
                //thuby+=40;
            }
            else if(day == Calendar.FRIDAY)
            {
                Button button = new Button(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
                String s = String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) + "-" + String.valueOf(cal.get(Calendar.MONTH)+1) + "-" + String.valueOf(cal.get(Calendar.YEAR));
                if(obj.IsHoliday(s))
                {
                    String str = obj.HolidayName();
                    if(dayT==dayOfMonth && monthT==month && yearT==year)
                    {
                        button.setStyle("-fx-base: cyan;");
                        button.setOnAction(e -> {
                            try {
                                ExtraSubject(2);
                            } catch (FileNotFoundException fileNotFoundException) {
                                fileNotFoundException.printStackTrace();
                            }
                        });
                    }
                    else
                        button.setStyle("-fx-base: red;");
                    Label label = new Label(obj.HolidayName());
                    label.setStyle(" -fx-background-color: pink;");
                    label.setFont(new Font("Arial", 24));
                    label.setMinWidth(120);
                    label.setMinHeight(70);
                    label.setTranslateX(400);
                    label.setTranslateY(250);
                    Popup popup = new Popup();
                    popup.getContent().add(label);
                    popup.setAutoHide(true);
                    button.setOnAction(e ->{
                        if (!popup.isShowing()) {
                            popup.show(window);
                        }
                    });
                }
                if(dayT==dayOfMonth && monthT==month && yearT==year)
                {
                    button.setStyle("-fx-base: cyan;");
                    button.setOnAction(e -> {
                        try {
                            ExtraSubject(2);
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        }
                    });
                }
                else
                    button.setStyle("-fx-base: red;");
                buttonList.add(button);
                button.setTranslateX(frib);
                button.setTranslateY(friby);
                //friby+=40;
            }


            cal.add(Calendar.DAY_OF_YEAR, 1);
        }

        buttonList.forEach(value -> {
            layout.getChildren().add(value);
        });
    }

    public void MakeRoutine(String[] Rsubjects, ArrayList<String> Esub) throws FileNotFoundException {

        Pane layout = new Pane();

        Image pageThree = new Image("pic3.jpg");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        Button routine = new Button("ROUTINE");
        routine.setTranslateX(620);
        routine.setTranslateY(120);
        routine.setFont(new Font("Ariel", 30));
        routine.setStyle("-fx-text-fill: black");
        routine.setStyle(" -fx-background-color: grey;");

        layout.getChildren().addAll(c, routine);

        for(int j=0;j<3;j++)
            System.out.println(Rsubjects[j]);

        ArrayList<Button> buttonList = new ArrayList<Button>();
        int yy=200;
        for(int i=0;i<3;i++)
        {
            if(Rsubjects[i].equals("null"))
                continue;

            Button b = new Button("#" + Rsubjects[i]);
            b.setTranslateX(500);
            b.setTranslateY(yy);
            b.setFont(new Font("Rockwell Extra Bold", 18));
            b.setStyle("-fx-text-fill: black");
            b.setStyle(" -fx-background-color: mediumspringgreen;");
            yy+=60;

            buttonList.add(b);

        }

        for(int i = 0; i < Esub.size(); i++) {
            Button b2 = new Button("#"+Esub.get(i));
            b2.setTranslateX(500);
            b2.setTranslateY(yy);
            b2.setFont(new Font("Rockwell Extra Bold", 18));
            b2.setStyle("-fx-text-fill: black");
            b2.setStyle(" -fx-background-color: mediumspringgreen;");
            yy+=60;

            buttonList.add(b2);
        }

        buttonList.forEach(value -> {
            layout.getChildren().add(value);
        });



        Button t1 = new Button();
        Button t2 = new Button();
        Button t3 = new Button();



        //layout.getChildren().addAll(c, routine, t1, t2, t3);
        scene10 = new Scene(layout, 1300, 650);
        window.setScene(scene10);
    }

    public void ExtraSubject (int n) throws FileNotFoundException {

        File file = new File("D:\\newfolder\\classRoutine.txt");
        Scanner scanner = new Scanner(file);
        String[] str = new String[3];

        while (scanner.hasNextLine())
        {
            String[] elements = scanner.nextLine().split("->", 0);
            int dayToday = Integer.parseInt(elements[0]);

            LocalDate date = LocalDate.now();
            DayOfWeek day = DayOfWeek.from(date);

            int val = day.getValue();

            if (val == dayToday) {
                str[0]=elements[1];
                str[1]=elements[2];
                str[2]=elements[3];
                break;
            }
        }

        Pane layout = new Pane();

        Image pageThree = new Image("pic3.jpg");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        Label label1 = new Label();
        //label1.setStyle(" -fx-background-color: Orange;");
        label1.setFont(new Font("Rockwell Extra Bold", 20));
        label1.setMinWidth(120);
        label1.setMinHeight(70);
        label1.setTranslateX(460);
        label1.setTranslateY(150);

        Button b1 = new Button();
        b1.setText("YES");
        Button b2 = new Button("NO");
        b1.setTranslateX(550);
        b1.setTranslateY(230);
        b2.setTranslateX(650);
        b2.setTranslateY(230);
        b1.setPrefHeight(30);
        b1.setPrefWidth(80);
        b2.setPrefHeight(30);
        b2.setPrefWidth(80);

        if(n==1)
        {
            label1.setText("Today is a holiday.\nDo you want to study today?");
        }

        if(n==2)
        {
            label1.setText("#Do you want to study any extra subjects\napart from your class routine today?");
        }

        HolidayCheck11 obj = new HolidayCheck11();

        ArrayList<String> Esub = new ArrayList<>();

        b1.setOnAction(e -> {

            Label l = new Label("#Select from the available Subjects:");
            l.setFont(new Font("Rockwell Extra Bold", 20));
            l.setTranslateX(460);
            l.setTranslateY(300);
            layout.getChildren().add(l);
            String[] ara = new String[]{"Introduction to Structured Programming", "Discrete Mathematics", "Calculus and Analytical Geometry", "Probability and Statistics", "Sociology", "Introduction to Software Engineering"};

            ArrayList<Button> buttonList = new ArrayList<Button>();
            int x = 460;
            int y = 350;
            for (int i = 0; i < 6; i++) {

                if (str[0].equals(ara[i]))
                    continue;
                if (str[1].equals(ara[i]))
                    continue;
                if (str[2].equals(ara[i]))
                    continue;


                Button b = new Button(ara[i]);
                String s = ara[i];
                b.setFont(new Font("Rockwell Extra Bold", 18));
                b.setStyle("-fx-text-fill: black");
                b.setStyle(" -fx-background-color: powderblue;");
                b.setTranslateX(x);
                b.setTranslateY(y);
                y += 40;

                b.setOnAction(E -> {
                    Esub.add(s);
                });

                layout.getChildren().add(b);
            }

            buttonList.forEach(value -> {
                layout.getChildren().add(value);
            });
        });

        b2.setOnAction(e -> {
            try {
                MakeRoutine(str, Esub);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        Button done = new Button("Create\nRoutine");
        done.setTranslateX(920);
        done.setTranslateY(520);
        done.setStyle(" -fx-background-color: grey;");

        done.setOnAction(E -> {
            try {
                MakeRoutine(str, Esub);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        layout.getChildren().addAll(c, label1, b1, b2, done);
        scene11 = new Scene(layout, 1300, 650);
        window.setScene(scene11);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
