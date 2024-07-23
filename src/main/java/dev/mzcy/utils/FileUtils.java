package dev.mzcy.utils;

import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@UtilityClass
public class FileUtils {

    /**
     * Copies a resource file to a specified location and returns its URL.
     *
     * @param fileName The name of the file to be created in the app data folder.
     * @param resourceFilePath The path to the resource file within the resources directory.
     * @return The URL of the copied file.
     * @throws IOException If an I/O error occurs.
     * @since 1.0.0
     * @author GitHub Copilot
     * @see OSUtils#getAppDataFolder()
     */
    public URL copyResourceToFileAndGetURL(String fileName, String resourceFilePath) throws IOException {
        File targetFile = new File(OSUtils.getAppDataFolder() + "/folder-cleaner/fxml/" + fileName);
        if (!targetFile.exists()) {
            targetFile.getParentFile().mkdirs();
            targetFile.createNewFile();
            try (InputStream is = FileUtils.class.getResourceAsStream(resourceFilePath);
                 FileOutputStream fos = new FileOutputStream(targetFile)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }
            }
        }
        return targetFile.toURI().toURL();
    }
}
