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

/// # HelloApplication
///
/// Main application entry point for the 35-Day Weather Dashboard.
/// Loads weather data from CSV files, initializes month and day records,
/// and sets up the primary JavaFX stage and scene layout.
public class HelloApplication extends Application {

    /// Global collection holding parsed weather data models for all 12 months.
    public static List<Month> months;

    /// Initializes the primary JavaFX stage, loads the FXML view layout,
    /// parses annual weather CSV data into structured month and day records,
    /// and executes text block report demonstrations.
    ///
    /// ### Example Usage:
    /// Automatically invoked by the JavaFX runtime framework during launch.
    ///
    /// @param stage the primary window stage for this application
    /// @throws IOException if the FXML layout or weather CSV resource fails to load
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

        System.out.println("Example of TextBlock for a day");
        System.out.println(months.get(0).calenderMonth().get(0).getDaySummary());

        System.out.println("\nExample of TextBlock output for a month");
        System.out.println(months.get(0).getMonthSummary());
    }

    /// Application entry point method launching the JavaFX runtime environment.
    ///
    /// @param args command-line arguments passed to the application
    void main(String[] args) {
        launch();
    }

    /// Parses CSV weather data streams and filters records matching a specific month number,
    /// mapping them into a list of daily weather `Day` records.
    ///
    /// ### Example Usage:
    /// ```java
    /// List<Day> januaryDays = setMonth(bufferedReader, "01");
    /// ```
    ///
    /// @param weatherData the buffered reader containing raw CSV weather file data
    /// @param month the two-digit month string representation (e.g., "01" for January)
    /// @return a list of structured `Day` records for the specified month
    public List<Day> setMonth(BufferedReader weatherData, String month){
        List<Day> test = weatherData.lines().skip(1)
                .map(data -> data.split(","))
                .filter(e -> e[0].substring(5, 7).equals(month))
                .map(m -> new Day(m[0].trim(), Double.parseDouble(m[1].trim()), Integer.parseInt(m[2].trim()), Double.parseDouble(m[3].trim())))
                .collect(Collectors.toList());
        return test;
    }

    /// Retrieves a specific daily weather record for a given month and day index.
    ///
    /// ### Example Usage:
    /// ```java
    /// Day firstDayOfJan = HelloApplication.getDay(0, 0);
    /// ```
    ///
    /// @param month the index of the month (0-11)
    /// @param day the index of the day within the month
    /// @return the corresponding `Day` weather record
    public static Day getDay(int month, int day){
        return months.get(month).calenderMonth().get(day);
    }
}