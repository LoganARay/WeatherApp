package edu.farmingdale.weatherapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HelloApplication extends Application {
    public static List<Month> months;

    /**
     * The stage and scene is created and set here. Allowing
     * the program to further interact with JavaFx.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        months = new ArrayList<>();
        String[] monthNumbers= {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        String[] monthNames= {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        for (int i = 0; i < 12; i++) {
            InputStream originalCsv = HelloApplication.class
                    .getResourceAsStream("/edu/farmingdale/weatherapp/weather_2023.csv");
            BufferedReader weatherData = new BufferedReader(new InputStreamReader(originalCsv));
            months.add(new Month(monthNames[i], setMonth(weatherData, monthNumbers[i])));
        }
    }

    /**
     This is where all the code is called from, where it all starts,
     the blueprints that can interact with the other classes, methods,
     ect you've created. Only calls launch that will be the environment
     where JavaFx features are used.
     **/
    void main(String[] args) {
        launch();
    }

    public List<Day> setMonth(BufferedReader weatherData, String month){
        List<Day> test = weatherData.lines().skip(1)
                .map(data -> data.split(","))
                .filter(e -> e[0].substring(5, 7).equals(month))
                .map(m -> new Day(m[0].trim(), Double.parseDouble(m[1].trim()), Integer.parseInt(m[2].trim()), Double.parseDouble(m[3].trim())))
                .collect(Collectors.toList());
        System.out.println(test);
        return test;
    }

    public static Day getDay(int month, int day){
        return months.get(month).calenderMonth().get(day);
    }

}