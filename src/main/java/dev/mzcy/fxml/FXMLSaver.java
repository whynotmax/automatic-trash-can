package dev.mzcy.fxml;

import java.io.FileWriter;
import java.io.IOException;

public class FXMLSaver {

    public void saveFXMLToFile() {
        String fxmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\n" +
                "<?import javafx.scene.control.Button?>\n" +
                "<?import javafx.scene.layout.AnchorPane?>\n\n" +
                "<AnchorPane xmlns:fx=\"http://javafx.com/fxml\" fx:controller=\"dev.mzcy.MyController\">\n" +
                "    <Button text=\"Click Me\" layoutX=\"200\" layoutY=\"200\" />\n" +
                "</AnchorPane>";

        try (FileWriter fileWriter = new FileWriter("path/to/your/file.fxml")) {
            fileWriter.write(fxmlContent);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception, maybe log it or show an error message to the user
        }
    }
}
