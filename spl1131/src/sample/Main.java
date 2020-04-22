package sample;

import javafx.application.Application;
import javafx.application.Platform;
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

public class Main extends Application {

    Stage window;
    Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7;

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

        create.setOnAction(e -> inputData());

        button2.setOnAction(e -> window.setScene(scene2));
        scene3 = new Scene(layout, 1300, 650);
        window.setScene(scene3);
    }

    public void inputData()
    {
        Label label1 = new Label("Enter Study Hour:  ");
        label1.setTranslateX(390);
        label1.setTranslateY(100);

        Slider slider = new Slider(0, 24, 0);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(5);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setTranslateX(550);
        slider.setTranslateY(100);

        Image pageThree = new Image("pic3.PNG");
        Canvas c = new Canvas(1300,650);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.drawImage(pageThree,0,0);

        Button button2 = new Button("Back");
        button2.setTranslateX(20);
        button2.setTranslateY(20);
        button2.setPrefSize(60, 30);


        Pane layout = new Pane();
        layout.getChildren().addAll(c, label1, slider, button2);

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

        NumberAxis yAxis = new NumberAxis(0, 5, 5);
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

        Button eqn = new Button(obj.showEquation());
        eqn.setTranslateX(720);
        eqn.setTranslateY(40);
        eqn.setPrefSize(250, 100);

        Label label1 = new Label("The Equation is: ");
        label1.setTranslateX(720);
        label1.setTranslateY(20);

        layout.getChildren().addAll(scatterChart, label1, eqn);

        scene6 = new Scene(layout, 1300, 650);
        window.setScene(scene6);
    }

    public void lineChart() throws FileNotFoundException {

        File_Operations obj = new File_Operations();
        obj.File_Subjects();

        NumberAxis xAxis = new NumberAxis(0, 100, 3);
        xAxis.setLabel("Marks");

        NumberAxis yAxis = new NumberAxis(0, 5, 5);
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

        Button eqn = new Button(obj2.showEqn());
        eqn.setTranslateX(600);
        eqn.setTranslateY(50);
        eqn.setPrefSize(600, 100);

        Pane layout = new Pane();
        layout.getChildren().addAll(linechart, label1, eqn);

        scene7 = new Scene(layout, 1300, 650);
        window.setScene(scene7);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
