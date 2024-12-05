module org.example.a_02_coctails {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires okhttp3;
    requires org.json;

    opens org.example.a_02_coctails to javafx.fxml;
    exports org.example.a_02_coctails;
}
