package edu.farmingdale.weatherapp;
/// Defines environmental analysis contracts for weather data components.
///
/// Implementations (such as monthly or daily records) must provide logic
/// for evaluating average temperature categories and determining precipitation status.
public interface EnvironmentalConditions {

    /// Calculates or categorizes the average temperature status.
    ///
    /// @return a string describing the temperature condition or average value
    public String avgTemp();

    /// Evaluates or counts rainy day occurrences.
    ///
    /// @return a string describing precipitation metrics or status
    public String rainyDay();
}