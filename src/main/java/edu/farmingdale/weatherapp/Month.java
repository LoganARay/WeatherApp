package edu.farmingdale.weatherapp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/// Represents a calendar month containing daily weather data records.
///
/// Implements `EnvironmentalConditions` interface to provide necessary methods
/// to get data like average temperatures, and rainy day counts.
///
/// @param month the name of the month (e.g., "January")
/// @param calenderMonth the collection of daily weather records (`Day`) for the month
public record Month (String month, List<Day> calenderMonth) implements EnvironmentalConditions {
    /// Calculates and rounds the average temperature for the entire month.
    ///
    /// ### Calculation Details:
    /// - Sums all daily temperatures via stream mapping.
    /// - Divides by the total number of recorded days.
    /// - Rounds the result to two decimal places.
    ///
    /// ### Example Usage:
    /// ```java
    /// Month jan = new Month("January", daysList);
    /// String avg = january.avgTemp();
    /// // Output example: "72.45"
    /// ```
    ///
    /// @return a string of the rounded average temperature
    public String avgTemp() {
        double w = Math.round((calenderMonth.stream()
                .mapToDouble(Day::temperature) //same as .map(d -> d.temperature())
                .sum() / calenderMonth.size()) * 100.0) / 100.0;
        return w + "";
    }

    /// Calculates the number of days in which there is a precipitation level is above 0.0 through the month,
    /// which in this context constitutes as a rainy day.
    ///
    ///### Example Usage:
    /// ```java
    /// String totalRainyDays = jan.rainyDay();
    /// // Output example: "There are 5 rainy days in January"
    /// ```
    ///
    /// @return the number of rainy days and the month those rainy days occur in

    public String rainyDay(){
        int rainyDays =(int) calenderMonth.stream()
                .mapToDouble(Day::precipitation)
                .filter(d -> d>0.0)
                .count();
        return "There are " + rainyDays + " rainy days in " + month;
    }

    /// Filters and returns a list of formatted dates based on a temperature threshold.
    ///
    /// Depending on the `aboveOrBelow` flag, this method searches for dates where
    /// the temperature is either above (`true`) or not above (`false`) the specified value.
    ///
    /// ### Example Usage:
    /// ```java
    /// // Find days with temperatures above 75.0 degrees
    /// List<String> hotDays = january.temperatureThreshold(true, 75.0);
    /// ```
    ///
    /// @param aboveOrBelow `true` for days above the temp submitted, `false` for days below the temp submitted
    /// @param temp the temperature that will b the threshold to compare against the days of the month
    /// @return a list of processed and trimmed date strings matching the criteria
    public List<String> temperatureThreshold(boolean aboveOrBelow, double temp){
        Predicate<Double> threshold = n -> n > temp;
        Function<String, String> splitDate= n -> n.substring(8).trim();
        //Finds days with temperature hotter than given
        if(aboveOrBelow){
            return calenderMonth.stream()
                    .filter(t-> threshold.test(t.temperature()))
                    .map(Day::date)
                    .map(d-> splitDate.apply(d))
                    .collect(Collectors.toList());
        }
        //Finds days with temperature hotter than given
        else{
            return calenderMonth.stream()
                    .filter(t-> !threshold.test(t.temperature()))
                    .map(Day::date)
                    .map(d-> splitDate.apply(d))
                    .collect(Collectors.toList());
        }
    }
}
