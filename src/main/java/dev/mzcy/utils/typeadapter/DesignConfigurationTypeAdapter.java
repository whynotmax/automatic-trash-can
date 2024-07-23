package dev.mzcy.utils.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import dev.mzcy.configuration.design.DesignConfiguration;
import dev.mzcy.configuration.design.background.Background;

import java.io.IOException;

public class DesignConfigurationTypeAdapter extends TypeAdapter<DesignConfiguration> {

    @Override
    public void write(JsonWriter out, DesignConfiguration value) throws IOException {
        out.beginObject();
        out.name("background");
        // Assuming you have a TypeAdapter for Background as well
        new BackgroundTypeAdapter().write(out, value.getBackground());
        out.endObject();
    }

    @Override
    public DesignConfiguration read(JsonReader in) throws IOException {
        DesignConfiguration config = new DesignConfiguration();
        in.beginObject();
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "background":
                    // Assuming you have a TypeAdapter for Background
                    Background background = new BackgroundTypeAdapter().read(in);
                    config.setBackground(background);
                    break;
            }
        }
        in.endObject();
        return config;
    }
}
