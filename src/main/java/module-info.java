module com.universite {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    exports com.universite;
    opens com.universite.controller to javafx.fxml;
    opens com.universite.data to javafx.base;
    opens com.universite to javafx.fxml;
    opens com.universite.controller.ozel to javafx.fxml;
    opens com.universite.controller.devlet to javafx.fxml;
}