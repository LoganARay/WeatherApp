module edu.farmingdale.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens edu.farmingdale.weatherapp to javafx.fxml;
    exports edu.farmingdale.weatherapp;
}