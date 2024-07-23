package dev.mzcy;

import com.google.gson.Gson;
import dev.mzcy.configuration.design.DesignConfiguration;
import dev.mzcy.utils.OSUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;

public class TrashCan extends Application {

    public static final Gson GSON = new Gson().newBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    DesignConfiguration designConfiguration;

    @Override
    public void start(Stage primaryStage) throws Exception {
        DesignConfiguration designConfiguration = new DesignConfiguration();
        designConfiguration.load(Paths.get(OSUtils.getAppDataFolder() + "/folder-cleaner/design.json"));
        Parent root = FXMLLoader.load(Paths.get(OSUtils.getAppDataFolder() + "/folder-cleaner/fxml/fxml.fxml").toUri().toURL());
        primaryStage.setTitle("Folder Cleaner");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}