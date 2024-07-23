module automatic.trash.can.main {
    requires com.google.gson;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires static lombok;
    requires org.jetbrains.annotations;
    requires java.xml;

    opens dev.mzcy;
    exports dev.mzcy;

    exports dev.mzcy.jfx.controller to javafx.fxml;
}