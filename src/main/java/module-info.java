module org.example.adapter_fases_lunar {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.adapter_fases_lunar to javafx.fxml;
    exports org.example.adapter_fases_lunar;
}