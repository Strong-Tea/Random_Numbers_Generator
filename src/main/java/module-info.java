module com.bsuir.lemairemethod {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.bsuir.controller to javafx.fxml;
    opens com.bsuir.distribution to javafx.fxml;

    exports com.bsuir.controller;
    exports com.bsuir.distribution;
    exports com.bsuir.algorithm;
    opens com.bsuir.algorithm to javafx.fxml;
}