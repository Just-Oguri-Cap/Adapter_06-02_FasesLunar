module org.example.adapter_fases_lunar {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.adapter_fases_lunar to javafx.fxml;
    exports org.example.adapter_fases_lunar;
    exports org.example.adapter_fases_lunar.service;
    opens org.example.adapter_fases_lunar.service to javafx.fxml;
    exports org.example.adapter_fases_lunar.controller;
    opens org.example.adapter_fases_lunar.controller to javafx.fxml;
}