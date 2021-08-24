package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class Main extends Application {

    Stage window;
    Scene scene1, scene2, scene002, scene01, scene02, scene03, scene3, scene4, scene5, scene6, scene7, scene8, scene9, scene10, scene11, scene12, scene13, scene14, scene15, scene16, scene17, scene18, scene19, scene20, scene21;
    String start, end, prefTime;
    int second=0, minute, hour;
    int timeup=0;
    double remainDay;

    Calendar cal = Calendar.getInstance();
    public static double[] CGs = new double[3];

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setTitle("Routine Dynamics");

        Button button1 = new Button("START");
        button1.setTranslateX(600);
        button1.setTranslateY(350);
        button1.setPrefSize(100, 60);
        button1.setOnAction(e -> {
            try {
                PageTwo();
            } catch (ParseException | FileNotFoundException parseException) {
                parseException.printStackTrace();
            }
        });

        Button exitBtn = new Button("Exit");
        exitBtn.setTranslateX(600);
        exitBtn.setTranslateY(450);
        exitBtn.setPrefSize(100, 60);
        exitBtn.setOnAction(e -> Platform.exit());

        Pane layout1 = new Pane();
        layout1.getChildren().addAll(button1, exitBtn);

        scene1 = new Scene(layout1, 1300, 670);

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

        window.setScene(scene1);
        window.show();
    }

    public void DynamicRoutine() throws IOException, FileNotFoundException
    {
        Image pageThree = new Image("page3bg.png");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);


        Button b = new Button("View Calendar");
        b.setFont(new Font("Rockwell Extra Bold", 18));
        b.setStyle("-fx-text-fill: black");
        b.setStyle(" -fx-background-color: powderblue;");
        b.setTranslateX(700);
        b.setTranslateY(400);
        b.setOnAction(e -> {
            try {
                createCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });



        Pane layout = new Pane();
        layout.getChildren().addAll(c, b);
        scene21 = new Scene(layout, 1300, 650);

        window.setScene(scene21);
    }

    public void AddEvent() throws IOException
    {

        Image pageThree = new Image("pic4.JPG");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        Label l = new Label("Add Your Event: ");
        l.setTranslateX(600);
        l.setTranslateY(300);
        l.setFont(new Font("Algerian", 28));
        l.setMinWidth(100);
        l.setMinHeight(60);

        Button b1 = new Button("Holiday");
        Button b2 = new Button("Academic\n  Event");
        b1.setTranslateX(580);
        b1.setTranslateY(400);
        b1.setPrefSize(100, 40);
        b1.setStyle("-fx-text-fill: black");
        b1.setStyle(" -fx-background-color: powderblue;");
        b2.setTranslateX(750);
        b2.setTranslateY(400);
        b2.setPrefSize(100, 40);
        b2.setStyle("-fx-text-fill: black");
        b2.setStyle(" -fx-background-color: powderblue;");

        b1.setOnAction(e -> {
            try {
                EventAdder(1);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        b2.setOnAction(e -> {
            try {
                EventAdder(2);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        Button button2 = new Button("Back");
        button2.setTranslateX(20);
        button2.setTranslateY(20);
        button2.setPrefSize(60, 30);

        button2.setOnAction(e ->{
            try {
                createCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        Pane layout = new Pane();
        layout.getChildren().addAll(c, l, b1, b2, button2);
        scene16 = new Scene(layout, 1300, 650);

        window.setScene(scene16);
    }

    public void EventAdder(int n) throws IOException
    {
        Image pageThree = new Image("pic3.JPG");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        DateToInt obj = new DateToInt();

        String st[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        ChoiceBox cbIQ = new ChoiceBox(FXCollections.observableArrayList(st));
        cbIQ.setTranslateX(675);
        cbIQ.setTranslateY(230);
        cbIQ.setPrefSize(100, 30);

        Label l1 = new Label("Date: ");
        l1.setTranslateX(460);
        l1.setTranslateY(230);
        l1.setFont(new Font("Algerian", 22));

        String da[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11","12","13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

        ChoiceBox cbDate = new ChoiceBox(FXCollections.observableArrayList(da));
        cbDate.setTranslateX(560);
        cbDate.setTranslateY(230);
        cbDate.setPrefSize(100, 30);

        String ye[] = {"2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026"};

        ChoiceBox cbYear = new ChoiceBox(FXCollections.observableArrayList(ye));
        cbYear.setTranslateX(800);
        cbYear.setTranslateY(230);
        cbYear.setPrefSize(100, 30);

        cbDate.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                // set the text for the label to the selected item
                String x = da[new_value.intValue()];
                start = x + '-';
                //System.out.println(start);
            }
        });


        cbIQ.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                // set the text for the label to the selected item
                String x = st[new_value.intValue()];
                start += obj.MonthToInt(x);
                System.out.println(start);
            }
        });


        cbYear.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                // set the text for the label to the selected item
                String x = ye[new_value.intValue()];
                start += '-' + x;
                //System.out.println(start);
            }
        });

        Label l2 = new Label("Event Name: ");
        l2.setTranslateX(460);
        l2.setTranslateY(330);
        l2.setFont(new Font("Algerian", 22));

        TextField name = new TextField();
        name.setTranslateX(620);
        name.setTranslateY(330);

        Button submit = new Button("Submit");
        submit.setTranslateX(640);
        submit.setTranslateY(370);

        String way;

        if(n==1)
            way = "src\\holiday.txt";
        else
            way = "src\\exam.txt";


        Button button2 = new Button("Back");
        button2.setTranslateX(20);
        button2.setTranslateY(20);
        button2.setPrefSize(60, 30);

        button2.setOnAction(e ->{
            try {
                createCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        submit.setOnAction(e -> {

            String textToAppend = "\r\n" + name.getText() + "->" + start;
            System.out.println(textToAppend);
            System.out.println("start: " + start);
            Path path = Paths.get(way);
            try {
                Files.write(path, textToAppend.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            try {
                createCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });


        Pane layout = new Pane();
        layout.getChildren().addAll(c, l1, l2, name, submit, cbIQ, cbDate, cbYear, button2);
        scene17 = new Scene(layout, 1300, 650);

        window.setScene(scene17);
    }

    public void PageTwo() throws FileNotFoundException, ParseException
    {
        Image pageThree = new Image("abc.JPG");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        /*Dynamic1 obj = new Dynamic1();
        try {
            obj.TimeDuration();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }*/

        /*Dynamic2 obj = new Dynamic2();
        try {
            obj.WriteTimeToFile();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try {
            obj.ReadTimeFromFile();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }*/


        Button button1 = new Button("Create An Account");
        button1.setTranslateX(665);
        button1.setTranslateY(300);
        button1.setPrefSize(140, 60);
        button1.setPrefSize(150, 60);
        button1.setStyle("-fx-base: black;");

        Button existingAccount = new Button("See existing\n  account");
        existingAccount.setTranslateX(665);
        existingAccount.setTranslateY(400);
        existingAccount.setPrefSize(140, 60);
        existingAccount.setPrefSize(150, 60);
        existingAccount.setStyle("-fx-base: black;");

        Button button2 = new Button("Back");
        button2.setTranslateX(20);
        button2.setTranslateY(20);
        button2.setPrefSize(60, 30);
        button2.setOnAction(e -> window.setScene(scene1));

        Button b3 = new Button("See previous users'\nperformance graph");
        b3.setTranslateX(665);
        b3.setTranslateY(500);
        b3.setPrefSize(150, 60);
        b3.setStyle("-fx-base: black;");

        b3.setOnAction(e -> GraphMenu());

        button1.setOnAction(e -> CreateAccount());

        existingAccount.setOnAction(e -> {
            try {
                viewProfile();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        Pane layout1 = new Pane();
        layout1.getChildren().addAll(c, button1, existingAccount, b3, button2);
        scene01 = new Scene(layout1, 1300, 650);

        window.setScene(scene01);
    }

    public void CreateAccount()
    {
        Image pageThree = new Image("pic4.JPG");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        File file = new File("src\\ProfileInput.txt");

        Label l = new Label("Another Account already exists\nDo you want to create a new account?");
        l.setTranslateX(450);
        l.setTranslateY(300);
        l.setFont(new Font("Algerian", 26));
        l.setMinWidth(100);
        l.setMinHeight(60);

        Button button2 = new Button("Back");
        button2.setTranslateX(20);
        button2.setTranslateY(20);
        button2.setPrefSize(60, 30);
        button2.setOnAction(e -> window.setScene(scene01));

        Button b1 = new Button("yes");
        Button b2 = new Button("no");
        b1.setTranslateX(580);
        b1.setTranslateY(400);
        b1.setPrefSize(100, 40);
        b1.setStyle("-fx-text-fill: black");
        b1.setStyle(" -fx-background-color: powderblue;");
        b2.setTranslateX(750);
        b2.setTranslateY(400);
        b2.setPrefSize(100, 40);
        b2.setStyle("-fx-text-fill: black");
        b2.setStyle(" -fx-background-color: powderblue;");

        b1.setOnAction(e -> {
            try {
                CreateAccount2();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        b2.setOnAction(e -> {
            try {
                try {
                    PageTwo();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        });

        if(file.length()==0)
        {
            try {
                CreateAccount2();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else
        {
            Pane layout = new Pane();
            layout.getChildren().addAll(c, l, b1, b2, button2);
            scene002 = new Scene(layout, 1300, 650);

            window.setScene(scene002);
        }


    }

    public void CreateAccount2() throws FileNotFoundException {

        Image pageThree = new Image("pic4.JPG");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);


        Label label1 = new Label("Name: ");
        label1.setTranslateX(480);
        label1.setTranslateY(350);
        label1.setFont(new Font("Algerian", 22));
        label1.setMinWidth(100);
        label1.setMinHeight(60);
        TextField name = new TextField();
        name.setTranslateX(610);
        name.setTranslateY(370);

        Label label2 = new Label("Password: ");
        label2.setTranslateX(480);
        label2.setTranslateY(400);
        label2.setFont(new Font("Algerian", 22));
        label2.setMinWidth(100);
        label2.setMinHeight(60);
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Your password");
        passwordField.setTranslateX(610);
        passwordField.setTranslateY(420);

        Label l3 = new Label("Account Created!!!");
        l3.setTranslateX(500);
        l3.setTranslateY(520);
        l3.setFont(new Font("Algerian", 18));
        l3.setMinWidth(100);
        l3.setMinHeight(60);
        l3.setStyle("-fx-color: blue");
        l3.setVisible(false);

        Button next = new Button("Next");
        next.setTranslateX(900);
        next.setTranslateY(520);
        next.setVisible(false);
        next.setStyle("-fx-text-fill: black");
        next.setStyle(" -fx-background-color: powderblue;");

        Button button2 = new Button("Back");
        button2.setTranslateX(20);
        button2.setTranslateY(20);
        button2.setPrefSize(60, 30);
        button2.setOnAction(e -> {
            try {
                PageTwo();
            } catch (ParseException | FileNotFoundException parseException) {
                parseException.printStackTrace();
            }
        });

        Button submit = new Button("Submit");
        submit.setTranslateX(750);
        submit.setTranslateY(470);
        submit.setStyle("-fx-text-fill: black");
        submit.setStyle(" -fx-background-color: powderblue;");

        submit.setOnAction(e -> {
            try {
                FileWrite(name.getText() + "->" + passwordField.getText());
                l3.setVisible(true);
                next.setVisible(true);

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        next.setOnAction(e -> {
            try {
                InputData();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        Pane layout = new Pane();
        layout.getChildren().addAll(c, label1, label2, l3, name, next, passwordField, submit, button2);
        scene02 = new Scene(layout, 1300, 650);

        window.setScene(scene02);
    }


    public void FileWrite(String value) throws IOException {

        //System.out.println(value);


            File file = new File("src\\ProfileInput.txt");

            FileWriter writer = new FileWriter(file);
            PrintWriter pw = new PrintWriter(writer);
            pw.println(value);
            pw.close();

        //System.out.println("Successfully wrote to the file.");
    }

    public void FileWrite2(String value) throws IOException {

        File file = new File("src\\CG.txt");

        FileWriter writer = new FileWriter(file, false);
        PrintWriter pw = new PrintWriter(writer);
        pw.println(value);
        pw.close();
    }

    public void viewProfile() throws FileNotFoundException{

        Image pageThree = new Image("pic4.JPG");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        File file = new File("src\\ProfileInput.txt");
        Scanner scanner = new Scanner(file);

        Button b = new Button();
        b.setTranslateX(550);
        b.setTranslateY(340);
        b.setPrefSize(300, 80);
        b.setStyle("-fx-font-size:30px");
        //b.setStyle("-fx-base: black;");

        Button button2 = new Button("Back");
        button2.setTranslateX(20);
        button2.setTranslateY(20);
        button2.setPrefSize(60, 30);
        button2.setOnAction(e -> window.setScene(scene01));

        Label l = new Label("Password: ");
        l.setTranslateX(540);
        l.setTranslateY(425);
        l.setVisible(false);

        Label l2 = new Label("Passwords don't match");
        l2.setTranslateX(560);
        l2.setTranslateY(460);
        l2.setStyle("-fx-color: red");
        l2.setVisible(false);

        PasswordField pf = new PasswordField();
        pf.setTranslateX(600);
        pf.setTranslateY(420);
        pf.setVisible(false);

        Button submit = new Button("submit");
        submit.setTranslateX(760);
        submit.setTranslateY(420);
        submit.setVisible(false);

        RemainingDays obj = new RemainingDays();
        double days = obj.DateConvertString();
        //System.out.println("Days to go: " + days);

        String pass = null;

        while(scanner.hasNextLine()) {

            String[] elements = scanner.nextLine().split("->", 0);
            String name = elements[0];
            b.setText(name);
            pass = elements[1];
        }

        b.setOnAction(e -> {
                submit.setVisible(true);
                pf.setVisible(true);
                l.setVisible(true);
        });

        String finalPass = pass;
        submit.setOnAction(f -> {
                    String s = pf.getText();
                    if(s.equals(finalPass))
                    {
                        try {
                            DynamicRoutine();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else
                    {
                        l2.setVisible(true);
                    }
                });

        Pane layout = new Pane();
        layout.getChildren().addAll(c, b, submit, pf, l, l2, button2);
        scene03 = new Scene(layout, 1300, 650);

        window.setScene(scene03);

    }

    public void InputData() throws FileNotFoundException {

        File_Operations obj = new File_Operations();
        obj.File_Subjects();

        MultipleRegression objj = new MultipleRegression();
        objj.multiRegression();

        LinearRegression obj2 = new LinearRegression();
        obj2.xyMethod(1);
        obj2.setMeanXY();
        obj2.summationXY();
        obj2.AlphaBetaCalc();

        Label label1 = new Label("Enter Study Hour:  ");
        label1.setFont(new Font("Algerian", 18));
        label1.setTranslateX(450);
        label1.setTranslateY(150);

        Label label2 = new Label("Enter Your HSC Marks: ");
        label2.setFont(new Font("Algerian", 18));
        label2.setTranslateX(450);
        label2.setTranslateY(250);

        Label label3 = new Label("Math ->  ");
        label3.setFont(new Font("Algerian", 18));
        label3.setTranslateX(450);
        label3.setTranslateY(280);

        Label label4 = new Label("Physics ->  ");
        label4.setFont(new Font("Algerian", 18));
        label4.setTranslateX(450);
        label4.setTranslateY(310);

        Label label5 = new Label("ICT ->  ");
        label5.setFont(new Font("Algerian", 18));
        label5.setTranslateX(450);
        label5.setTranslateY(340);

        Label label6 = new Label("Enter Your IQ: ");
        label6.setFont(new Font("Algerian", 18));
        label6.setTranslateX(450);
        label6.setTranslateY(430);

        Label label7 = new Label("Enter Your Preferable Study Time: ");
        label7.setFont(new Font("Algerian", 18));
        label7.setTranslateX(450);
        label7.setTranslateY(485);

        TextField textMath = new TextField();
        textMath.setTranslateX(570);
        textMath.setTranslateY(280);
        TextField textPhy = new TextField();
        textPhy.setTranslateX(570);
        textPhy.setTranslateY(310);
        TextField textICT = new TextField();
        textICT.setTranslateX(570);
        textICT.setTranslateY(340);

        Button submit = new Button("Submit");
        Button markResult = new Button();
        Button markResult2 = new Button();
        Button markResult3 = new Button();
        Button markResult4 = new Button();
        markResult.setTranslateX(800);
        markResult.setTranslateY(300);
        markResult.setPrefSize(150, 60);
        markResult.setOnAction(e -> {
            LinearText();
        });

        markResult2.setTranslateX(800);
        markResult2.setTranslateY(140);
        markResult2.setPrefSize(150, 60);
        markResult2.setOnAction(e -> {
            MultiText();
        });
        markResult3.setTranslateX(850);
        markResult3.setTranslateY(420);
        markResult4.setTranslateX(800);
        markResult4.setTranslateY(450);
        //markResult2.setPrefSize(150, 40);
        markResult3.setPrefSize(150, 40);
        markResult4.setPrefSize(150, 40);
        submit.setTranslateX(600);
        submit.setTranslateY(380);

        Button iqtest = new Button("IQ Test");
        iqtest.setTranslateX(610);
        iqtest.setTranslateY(425);
        iqtest.setOnAction(e -> IQExam());

        Button cgEstimate = new Button("ENTER");
        cgEstimate.setTranslateX(1130);
        cgEstimate.setTranslateY(300);
        cgEstimate.setPrefSize(80, 80);
        cgEstimate.setStyle("-fx-base: black;");

        cgEstimate.setOnAction(e ->{
            try {
                cgShow();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        submit.setOnAction(e -> {
            double math = Double.parseDouble(textMath.getText());
            double physics = Double.parseDouble(textPhy.getText());
            double ict = Double.parseDouble(textICT.getText());

            CGs[1] = objj.CGCalc22(math, physics, ict);
            markResult.setText("Multiple Regression's\n  CG estimation\n" + objj.CGCalc2(math, physics, ict));
        });

        final Slider slider = new Slider(0, 24, 0);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(5);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setTranslateX(650);
        slider.setTranslateY(150);

        slider.valueProperty().addListener(
                new ChangeListener<Number>() {

                    public void changed(ObservableValue<? extends Number >
                                                observable, Number oldValue, Number newValue)
                    {
                        double value = slider.getValue();
                        CGs[0] = obj2.CGCalc1(value);
                        markResult2.setText("Linear regression's\n  CG estimation\n" + obj2.CGCalc(value));
                    }
                });

        String st[] = { "120", "130", "140", "150" };

        ChoiceBox cbIQ = new ChoiceBox(FXCollections.observableArrayList(st));
        cbIQ.setTranslateX(700);
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

        String ab[] = { "Morning", "Noon", "Afternoon", "Evening", "Night", "Anytime" };

        ChoiceBox studyTime = new ChoiceBox(FXCollections.observableArrayList(ab));
        studyTime.setTranslateX(580);
        studyTime.setTranslateY(520);
        studyTime.setPrefSize(100, 30);

        studyTime.getSelectionModel().selectedIndexProperty().addListener((ov, value, new_value) -> {
            // set the text for the label to the selected item
            prefTime = ab[new_value.intValue()];
        });

        Image pageThree = new Image("pic3.JPG");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        Button button2 = new Button("Back");
        button2.setTranslateX(20);
        button2.setTranslateY(20);
        button2.setPrefSize(60, 30);
        button2.setOnAction(e -> window.setScene(scene01));

        //System.out.println("\nweekend  " + weekend + "\nHoliday  " + holiday);

        Pane layout = new Pane();
        layout.getChildren().addAll(c, cgEstimate, iqtest, label1, slider, label2, label3, label4, label5, label6, label7, textMath, textPhy, textICT, submit, markResult, markResult2, markResult3, cbIQ, studyTime, button2);

        //button2.setOnAction(e -> window.setScene(scene3));
        scene4 = new Scene(layout, 1300, 650);
        window.setScene(scene4);
    }

    public void LinearText(){

        Image pageThree = new Image("newPage2.png");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        Button button2 = new Button("Back");
        button2.setTranslateX(10);
        button2.setTranslateY(10);
        button2.setPrefSize(60, 30);
        button2.setOnAction(e -> {
            try {
                InputData();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        Button b = new Button("Gaussian Elimination with Partial Pivoting");
        b.setTranslateX(900);
        b.setTranslateY(525);
        b.setStyle("-fx-text-fill: black");
        b.setStyle(" -fx-background-color: powderblue;");
        b.setPrefSize(350, 50);
        b.setOnAction(e -> SubPage());


        Pane layout = new Pane();
        layout.getChildren().addAll(c, button2, b);

        scene18 = new Scene(layout, 1300, 650);
        window.setScene(scene18);
    }

    public void SubPage()
    {
        Image pageThree = new Image("newPage3.png");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        Button button2 = new Button("Back");
        button2.setTranslateX(20);
        button2.setTranslateY(20);
        button2.setPrefSize(60, 30);
        button2.setOnAction(e -> LinearText());

        Pane layout = new Pane();
        layout.getChildren().addAll(c, button2);

        scene20 = new Scene(layout, 1300, 650);
        window.setScene(scene20);
    }

    public void MultiText()
    {
        Image pageThree = new Image("newPage1.png");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        Button button2 = new Button("Back");
        button2.setTranslateX(20);
        button2.setTranslateY(20);
        button2.setPrefSize(60, 30);
        button2.setOnAction(e -> {
            try {
                InputData();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        Pane layout = new Pane();
        layout.getChildren().addAll(c, button2);

        scene19 = new Scene(layout, 1300, 650);
        window.setScene(scene19);
    }

    public void cgShow() throws IOException
    {
        Image pageThree = new Image("pic3.JPG");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        Button createRoutine = new Button("NEXT");
        createRoutine.setTranslateX(1130);
        createRoutine.setTranslateY(280);
        createRoutine.setPrefSize(90, 140);
        createRoutine.setStyle("-fx-base: black;");

        createRoutine.setOnAction(e -> {
            try {
                SemesterLength();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        Button button2 = new Button("Back");
        button2.setTranslateX(20);
        button2.setTranslateY(20);
        button2.setPrefSize(60, 30);
        button2.setOnAction(e -> window.setScene(scene4));

        Label estimation = new Label("Your Estimated CGPA is:");
        estimation.setTranslateX(480);
        estimation.setTranslateY(350);
        estimation.setVisible(false);
        //estimation.setStyle(" -fx-background-color: pink;");
        estimation.setFont(new Font("Algerian", 26));
        estimation.setMinWidth(100);
        estimation.setMinHeight(60);

        Label userI = new Label("Enter Your Expected CGPA: ");
        userI.setFont(new Font("Algerian", 22));
        userI.setStyle("-fx-text-fill: black");
        userI.setStyle(" -fx-background-color: cyan;");
        userI.setTranslateX(480);
        userI.setTranslateY(200);

        TextField text = new TextField();
        text.setTranslateX(850);
        text.setTranslateY(200);

        Button submit = new Button("Submit");
        submit.setTranslateX(650);
        submit.setTranslateY(240);
        submit.setFont(new Font("Ariel", 18));
        submit.setStyle("-fx-text-fill: black");
        submit.setStyle(" -fx-background-color: grey;");

        Label label3 = new Label();

        Button eCG = new Button();
        //eCG.setText(String.valueOf((CGs[0]+CGs[1]+CGs[2])/3));
        DecimalFormat df = new DecimalFormat("#.##");
        eCG.setText(df.format((CGs[0]+CGs[1]+CGs[2])/3));
        FileWrite2(String.valueOf((CGs[0]+CGs[1]+CGs[2])/3));
        eCG.setPrefSize(100, 60);
        eCG.setFont(new Font("Algerian", 22));
        eCG.setStyle("-fx-text-fill: black");
        eCG.setStyle(" -fx-background-color: cyan;");
        eCG.setTranslateX(850);
        eCG.setTranslateY(350);
        eCG.setVisible(false);

        submit.setOnAction(e -> {
            estimation.setVisible(true);
            eCG.setVisible(true);
            double value = Double.parseDouble(text.getText());
            double est = (CGs[0]+CGs[1]+CGs[2])/3;
            if(Math.abs(value-est)<=.2)
            {
                label3.setText("* The Difference According to Chi-Square test\n   is NOT Significant ");
                label3.setTranslateX(450);
                label3.setTranslateY(470);
                label3.setFont(new Font("Bauhaus 93", 26));
            }
            else
            {
                label3.setText("* The Difference According to Chi-Square test\n   IS Significant ");
                label3.setTranslateX(450);
                label3.setTranslateY(470);
                label3.setFont(new Font("Bauhaus 93", 26));
            }

        });

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
        button3.setOnAction(e -> {
            try {
                PageTwo();
            } catch (ParseException | FileNotFoundException parseException) {
                parseException.printStackTrace();
            }
        });

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
            System.out.println(user.getStudyHour());
        });
        scatterChart.getData().addAll(series);

        Pane layout = new Pane();

        LinearRegression obj = new LinearRegression();
        obj.xyMethod(1);
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

    public void SemesterLength() throws IOException
    {
        Pane layout = new Pane();

        Image pageThree = new Image("pic3.JPG");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        Label label1 = new Label("Enter Semester Start date:");
        label1.setFont(new Font("Rockwell Extra Bold", 20));
        label1.setMinWidth(120);
        label1.setMinHeight(70);
        label1.setTranslateX(460);
        label1.setTranslateY(150);

        Label label2 = new Label("Enter Semester End date:");
        label2.setFont(new Font("Rockwell Extra Bold", 20));
        label2.setMinWidth(120);
        label2.setMinHeight(70);
        label2.setTranslateX(460);
        label2.setTranslateY(320);

        Button create = new Button("Create\nRoutine");
        create.setTranslateX(840);
        create.setTranslateY(520);

        DateToInt obj = new DateToInt();

        String st[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        ChoiceBox cbIQ = new ChoiceBox(FXCollections.observableArrayList(st));
        cbIQ.setTranslateX(580);
        cbIQ.setTranslateY(230);
        cbIQ.setPrefSize(100, 30);

        ChoiceBox cbIQ2 = new ChoiceBox(FXCollections.observableArrayList(st));
        cbIQ2.setTranslateX(580);
        cbIQ2.setTranslateY(400);
        cbIQ2.setPrefSize(100, 30);

        String da[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11","12","13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

        ChoiceBox cbDate = new ChoiceBox(FXCollections.observableArrayList(da));
        cbDate.setTranslateX(460);
        cbDate.setTranslateY(230);
        cbDate.setPrefSize(100, 30);

        ChoiceBox cbDate2 = new ChoiceBox(FXCollections.observableArrayList(da));
        cbDate2.setTranslateX(460);
        cbDate2.setTranslateY(400);
        cbDate2.setPrefSize(100, 30);

        String ye[] = {"2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026"};

        ChoiceBox cbYear = new ChoiceBox(FXCollections.observableArrayList(ye));
        cbYear.setTranslateX(700);
        cbYear.setTranslateY(230);
        cbYear.setPrefSize(100, 30);

        ChoiceBox cbYear2 = new ChoiceBox(FXCollections.observableArrayList(ye));
        cbYear2.setTranslateX(700);
        cbYear2.setTranslateY(400);
        cbYear2.setPrefSize(100, 30);

        cbDate.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                // set the text for the label to the selected item
                String x = da[new_value.intValue()];
                start = x + '-';
                System.out.println(start);
            }
        });

        cbDate2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                // set the text for the label to the selected item
                String x = da[new_value.intValue()];
                end = x + '-';
                System.out.println(end);
            }
        });


        cbIQ.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                // set the text for the label to the selected item
                String x = st[new_value.intValue()];
                start += obj.MonthToInt(x);
                System.out.println(start);
            }
        });

        cbIQ2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                // set the text for the label to the selected item
                String x = st[new_value.intValue()];
                end += obj.MonthToInt(x);
                System.out.println(end);
            }
        });

        cbYear.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                // set the text for the label to the selected item
                String x = ye[new_value.intValue()];
                start += '-' + x;
                System.out.println(start);
            }
        });

        cbYear2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                // set the text for the label to the selected item
                String x = ye[new_value.intValue()];
                end += '-' + x;
                System.out.println(end);
                try {
                    DateWrite(end);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


        create.setOnAction(e -> {
            try {
                createCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        layout.getChildren().addAll(c, create, label1, label2, cbIQ, cbDate, cbYear, cbIQ2, cbDate2, cbYear2);
        scene12 = new Scene(layout, 1300, 650);
        window.setScene(scene12);
    }

    public void DateWrite(String value) throws IOException
    {
        File file = new File("src\\EndDate.txt");

        FileWriter writer = new FileWriter(file);
        PrintWriter pw = new PrintWriter(writer);
        pw.println(value);
        pw.close();
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

        Button white = new Button();
        white.setTranslateX(800);
        white.setTranslateY(480);
        white.setPrefSize(2, 2);
        white.setStyle(" -fx-background-color: cyan;");
        Label lwhite = new Label("  Today");
        lwhite.setTranslateX(815);
        lwhite.setTranslateY(480);

        Button red = new Button();
        red.setTranslateX(800);
        red.setTranslateY(520);
        red.setPrefSize(2, 2);
        red.setStyle(" -fx-background-color: red;");
        Label lred = new Label("  Holiday");
        lred.setTranslateX(815);
        lred.setTranslateY(520);

        Button blue = new Button();
        blue.setTranslateX(800);
        blue.setTranslateY(560);
        blue.setPrefSize(2, 2);
        blue.setStyle(" -fx-background-color: yellow;");
        Label lblue = new Label("  Academic Events");
        lblue.setTranslateX(815);
        lblue.setTranslateY(560);

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

        Image pageThree = new Image("calendar.JPG");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        Button button2 = new Button("Back");
        button2.setTranslateX(20);
        button2.setTranslateY(20);
        button2.setPrefSize(60, 30);

        button2.setOnAction(e -> {
            try {
                PageTwo();
            } catch (ParseException | FileNotFoundException parseException) {
                parseException.printStackTrace();
            }
        });

        Pane layout = new Pane();
        layout.getChildren().addAll(c, button2, prev, next, white, red, blue, lblue, lwhite, lred, monthB, sun, mon, tue, wed, thu, fri, sat, year);
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

        //System.out.println(dayT + " " + monthT + " " + yearT);

        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 1);
        ArrayList<Button> buttonList  = new ArrayList<Button>();

        HolidayCheck obj = new HolidayCheck();
        ExamCheck obj2 = new ExamCheck();

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
                    button.setStyle("-fx-base: red;");
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
                else if(obj2.IsExam(s))
                {
                    button.setStyle("-fx-base: yellow;");

                    Label label = new Label(obj2.ExamName());
                    label.setTranslateX(400);
                    label.setTranslateY(250);
                    label.setStyle(" -fx-background-color: cyan;");
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

                else if(dayT==dayOfMonth && monthT==month && yearT==year)
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

                buttonList.add(button);
                button.setTranslateX(satb);
                button.setTranslateY(satby);

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

                if(obj.IsHoliday(s)) {

                    if (dayT == dayOfMonth && monthT == month && yearT == year) {
                        button.setStyle("-fx-base: cyan;");
                        button.setOnAction(e -> {
                            try {
                                ExtraSubject(1);
                            } catch (FileNotFoundException fileNotFoundException) {
                                fileNotFoundException.printStackTrace();
                            }
                        });
                    }

                    else {
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
                        button.setOnAction(e -> {
                            if (!popup.isShowing()) {
                                popup.show(window);
                            }
                        });
                    }
                }

                else if(obj2.IsExam(s))
                {
                    button.setStyle("-fx-base: yellow;");

                    Label label = new Label(obj2.ExamName());
                    label.setTranslateX(400);
                    label.setTranslateY(250);
                    label.setStyle(" -fx-background-color: cyan;");
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

                else if(dayT==dayOfMonth && monthT==month && yearT==year)
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
                {
                    button.setOnAction(e -> {
                        try {
                            AddEvent();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
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
                                ExtraSubject(1);
                            } catch (FileNotFoundException fileNotFoundException) {
                                fileNotFoundException.printStackTrace();
                            }
                        });
                    }
                    else {
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
                        button.setOnAction(e -> {
                            if (!popup.isShowing()) {
                                popup.show(window);
                            }
                        });
                    }
                }

                else if(obj2.IsExam(s))
                {
                    button.setStyle("-fx-base: yellow;");

                    Label label = new Label(obj2.ExamName());
                    label.setTranslateX(400);
                    label.setTranslateY(250);
                    label.setStyle(" -fx-background-color: cyan;");
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

                else if(dayT==dayOfMonth && monthT==month && yearT==year)
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
                {
                    button.setOnAction(e -> {
                        try {
                            AddEvent();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
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
                                ExtraSubject(1);
                            } catch (FileNotFoundException fileNotFoundException) {
                                fileNotFoundException.printStackTrace();
                            }
                        });
                    }
                    else {
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
                        button.setOnAction(e -> {
                            if (!popup.isShowing()) {
                                popup.show(window);
                            }
                        });
                    }
                }

                else if(obj2.IsExam(s))
                {
                    button.setStyle("-fx-base: yellow;");

                    Label label = new Label(obj2.ExamName());
                    label.setTranslateX(400);
                    label.setTranslateY(250);
                    label.setStyle(" -fx-background-color: cyan;");
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

                else if(dayT==dayOfMonth && monthT==month && yearT==year)
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
                {
                    button.setOnAction(e -> {
                        try {
                            AddEvent();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
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
                                ExtraSubject(1);
                            } catch (FileNotFoundException fileNotFoundException) {
                                fileNotFoundException.printStackTrace();
                            }
                        });
                    }

                    else {
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
                        button.setOnAction(e -> {
                            if (!popup.isShowing()) {
                                popup.show(window);
                            }
                        });
                    }
                }

                else if(obj2.IsExam(s))
                {
                    button.setStyle("-fx-base: yellow;");

                    Label label = new Label(obj2.ExamName());
                    label.setTranslateX(400);
                    label.setTranslateY(250);
                    label.setStyle(" -fx-background-color: cyan;");
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

                else if(dayT==dayOfMonth && monthT==month && yearT==year)
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
                {
                    button.setOnAction(e -> {
                        try {
                            AddEvent();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
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

                else if(obj2.IsExam(s))
                {
                    button.setStyle("-fx-base: yellow;");

                    Label label = new Label(obj2.ExamName());
                    label.setTranslateX(400);
                    label.setTranslateY(250);
                    label.setStyle(" -fx-background-color: cyan;");
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

                else if(dayT==dayOfMonth && monthT==month && yearT==year)
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
                {
                    button.setOnAction(e -> {
                        try {
                            AddEvent();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
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
                                ExtraSubject(1);
                            } catch (FileNotFoundException fileNotFoundException) {
                                fileNotFoundException.printStackTrace();
                            }
                        });
                    }
                    else {
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
                        button.setOnAction(e -> {
                            if (!popup.isShowing()) {
                                popup.show(window);
                            }
                        });
                    }
                }

                else if(obj2.IsExam(s))
                {
                    button.setStyle("-fx-base: yellow;");

                    Label label = new Label(obj2.ExamName());
                    label.setTranslateX(400);
                    label.setTranslateY(250);
                    label.setStyle(" -fx-background-color: cyan;");
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

                else if(dayT==dayOfMonth && monthT==month && yearT==year)
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

    public void MakeRoutine(String[] Rsubjects, ArrayList<String> Esub) throws FileNotFoundException, ParseException {

        String prevTime="null", finTime="null";

        Pane layout = new Pane();
        DateToInt ob  = new DateToInt();
        ClockTime ob2 = new ClockTime();

        Image pageThree = new Image("pic3.JPG");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        Button routine = new Button("ROUTINE");
        routine.setTranslateX(620);
        routine.setTranslateY(120);
        routine.setFont(new Font("Ariel", 30));
        routine.setStyle("-fx-text-fill: black");
        routine.setStyle(" -fx-background-color: grey;");

        Button button2 = new Button("Back");
        button2.setTranslateX(20);
        button2.setTranslateY(20);
        button2.setPrefSize(60, 30);
        button2.setOnAction(e -> window.setScene(scene01));



        layout.getChildren().addAll(c, routine, button2);
        TimeSet time = new TimeSet();

        /*for(int j=0;j<3;j++)
            System.out.println(Rsubjects[j]);*/

        ArrayList<Button> buttonList = new ArrayList<Button>();
        int yy=200;
        for(int i=0;i<3;i++)
        {
            int len=0;
            if(Rsubjects[i].equals("null"))
                continue;
            if(Rsubjects[i].equals("Introduction to Structured Programming"))
                len=2;
            if(Rsubjects[i].equals("Discrete Mathematics"))
                len=3;
            if(Rsubjects[i].equals("Calculus and Analytical Geometry"))
                len=4;
            if(Rsubjects[i].equals("Probability and Statistics"))
                len=5;
            if(Rsubjects[i].equals("Sociology"))
                len=6;
            if(Rsubjects[i].equals("Introduction to Software Engineering"))
                len=7;

            double duration = time.TimePeriod(len, (CGs[0]+CGs[1]+CGs[2])/3);
            double day = ob.Days(start, end);
            DecimalFormat df = new DecimalFormat("#.##");

            double dur_day = duration/day;

            if(i==0)
            {
                if(prefTime.equals("Morning"))
                    prevTime = "9:00";
                else if (prefTime.equals("Noon"))
                    prevTime = "14:00";
                else if (prefTime.equals("Afternoon"))
                    prevTime = "16:00";
                else if(prefTime.equals("Evening"))
                    prevTime = "18:30";
                else if(prefTime.equals("Night"))
                    prevTime = "20:30";
                else if(prefTime.equals("Anytime"))
                {
                    String[] arr = new String[] { "10:00", "12:00", "2:00", "4:00", "6:00", "8:00", "14:00", "16:00", "18:00", "20:00"};
                    prevTime = arr[new Random().nextInt(arr.length)];

                }
            }

            finTime = ob2.Clock(prefTime, Double.toString(dur_day), prevTime);

            Button b = new Button("#" + Rsubjects[i] + "\nDuration: " + df.format(dur_day) + "hr" + "      Start: " + prevTime + "    End: " + finTime);
            //System.out.println(t+":"+min);
            prevTime = finTime;


            b.setTranslateX(500);
            b.setTranslateY(yy);
            b.setFont(new Font("Rockwell Extra Bold", 18));
            b.setStyle("-fx-text-fill: black");
            b.setStyle(" -fx-background-color: mediumspringgreen;");
            yy+=60;

            b.setOnAction(e -> FeedbackSlider(Rsubjects, Esub, dur_day));

            buttonList.add(b);

        }

        for(int i = 0; i < Esub.size(); i++) {

            int len = 0;
            if(Esub.get(i).equals("Introduction to Structured Programming"))
                len=2;
            if(Esub.get(i).equals("Discrete Mathematics"))
                len=3;
            if(Esub.get(i).equals("Calculus and Analytical Geometry"))
                len=4;
            if(Esub.get(i).equals("Probability and Statistics"))
                len=5;
            if(Esub.get(i).equals("Sociology"))
                len=6;
            if(Esub.get(i).equals("Introduction to Software Engineering"))
                len=7;

            double duration = time.TimePeriod(len, (CGs[0]+CGs[1]+CGs[2])/3);
            double day = ob.Days(start, end);
            DecimalFormat df = new DecimalFormat("#.##");
            double dur_day = duration/day;

            finTime = ob2.Clock(prefTime, Double.toString(dur_day), prevTime);

            Button b2 = new Button("#"+Esub.get(i)+"\nDuration: "+df.format(dur_day) + "hr" + "     Start:" + prevTime + "   End: " + finTime);

            prevTime = finTime;

            b2.setTranslateX(500);
            b2.setTranslateY(yy);
            b2.setFont(new Font("Rockwell Extra Bold", 18));
            b2.setStyle("-fx-text-fill: black");
            b2.setStyle(" -fx-background-color: mediumspringgreen;");
            yy+=60;

            b2.setOnAction(e -> FeedbackSlider(Rsubjects, Esub, dur_day));

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

        chiSquare obj = new chiSquare();

        File file = new File("src\\classRoutine.txt");
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

        Image pageThree = new Image("pic3.JPG");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        Button button2 = new Button("Back");
        button2.setTranslateX(20);
        button2.setTranslateY(20);
        button2.setPrefSize(60, 30);
        button2.setOnAction(e -> {
            try {
                createCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

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

        HolidayCheck11 obj2 = new HolidayCheck11();

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
                    b.setStyle("-fx-text-fill: black");
                    b.setStyle(" -fx-background-color: green;");
                });

                layout.getChildren().add(b);
            }

            buttonList.forEach(value -> {
                layout.getChildren().add(value);
            });
        });

        b2.setOnAction(e -> {
            try {
                Label l = new Label("Do you want break in between subjects?");
                l.setFont(new Font("Rockwell Extra Bold", 20));
                l.setMinWidth(120);
                l.setMinHeight(70);
                l.setTranslateX(460);
                l.setTranslateY(150);

                Label l2 = new Label("Enter break minutes: ");

                TextField pf = new TextField();
                pf.setTranslateX(600);
                pf.setTranslateY(420);
                pf.setVisible(false);

                Button submit = new Button("submit");
                submit.setTranslateX(680);
                submit.setTranslateY(420);

                Image pageThree2 = new Image("pic3.JPG");
                Canvas c2 = new Canvas(1300,650);
                GraphicsContext gc2 = c2.getGraphicsContext2D();
                gc2.drawImage(pageThree2,0,0);

                Button but1 = new Button();
                but1.setText("YES");
                Button but2 = new Button("NO");
                but1.setTranslateX(550);
                but1.setTranslateY(230);
                but2.setTranslateX(650);
                but2.setTranslateY(230);
                but1.setPrefHeight(30);
                but1.setPrefWidth(80);
                but2.setPrefHeight(30);
                but2.setPrefWidth(80);

                but1.setOnAction(E -> {
                    pf.setVisible(true);
                });

                submit.setOnAction(E -> {
                    try {
                        MakeRoutine(str, Esub);
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }
                });

                Pane layout2 = new Pane();
                layout2.getChildren().addAll(c2, b1, b2, l, l2, pf, submit);

                scene14 = new Scene(layout2, 1300, 650);
                window.setScene(scene14);
                MakeRoutine(str, Esub);
            } catch (FileNotFoundException | ParseException fileNotFoundException) {
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
            } catch (FileNotFoundException | ParseException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        layout.getChildren().addAll(c, label1, b1, b2, done, button2);
        scene11 = new Scene(layout, 1300, 650);
        window.setScene(scene11);
    }

    public void FeedbackSlider(String[] Rsubjects, ArrayList<String> Esub, double dur)
    {
        hour=(int)dur;
        minute = (int) ( 60 * (dur-hour));
        second = 0;

        Image pageThree = new Image("pic3.JPG");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        Button routine = new Button("ROUTINE");
        routine.setTranslateX(620);
        routine.setTranslateY(120);
        routine.setFont(new Font("Ariel", 30));
        routine.setStyle("-fx-text-fill: black");
        routine.setStyle(" -fx-background-color: grey;");

        Pane layout = new Pane();

        final Slider slider = new Slider(0, 100, 0);
        slider.setMaxWidth(200);
        slider.setMaxHeight(100);
        slider.setBlockIncrement(1000);
        slider.setMajorTickUnit(20);
        slider.setMinorTickCount(10);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setTranslateX(510);
        slider.setTranslateY(280);
        slider.setScaleX(2);
        slider.setScaleY(2);

        slider.valueProperty().addListener(
                new ChangeListener<Number>() {

                    public void changed(ObservableValue<? extends Number >
                                                observable, Number oldValue, Number newValue)
                    {
                        double value = slider.getValue();
                        value = value/100;
                        System.out.println(value +"\n");
                    }
                });

        Label l1 = new Label("Your Study Percentage: ");
        l1.setTranslateX(510);
        l1.setTranslateY(230);
        l1.setScaleX(2);
        l1.setScaleY(2);

        Button b = new Button("back");
        b.setTranslateX(20);
        b.setTranslateY(20);


        Label timerL = new Label("Remaining Time: " + String.format("%02d",hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second));
        timerL.setTranslateX(510);
        timerL.setTranslateY(380);
        timerL.setScaleX(2);
        timerL.setScaleY(2);
        Label sub = null;

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                        (EventHandler) event -> {
                            second--;
                            System.out.println("Second: "+ second);
                            if (second < 0) {
                                minute--;
                                second = 59;
                                if(minute<0){
                                    hour--;
                                    minute = 59;
                                }
                            }
                            timerL.setText("Remaining Time: "+ String.format("%02d",hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second));
                            if (minute <= 0 && second <= 0 && hour<=0) {
                                timeline.stop();
                                timeup = 1;
                                sub.setText("Time's Up!");
                                sub.setTextFill(Color.RED);
                                sub.setPrefSize(100, 30);
                                sub.setAlignment(Pos.CENTER);
                                layout.getChildren().add(sub);
                            }
                        }));

        b.setOnAction(e -> {
            try {
                timeline.stop();
                MakeRoutine(Rsubjects, Esub);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        });

        Button start = new Button("Start");
        start.setTranslateX(550);
        start.setTranslateY(420);
        start.setOnAction(e->{
            if(timeup==0) {
                start.setText("Pause");
                timeline.play();
                timeup = 1;
            }
            else
            {
                start.setText("Start");
                timeline.stop();
                timeup=0;
            }
        });

        layout.getChildren().addAll(c, slider, l1, b,timerL, start, routine);

        scene13 = new Scene(layout, 1300, 650);

        window.setScene(scene13);
    }

    public void IQExam()
    {
        minute = 10;

        Image pageThree = new Image("page3bg.png");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        Label l = new Label("Which one is different from others?");
        l.setTranslateX(200);
        l.setTranslateY(192);

        Label l2 = new Label("Correct!!!\n\nYour IQ is 160");
        l2.setTranslateX(300);
        l2.setTranslateY(320);
        l2.setVisible(false);

        Label l3 = new Label("Inorrect!!!\n\nYour IQ is 120");
        l3.setTranslateX(300);
        l3.setTranslateY(320);
        l3.setVisible(false);

        Button b1 = new Button("Cat");
        Button b2 = new Button("Dog");
        Button b3 = new Button("Cow");
        Button b4 = new Button("Chicken");
        b1.setTranslateX(250);
        b1.setTranslateY(220);
        b2.setTranslateX(300);
        b2.setTranslateY(220);
        b3.setTranslateX(350);
        b3.setTranslateY(220);
        b4.setTranslateX(400);
        b4.setTranslateY(220);

        b4.setOnAction(e -> l2.setVisible(true));
        b1.setOnAction(e -> l3.setVisible(true));
        b2.setOnAction(e -> l3.setVisible(true));
        b3.setOnAction(e -> l3.setVisible(true));

        Button back = new Button("Back");
        back.setTranslateX(20);
        back.setTranslateY(20);
        back.setOnAction(e -> {
            try {
                InputData();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });


        Pane layout = new Pane();
        Label timerL = new Label("Remaining Time: " + String.format("%02d", minute) + ":" + String.format("%02d", second));
        timerL.setTranslateX(600);
        timerL.setTranslateY(100);
        timerL.setScaleX(2);
        timerL.setScaleY(2);
        Label sub = null;

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                        (EventHandler) event -> {
                            second--;
                            System.out.println("Second: "+ second);
                            if (second < 0) {
                                minute--;
                                second = 59;
                            }
                            timerL.setText("Remaining Time: "+String.format("%02d", minute) + ":" + String.format("%02d", second));
                            if (minute <= 0 && second <= 0) {
                                timeline.stop();
                                timeup = 1;
                                sub.setText("Time's Up!");
                                sub.setTextFill(Color.RED);
                                sub.setPrefSize(100, 30);
                                sub.setAlignment(Pos.CENTER);
                                layout.getChildren().add(sub);
                            }
                        }));

        Button start = new Button("Start");
        start.setTranslateX(700);
        start.setTranslateY(150);
        start.setOnAction(e->{
            if(timeup==0) {
                start.setText("Pause");
                timeline.play();
                timeup = 1;
            }
            else
            {
                start.setText("Start");
                timeline.stop();
                timeup=0;
            }
        });

        layout.getChildren().addAll(c, l, b1, b2, b3, b4, timerL, l2, l3, back, start);

        scene15 = new Scene(layout, 1300, 650);

        window.setScene(scene15);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
