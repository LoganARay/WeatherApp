package edu.farmingdale.weatherapp;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class HelloController {
    @FXML
    private AnchorPane mainpane;

    @FXML
    private VBox vpane;

    @FXML
    private Button jan, feb, mar, apr, may, june, july, aug, sept, oct, nov, dec;

    @FXML private VBox
    cal01, cal02, cal03, cal04, cal05, cal06, cal07, cal08, cal09, cal10,
    cal11, cal12, cal13, cal14, cal15, cal16, cal17, cal18, cal19, cal20,
    cal21, cal22, cal23, cal24, cal25, cal26, cal27, cal28, cal29, cal30,
    cal31, cal32, cal33, cal34, cal35, cal36, cal37, cal38, cal39, cal40,
    cal41, cal42;

    @FXML private Label date01, temp01, hum01, prec01;
    @FXML private Label date02, temp02, hum02, prec02;
    @FXML private Label date03, temp03, hum03, prec03;
    @FXML private Label date04, temp04, hum04, prec04;
    @FXML private Label date05, temp05, hum05, prec05;
    @FXML private Label date06, temp06, hum06, prec06;
    @FXML private Label date07, temp07, hum07, prec07;
    @FXML private Label date08, temp08, hum08, prec08;
    @FXML private Label date09, temp09, hum09, prec09;
    @FXML private Label date10, temp10, hum10, prec10;
    @FXML private Label date11, temp11, hum11, prec11;
    @FXML private Label date12, temp12, hum12, prec12;
    @FXML private Label date13, temp13, hum13, prec13;
    @FXML private Label date14, temp14, hum14, prec14;
    @FXML private Label date15, temp15, hum15, prec15;
    @FXML private Label date16, temp16, hum16, prec16;
    @FXML private Label date17, temp17, hum17, prec17;
    @FXML private Label date18, temp18, hum18, prec18;
    @FXML private Label date19, temp19, hum19, prec19;
    @FXML private Label date20, temp20, hum20, prec20;
    @FXML private Label date21, temp21, hum21, prec21;
    @FXML private Label date22, temp22, hum22, prec22;
    @FXML private Label date23, temp23, hum23, prec23;
    @FXML private Label date24, temp24, hum24, prec24;
    @FXML private Label date25, temp25, hum25, prec25;
    @FXML private Label date26, temp26, hum26, prec26;
    @FXML private Label date27, temp27, hum27, prec27;
    @FXML private Label date28, temp28, hum28, prec28;
    @FXML private Label date29, temp29, hum29, prec29;
    @FXML private Label date30, temp30, hum30, prec30;
    @FXML private Label date31, temp31, hum31, prec31;
    @FXML private Label date32, temp32, hum32, prec32;
    @FXML private Label date33, temp33, hum33, prec33;
    @FXML private Label date34, temp34, hum34, prec34;
    @FXML private Label date35, temp35, hum35, prec35;
    @FXML private Label date36, temp36, hum36, prec36;
    @FXML private Label date37, temp37, hum37, prec37;

    @FXML private Label avgTemp, rainyDays, tempDay;

    @FXML private VBox bottomV;

    @FXML private Button aboveBelow, clear;

    @FXML private TextField typeTemp;

    private ArrayList<VBox> calBoxes;
    private ArrayList<Label> dateLabels;
    private ArrayList<Label> tempLabels;
    private ArrayList<Label> humLabels;
    private ArrayList<Label> precLabels;

    /// Initializes the controller after its root element has been processed.
    ///
    /// Configures initial element disabling, text formatting filters for numeric input,
    /// scene binding listeners, and event handlers for month navigation buttons.
    @FXML
    public void initialize() {
        cal38.setDisable(true);
        cal39.setDisable(true);
        cal40.setDisable(true);
        cal41.setDisable(true);
        cal42.setDisable(true);

        aboveBelow.setOnAction(e-> {
            if(aboveBelow.getText().equals("Above")){
                aboveBelow.setText("Below");
            }
            else{
                aboveBelow.setText("Above");
            }
        });

        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) {
                return change;
            }
            return null;
        };

        // Apply it to the injected FXML text field
        typeTemp.setTextFormatter(new TextFormatter<>(integerFilter));

        calBoxes = new ArrayList<>(List.of(
                cal01, cal02, cal03, cal04, cal05, cal06, cal07, cal08, cal09, cal10,
                cal11, cal12, cal13, cal14, cal15, cal16, cal17, cal18, cal19, cal20,
                cal21, cal22, cal23, cal24, cal25, cal26, cal27, cal28, cal29, cal30,
                cal31, cal32, cal33, cal34, cal35, cal36, cal37
        ));

        dateLabels = new ArrayList<>(List.of(
                date01, date02, date03, date04, date05, date06, date07, date08, date09, date10,
                date11, date12, date13, date14, date15, date16, date17, date18, date19, date20,
                date21, date22, date23, date24, date25, date26, date27, date28, date29, date30,
                date31, date32, date33, date34, date35, date36, date37
        ));

        // Initialize and populate temperature labels (01 to 35)
        tempLabels = new ArrayList<>(List.of(
                temp01, temp02, temp03, temp04, temp05, temp06, temp07, temp08, temp09, temp10,
                temp11, temp12, temp13, temp14, temp15, temp16, temp17, temp18, temp19, temp20,
                temp21, temp22, temp23, temp24, temp25, temp26, temp27, temp28, temp29, temp30,
                temp31, temp32, temp33, temp34, temp35, temp36, temp37
        ));

        // Initialize and populate humidity labels (01 to 35)
        humLabels = new ArrayList<>(List.of(
                hum01, hum02, hum03, hum04, hum05, hum06, hum07, hum08, hum09, hum10,
                hum11, hum12, hum13, hum14, hum15, hum16, hum17, hum18, hum19, hum20,
                hum21, hum22, hum23, hum24, hum25, hum26, hum27, hum28, hum29, hum30,
                hum31, hum32, hum33, hum34, hum35, hum36, hum37
        ));

        // Initialize and populate precipitation labels (01 to 35)
        precLabels = new ArrayList<>(List.of(
                prec01, prec02, prec03, prec04, prec05, prec06, prec07, prec08, prec09, prec10,
                prec11, prec12, prec13, prec14, prec15, prec16, prec17, prec18, prec19, prec20,
                prec21, prec22, prec23, prec24, prec25, prec26, prec27, prec28, prec29, prec30,
                prec31, prec32, prec33, prec34, prec35, prec36, prec37
        ));

        vpane.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                vpane.prefWidthProperty().bind(newScene.widthProperty());
                vpane.prefHeightProperty().bind(newScene.heightProperty());
            }
        });
        String winter="-fx-background-color: rgba(224, 236, 242, 0.8);";
        String spring="-fx-background-color: rgba(0, 255, 127, 0.6);";
        String summer="-fx-background-color: rgba(255, 181, 73, 0.8);";
        String fall="-fx-background-color: rgba(222, 89, 28, 0.6);";

        Function<String, String> splitDate= n -> n.substring(8).trim();
        jan.setOnAction(event -> {
            tempDay.setText("");
            bottomV.setStyle(winter);
            massEnable();
            dateLabels.stream()
                    .forEach(l-> l.setText(""));
            cal01.setDisable(true);
            cal02.setDisable(true);
            cal03.setDisable(true);
            cal04.setDisable(true);
            cal36.setDisable(true);
            cal37.setDisable(true);
            resetMonthAtt();
            avgTemp.setText("AvgTemp: " + HelloApplication.months.get(0).avgTemp()+"F");
            rainyDays.setText(HelloApplication.months.get(0).rainyDay());
            String imageUrl = getClass().getResource("/edu/farmingdale/weatherapp/winter.jpg").toExternalForm();
            vpane.setStyle("-fx-background-image: url('" + imageUrl + "');");

            for(int i=4; i<35; i++){
                int finalI = i;
                int finalDay= i-4;
                dateLabels.get(finalI).setText(splitDate.apply(HelloApplication.getDay(0, finalDay).date()));
                calBoxes.get(i).setOnMouseClicked(e-> {
                    resetMonthAtt();
                    tempLabels.get(finalI).setText("Temp: " + HelloApplication.getDay(0, finalDay).temperature() +"F");
                    humLabels.get(finalI).setText("Humidity: "+HelloApplication.getDay(0, finalDay).humidity() +"");
                    precLabels.get(finalI).setText("Rain: " + HelloApplication.getDay(0, finalDay).precipitation() +"");
                });
                calBoxes.get(i).setOnMouseEntered(e->{
                    tempDay.setText("01/" + (finalDay+1) + "/26 is " + HelloApplication.months.get(0).calenderMonth().get(finalDay).avgTemp());
                });
            }
            clear.setOnAction(i -> {
                if (!typeTemp.getText().equals("") && !typeTemp.getText().equals(null)) {
                    if (aboveBelow.getText().equals("Above")) {
                        System.out.print("Dates above " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(true, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    } else {
                        System.out.print("Dates below " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(false, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    }
                }
            });
        });

        feb.setOnAction(event -> {
            tempDay.setText("");
            bottomV.setStyle(winter);
            massEnable();
            dateLabels.stream()
                    .forEach(l-> l.setText(""));
            resetMonthAtt();
            cal29.setDisable(true);
            cal30.setDisable(true);
            cal31.setDisable(true);
            cal32.setDisable(true);
            cal33.setDisable(true);
            cal34.setDisable(true);
            cal35.setDisable(true);
            cal36.setDisable(true);
            cal37.setDisable(true);
            avgTemp.setText("AvgTemp: " + HelloApplication.months.get(1).avgTemp()+"F");
            rainyDays.setText(HelloApplication.months.get(1).rainyDay());
            String imageUrl = getClass().getResource("/edu/farmingdale/weatherapp/winter.jpg").toExternalForm();
            vpane.setStyle("-fx-background-image: url('" + imageUrl + "');");
            for(int i=0; i<28; i++){
                int finalI = i;
                dateLabels.get(finalI).setText(splitDate.apply(HelloApplication.getDay(1, finalI).date()));
                calBoxes.get(i).setOnMouseClicked(e-> {
                    resetMonthAtt();
                    tempLabels.get(finalI).setText("Temp: " + HelloApplication.getDay(1, finalI).temperature() +"F");
                    humLabels.get(finalI).setText("Humidity: "+HelloApplication.getDay(1, finalI).humidity() +"");
                    precLabels.get(finalI).setText("Rain: " + HelloApplication.getDay(1, finalI).precipitation() +"");
                });
                calBoxes.get(i).setOnMouseEntered(e->{
                    tempDay.setText("02/" + (finalI+1) + "/26 is " + HelloApplication.months.get(1).calenderMonth().get(finalI).avgTemp());
                });
            }
            clear.setOnAction(i -> {
                if (!typeTemp.getText().equals("") && !typeTemp.getText().equals(null)) {
                    if (aboveBelow.getText().equals("Above")) {
                        System.out.print("Dates above " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(true, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    } else {
                        System.out.print("Dates below " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(false, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    }
                }
            });
        });

        mar.setOnAction(event -> {
            tempDay.setText("");
            bottomV.setStyle(spring);
            massEnable();
            dateLabels.stream()
                    .forEach(l-> l.setText(""));
            cal32.setDisable(true);
            cal33.setDisable(true);
            cal34.setDisable(true);
            cal35.setDisable(true);
            cal36.setDisable(true);
            cal37.setDisable(true);
            resetMonthAtt();
            avgTemp.setText("AvgTemp: " + HelloApplication.months.get(2).avgTemp()+"F");
            rainyDays.setText(HelloApplication.months.get(2).rainyDay());
            String imageUrl = getClass().getResource("/edu/farmingdale/weatherapp/spring2.jpg").toExternalForm();
            vpane.setStyle("-fx-background-image: url('" + imageUrl + "');" +
                    "-fx-background-repeat: no-repeat;" +
                    "-fx-background-position: center center;" +
                    "-fx-background-size: cover;" );

            for(int i=0; i<31; i++){
                int finalI = i;
                dateLabels.get(finalI).setText(splitDate.apply(HelloApplication.getDay(2, finalI).date()));
                calBoxes.get(i).setOnMouseClicked(e-> {
                    resetMonthAtt();
                    tempLabels.get(finalI).setText("Temp: " + HelloApplication.getDay(2, finalI).temperature() +"F");
                    humLabels.get(finalI).setText("Humidity: "+HelloApplication.getDay(2, finalI).humidity() +"");
                    precLabels.get(finalI).setText("Rain: " + HelloApplication.getDay(2, finalI).precipitation() +"");
                });
                calBoxes.get(i).setOnMouseEntered(e->{
                    tempDay.setText("03/" + (finalI+1) + "/26 is " + HelloApplication.months.get(2).calenderMonth().get(finalI).avgTemp());
                });
            }
            clear.setOnAction(i -> {
                if (!typeTemp.getText().equals("") && !typeTemp.getText().equals(null)) {
                    if (aboveBelow.getText().equals("Above")) {
                        System.out.print("Dates above " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(true, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    } else {
                        System.out.print("Dates below " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(false, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    }
                }
            });
        });

        apr.setOnAction(event -> {
            tempDay.setText("");
            bottomV.setStyle(spring);
            massEnable();
            dateLabels.stream()
                    .forEach(l-> l.setText(""));
            cal01.setDisable(true);
            cal02.setDisable(true);
            cal03.setDisable(true);
            cal34.setDisable(true);
            cal35.setDisable(true);
            cal36.setDisable(true);
            cal37.setDisable(true);
            resetMonthAtt();
            avgTemp.setText("AvgTemp: " + HelloApplication.months.get(3).avgTemp()+"F");
            rainyDays.setText(HelloApplication.months.get(3).rainyDay());
            String imageUrl = getClass().getResource("/edu/farmingdale/weatherapp/spring2.jpg").toExternalForm();
            vpane.setStyle("-fx-background-image: url('" + imageUrl + "');" +
                    "-fx-background-repeat: no-repeat;" +
                    "-fx-background-position: center center;" +
                    "-fx-background-size: cover;" );

            for(int i=3; i<33; i++){
                int finalI = i;
                int finalDay= i-3;
                dateLabels.get(finalI).setText(splitDate.apply(HelloApplication.getDay(3, finalDay).date()));
                calBoxes.get(i).setOnMouseClicked(e-> {
                    resetMonthAtt();
                    tempLabels.get(finalI).setText("Temp: " + HelloApplication.getDay(3, finalDay).temperature() +"F");
                    humLabels.get(finalI).setText("Humidity: "+HelloApplication.getDay(3, finalDay).humidity() +"");
                    precLabels.get(finalI).setText("Rain: " + HelloApplication.getDay(3, finalDay).precipitation() +"");
                });
                calBoxes.get(i).setOnMouseEntered(e->{
                    tempDay.setText("04/" + (finalDay+1) + "/26 is " + HelloApplication.months.get(3).calenderMonth().get(finalDay).avgTemp());
                });
            }
            clear.setOnAction(i -> {
                if (!typeTemp.getText().equals("") && !typeTemp.getText().equals(null)) {
                    if (aboveBelow.getText().equals("Above")) {
                        System.out.print("Dates above " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(true, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    } else {
                        System.out.print("Dates below " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(false, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    }
                }
            });
        });

        may.setOnAction(event -> {
            tempDay.setText("");
            bottomV.setStyle(spring);
            massEnable();
            dateLabels.stream()
                    .forEach(l-> l.setText(""));
            cal01.setDisable(true);
            cal02.setDisable(true);
            cal03.setDisable(true);
            cal04.setDisable(true);
            cal05.setDisable(true);
            cal37.setDisable(true);
            resetMonthAtt();
            avgTemp.setText("AvgTemp: " + HelloApplication.months.get(4).avgTemp()+"F");
            rainyDays.setText(HelloApplication.months.get(4).rainyDay());
            String imageUrl = getClass().getResource("/edu/farmingdale/weatherapp/spring2.jpg").toExternalForm();
            vpane.setStyle("-fx-background-image: url('" + imageUrl + "');" +
                    "-fx-background-repeat: no-repeat;" +
                    "-fx-background-position: center center;" +
            "-fx-background-size: cover;" );

            for(int i=5; i<36; i++){
                int finalI = i;
                int finalDay= i-5;
                dateLabels.get(finalI).setText(splitDate.apply(HelloApplication.getDay(4, finalDay).date()));
                calBoxes.get(i).setOnMouseClicked(e-> {
                    resetMonthAtt();
                    tempLabels.get(finalI).setText("Temp: " + HelloApplication.getDay(4, finalDay).temperature() +"F");
                    humLabels.get(finalI).setText("Humidity: "+HelloApplication.getDay(4, finalDay).humidity() +"");
                    precLabels.get(finalI).setText("Rain: " + HelloApplication.getDay(4, finalDay).precipitation() +"");
                });
                calBoxes.get(i).setOnMouseEntered(e->{
                    tempDay.setText("05/" + (finalDay+1) + "/26 is " + HelloApplication.months.get(4).calenderMonth().get(finalDay).avgTemp());
                });
            }
            clear.setOnAction(i -> {
                if (!typeTemp.getText().equals("") && !typeTemp.getText().equals(null)) {
                    if (aboveBelow.getText().equals("Above")) {
                        System.out.print("Dates above " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(true, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    } else {
                        System.out.print("Dates below " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(false, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    }
                }
            });
        });

        june.setOnAction(event -> {
            tempDay.setText("");
            bottomV.setStyle(summer);
            massEnable();
            dateLabels.stream()
                    .forEach(l-> l.setText(""));
            cal01.setDisable(true);
            cal32.setDisable(true);
            cal33.setDisable(true);
            cal34.setDisable(true);
            cal35.setDisable(true);
            cal36.setDisable(true);
            cal37.setDisable(true);
            resetMonthAtt();
            avgTemp.setText("AvgTemp: " + HelloApplication.months.get(5).avgTemp()+"F");
            rainyDays.setText(HelloApplication.months.get(5).rainyDay());
            String imageUrl = getClass().getResource("/edu/farmingdale/weatherapp/summer2.jpg").toExternalForm();
            vpane.setStyle("-fx-background-image: url('" + imageUrl + "');"  +
                    "-fx-background-repeat: no-repeat;" +
                    "-fx-background-position: center center;" +
                    "-fx-background-size: cover;" );

            for(int i=1; i<31; i++){
                int finalI = i;
                int finalDay= i-1;
                dateLabels.get(finalI).setText(splitDate.apply(HelloApplication.getDay(5, finalDay).date()));
                calBoxes.get(i).setOnMouseClicked(e-> {
                    resetMonthAtt();
                    tempLabels.get(finalI).setText("Temp: " + HelloApplication.getDay(5, finalDay).temperature() +"F");
                    humLabels.get(finalI).setText("Humidity: "+HelloApplication.getDay(5, finalDay).humidity() +"");
                    precLabels.get(finalI).setText("Rain: " + HelloApplication.getDay(5, finalDay).precipitation() +"");
                });
                calBoxes.get(i).setOnMouseEntered(e->{
                    tempDay.setText("06/" + (finalDay+1) + "/26 is " + HelloApplication.months.get(5).calenderMonth().get(finalDay).avgTemp());
                });
            }
            clear.setOnAction(i -> {
                if (!typeTemp.getText().equals("") && !typeTemp.getText().equals(null)) {
                    if (aboveBelow.getText().equals("Above")) {
                        System.out.print("Dates above " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(true, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    } else {
                        System.out.print("Dates below " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(false, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    }
                }
            });
        });

        july.setOnAction(event -> {
            tempDay.setText("");
            bottomV.setStyle(summer);
            massEnable();
            dateLabels.stream()
                    .forEach(l-> l.setText(""));
            cal01.setDisable(true);
            cal02.setDisable(true);
            cal03.setDisable(true);
            cal35.setDisable(true);
            cal36.setDisable(true);
            cal37.setDisable(true);
            resetMonthAtt();
            avgTemp.setText("AvgTemp: " + HelloApplication.months.get(6).avgTemp()+"F");
            rainyDays.setText(HelloApplication.months.get(6).rainyDay());
            String imageUrl = getClass().getResource("/edu/farmingdale/weatherapp/summer2.jpg").toExternalForm();
            vpane.setStyle("-fx-background-image: url('" + imageUrl + "');"  +
                    "-fx-background-repeat: no-repeat;" +
                    "-fx-background-position: center center;" +
                    "-fx-background-size: cover;" );
            for(int i=3; i<34; i++){
                int finalI = i;
                int finalDay= i-3;
                dateLabels.get(finalI).setText(splitDate.apply(HelloApplication.getDay(6, finalDay).date()));
                calBoxes.get(i).setOnMouseClicked(e-> {
                    resetMonthAtt();
                    tempLabels.get(finalI).setText("Temp: " + HelloApplication.getDay(6, finalDay).temperature() +"F");
                    humLabels.get(finalI).setText("Humidity: "+HelloApplication.getDay(6, finalDay).humidity() +"");
                    precLabels.get(finalI).setText("Rain: " + HelloApplication.getDay(6, finalDay).precipitation() +"");
                });
                calBoxes.get(i).setOnMouseEntered(e->{
                    tempDay.setText("07/" + (finalDay+1) + "/26 is " + HelloApplication.months.get(6).calenderMonth().get(finalDay).avgTemp());
                });
            }
            clear.setOnAction(i -> {
                if (!typeTemp.getText().equals("") && !typeTemp.getText().equals(null)) {
                    if (aboveBelow.getText().equals("Above")) {
                        System.out.print("Dates above " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(true, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    } else {
                        System.out.print("Dates below " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(false, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    }
                }
            });
        });

        aug.setOnAction(event -> {
            tempDay.setText("");
            bottomV.setStyle(summer);
            massEnable();
            dateLabels.stream()
                    .forEach(l-> l.setText(""));
            cal01.setDisable(true);
            cal02.setDisable(true);
            cal03.setDisable(true);
            cal04.setDisable(true);
            cal05.setDisable(true);
            cal06.setDisable(true);
            resetMonthAtt();
            avgTemp.setText("AvgTemp: " + HelloApplication.months.get(7).avgTemp()+"F");
            rainyDays.setText(HelloApplication.months.get(7).rainyDay());
            String imageUrl = getClass().getResource("/edu/farmingdale/weatherapp/summer2.jpg").toExternalForm();
            vpane.setStyle("-fx-background-image: url('" + imageUrl + "');"  +
                    "-fx-background-repeat: no-repeat;" +
                    "-fx-background-position: center center;" +
                    "-fx-background-size: cover;" );

            for(int i=6; i<37; i++){
                int finalI = i;
                int finalDay= i-6;
                dateLabels.get(finalI).setText(splitDate.apply(HelloApplication.getDay(7, finalDay).date()));
                calBoxes.get(i).setOnMouseClicked(e-> {
                    resetMonthAtt();
                    tempLabels.get(finalI).setText("Temp: " + HelloApplication.getDay(7, finalDay).temperature() +"F");
                    humLabels.get(finalI).setText("Humidity: "+HelloApplication.getDay(7, finalDay).humidity() +"");
                    precLabels.get(finalI).setText("Rain: " + HelloApplication.getDay(7, finalDay).precipitation() +"");
                });
                calBoxes.get(i).setOnMouseEntered(e->{
                    tempDay.setText("08/" + (finalDay+1) + "/26 is " + HelloApplication.months.get(7).calenderMonth().get(finalDay).avgTemp());
                });
            }
            clear.setOnAction(i -> {
                if (!typeTemp.getText().equals("") && !typeTemp.getText().equals(null)) {
                    if (aboveBelow.getText().equals("Above")) {
                        System.out.print("Dates above " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(true, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    } else {
                        System.out.print("Dates below " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(false, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    }
                }
            });
        });

        sept.setOnAction(event -> {
            tempDay.setText("");
            bottomV.setStyle(fall);
            massEnable();
            dateLabels.stream()
                    .forEach(l-> l.setText(""));
            cal01.setDisable(true);
            cal02.setDisable(true);
            cal33.setDisable(true);
            cal34.setDisable(true);
            cal35.setDisable(true);
            cal36.setDisable(true);
            cal37.setDisable(true);
            resetMonthAtt();
            avgTemp.setText("AvgTemp: " + HelloApplication.months.get(8).avgTemp()+"F");
            rainyDays.setText(HelloApplication.months.get(8).rainyDay());
            String imageUrl = getClass().getResource("/edu/farmingdale/weatherapp/fall.jpeg").toExternalForm();
            vpane.setStyle("-fx-background-image: url('" + imageUrl + "');");

            for(int i=2; i<32; i++){
                int finalI = i;
                int finalDay= i-2;
                dateLabels.get(finalI).setText(splitDate.apply(HelloApplication.getDay(8, finalDay).date()));
                calBoxes.get(i).setOnMouseClicked(e-> {
                    resetMonthAtt();
                    tempLabels.get(finalI).setText("Temp: " + HelloApplication.getDay(8, finalDay).temperature() +"F");
                    humLabels.get(finalI).setText("Humidity: "+HelloApplication.getDay(8, finalDay).humidity() +"");
                    precLabels.get(finalI).setText("Rain: " + HelloApplication.getDay(8, finalDay).precipitation() +"");
                });
                calBoxes.get(i).setOnMouseEntered(e->{
                    tempDay.setText("09/" + (finalDay+1) + "/26 is " + HelloApplication.months.get(8).calenderMonth().get(finalDay).avgTemp());
                });
            }
            clear.setOnAction(i -> {
                if (!typeTemp.getText().equals("") && !typeTemp.getText().equals(null)) {
                    if (aboveBelow.getText().equals("Above")) {
                        System.out.print("Dates above " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(true, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    } else {
                        System.out.print("Dates below " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(false, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    }
                }
            });
        });

        oct.setOnAction(event -> {
            tempDay.setText("");
            bottomV.setStyle(fall);
            massEnable();
            dateLabels.stream()
                    .forEach(l-> l.setText(""));
            cal01.setDisable(true);
            cal02.setDisable(true);
            cal03.setDisable(true);
            cal04.setDisable(true);
            cal36.setDisable(true);
            cal37.setDisable(true);

            resetMonthAtt();
            avgTemp.setText("AvgTemp: " + HelloApplication.months.get(9).avgTemp() +"F");
            rainyDays.setText(HelloApplication.months.get(9).rainyDay());
            String imageUrl = getClass().getResource("/edu/farmingdale/weatherapp/fall.jpeg").toExternalForm();
            vpane.setStyle("-fx-background-image: url('" + imageUrl + "');");

            for(int i=4; i<35; i++){
                int finalI = i;
                int finalDay= i-4;
                dateLabels.get(finalI).setText(splitDate.apply(HelloApplication.getDay(9, finalDay).date()));
                calBoxes.get(i).setOnMouseClicked(e-> {
                    resetMonthAtt();
                    tempLabels.get(finalI).setText("Temp: " + HelloApplication.getDay(9, finalDay).temperature() +"F");
                    humLabels.get(finalI).setText("Humidity: "+HelloApplication.getDay(9, finalDay).humidity() +"");
                    precLabels.get(finalI).setText("Rain: " + HelloApplication.getDay(9, finalDay).precipitation() +"");
                });
                calBoxes.get(i).setOnMouseEntered(e->{
                    tempDay.setText("10/" + (finalDay+1) + "/26 is " + HelloApplication.months.get(9).calenderMonth().get(finalDay).avgTemp());
                });
            }
            clear.setOnAction(i -> {
                if (!typeTemp.getText().equals("") && !typeTemp.getText().equals(null)) {
                    if (aboveBelow.getText().equals("Above")) {
                        System.out.print("Dates above " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(true, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    } else {
                        System.out.print("Dates below " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(false, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    }
                }
            });
        });

        nov.setOnAction(event -> {
            tempDay.setText("");
            bottomV.setStyle(fall);
            massEnable();
            dateLabels.stream()
                    .forEach(l-> l.setText(""));
            cal31.setDisable(true);
            cal32.setDisable(true);
            cal33.setDisable(true);
            cal34.setDisable(true);
            cal35.setDisable(true);
            cal36.setDisable(true);
            cal37.setDisable(true);
            resetMonthAtt();
            avgTemp.setText("AvgTemp: " + HelloApplication.months.get(10).avgTemp()+"F");
            rainyDays.setText(HelloApplication.months.get(10).rainyDay());
            String imageUrl = getClass().getResource("/edu/farmingdale/weatherapp/fall.jpeg").toExternalForm();
            vpane.setStyle("-fx-background-image: url('" + imageUrl + "');");

            for(int i=0; i<30; i++){
                int finalI = i;
                dateLabels.get(finalI).setText(splitDate.apply(HelloApplication.getDay(10, finalI).date()));
                calBoxes.get(i).setOnMouseClicked(e-> {
                    resetMonthAtt();
                    tempLabels.get(finalI).setText("Temp: " + HelloApplication.getDay(10, finalI).temperature() +"F");
                    humLabels.get(finalI).setText("Humidity: "+HelloApplication.getDay(10, finalI).humidity() +"");
                    precLabels.get(finalI).setText("Rain: " + HelloApplication.getDay(10, finalI).precipitation() +"");
                });
                calBoxes.get(i).setOnMouseEntered(e->{
                    tempDay.setText("11/" + (finalI+1) + "/26 is " + HelloApplication.months.get(10).calenderMonth().get(finalI).avgTemp());
                });
            }
            clear.setOnAction(i -> {
                if (!typeTemp.getText().equals("") && !typeTemp.getText().equals(null)) {
                    if (aboveBelow.getText().equals("Above")) {
                        System.out.print("Dates above " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(true, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    } else {
                        System.out.print("Dates below " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(false, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    }
                }
            });
        });

        dec.setOnAction(event -> {
            tempDay.setText("");
            bottomV.setStyle(winter);
            massEnable();
            dateLabels.stream()
                    .forEach(l-> l.setText(""));
            cal01.setDisable(true);
            cal02.setDisable(true);
            cal34.setDisable(true);
            cal35.setDisable(true);
            cal36.setDisable(true);
            cal37.setDisable(true);
            resetMonthAtt();
            avgTemp.setText("AvgTemp: " + HelloApplication.months.get(11).avgTemp()+"F");
            rainyDays.setText(HelloApplication.months.get(11).rainyDay());
            String imageUrl = getClass().getResource("/edu/farmingdale/weatherapp/winter.jpg").toExternalForm();
            vpane.setStyle("-fx-background-image: url('" + imageUrl + "');");

            for(int i=2; i<33; i++){
                int finalI = i;
                int finalDay= i-2;
                dateLabels.get(finalI).setText(splitDate.apply(HelloApplication.getDay(11, finalDay).date()));
                calBoxes.get(i).setOnMouseClicked(e-> {
                    resetMonthAtt();
                    tempLabels.get(finalI).setText("Temp: " + HelloApplication.getDay(11, finalDay).temperature() +"F");
                    humLabels.get(finalI).setText("Humidity: "+HelloApplication.getDay(11, finalDay).humidity() +"");
                    precLabels.get(finalI).setText("Rain: " + HelloApplication.getDay(11, finalDay).precipitation() +"");
                });
                calBoxes.get(i).setOnMouseEntered(e->{
                    tempDay.setText("12/" + (finalDay+1) + "/26 is " + HelloApplication.months.get(11).calenderMonth().get(finalDay).avgTemp());
                });
            }
            clear.setOnAction(i -> {
                if (!typeTemp.getText().equals("") && !typeTemp.getText().equals(null)) {
                    if (aboveBelow.getText().equals("Above")) {
                        System.out.print("Dates above " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(true, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    } else {
                        System.out.print("Dates below " + typeTemp.getText() + "F: ");
                        List<String> days = HelloApplication.months.get(0).temperatureThreshold(false, Integer.parseInt(typeTemp.getText()) +0.0);
                        days.stream().forEach(e -> {
                            System.out.print(Integer.parseInt(e) + " ");
                        });
                        System.out.println();
                    }
                }
            });
        });
    }

    public void resetMonthAtt(){
        tempLabels.stream()
                .forEach(l-> l.setText(""));
        humLabels.stream()
                .forEach(l-> l.setText(""));
        precLabels.stream()
                .forEach(l-> l.setText(""));
    }

    public void massEnable(){
        calBoxes.stream().forEach( c-> c.setDisable(false));
    }
}