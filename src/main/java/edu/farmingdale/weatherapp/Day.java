package edu.farmingdale.weatherapp;

/// Represents a daily weather record containing environmental data.
///
/// Implements `EnvironmentalConditions` interface to categorize temperatures  into Cold, Warm, or Hot
/// and determine precipitation status for a specific date.
///
/// @param date the calendar date of the reading (e.g., "2026-01-01")
/// @param temperature the recorded temperature in Fahrenheit
/// @param humidity the recorded humidity percentage
/// @param precipitation the recorded precipitation amount in inches
public record Day(String date, double temperature, int humidity, double precipitation) implements EnvironmentalConditions {

    /// Categorizes the day's temperature into a descriptive string label.
    ///
    /// Temperature Ranges:
    /// - **Cold**: Below 60F
    /// - **Warm**: 60°F to 84F
    /// - **Hot**: 85F and above
    ///
    /// ### Example Usage:
    /// ```java
    /// Day sampleDay = new Day("2026-07-04", 88.5, 45, 0.0);
    /// String category = sampleDay.avgTemp(); // returns "Hot"
    /// ```
    ///
    /// @return a descriptive category string ("Cold", "Warm", or "Hot")
    public String avgTemp(){
        return switch ((int)temperature) {
            case Integer t when t < 60 -> "Cold";
            case Integer t when t >= 60 && t < 85 -> "Warm";
            default -> "Hot";
        };
    }

    /// Evaluates whether the day experienced precipitation.
    ///
    /// A day is classified as a rainy day if the precipitation value is greater than `0.0`.
    ///
    /// ### Example Usage:
    /// ```java
    /// String status = sampleDay.rainyDay(); // returns "Rainy day!" or "No rain today!"
    /// ```
    ///
    /// @return "Rainy day!" if precipitation > 0.0, otherwise "No rain today!"
    public String rainyDay(){
        if(precipitation > 0.0) { return "Rainy day!"; }
        return "No rain today!";
    }

    /// Outputs stats for this day like if it's a rainy day and the temperature that day
    ///
    /// ### Example Usage:
    /// ```java
    /// String status = sampleDay.getDaySummary();
    /// ```
    ///
    /// @return multi-lined formated string to report attributes about the day
    public String getDaySummary() {
        return """
           ==================================
           DAILY WEATHER REPORT: %s
           ----------------------------------
           Average Temperature: %s
           Rainy Days Status: %s
           ==================================
           """.formatted(date, avgTemp(), rainyDay());
    }
}