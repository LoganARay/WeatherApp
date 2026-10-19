# 2026 Weather Dashboard

A modern JavaFX desktop application designed to track, visualize, and analyze weather data across a 35-day calendar grid. This project features dynamic seasonal themes, interactive daily breakdowns, robust input validation, and clean functional programming streams.

---

## 🚀 Key Features

* **Interactive 35-Day Calendar Grid**: Click on any active day card to view detailed metrics, or hover to preview quick summaries.
* **Dynamic Seasonal Backgrounds & Styling**: Automatically updates themes and background imagery based on the selected season (Winter, Spring, Summer, Fall).
* **Robust Input Validation**: Utilizes JavaFX `TextFormatter` to ensure temperature threshold input fields accept strictly valid numeric data.
* **Advanced Data Analysis**: Leverages Java Streams to calculate monthly averages, count rainy days, and filter dates against custom temperature thresholds.
* **Modern Documentation Standards**: Documented extensively using JDK 23+ Markdown Javadoc syntax (`///`) and code snippet blocks.

---

## 🛠️ Tech Stack & Requirements

* **Language**: Java (JDK 23+ recommended for Markdown Javadoc support)
* **Framework**: JavaFX 
* **Build Tool**: Maven / Gradle
* **Architecture**: Model-View-Controller (MVC) utilizing Java Records and FXML layout files.

---

## 📂 Project Structure

```text
src/
└── main/
    ├── java/
    │   └── edu/farmingdale/weatherapp/
    │       ├── HelloApplication.java      # Main entry point initializing application data and stages
    │       ├── HelloController.java       # Primary UI logic, event handlers, and styling controller
    │       ├── Month.java                 # Record managing monthly statistics and threshold filters
    │       ├── Day.java                   # Record representing daily weather attributes
    │       └── EnvironmentalConditions.java # Interface defining core climate analysis contracts
    └── resources/
        └── edu/farmingdale/weatherapp/
            ├── hello-view.fxml            # FXML layout markup structure
            └── (Seasonal Image Assets)    # Winter, Spring, Summer, and Fall background graphics
