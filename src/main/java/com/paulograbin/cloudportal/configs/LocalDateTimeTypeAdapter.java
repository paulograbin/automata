package com.paulograbin.cloudportal.configs;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

public class LocalDateTimeTypeAdapter extends TypeAdapter<OffsetDateTime> {

    private final Logger LOG = LoggerFactory.getLogger(LocalDateTimeTypeAdapter.class);

    @Override
    public void write(final JsonWriter jsonWriter, final OffsetDateTime localDate) throws IOException {
        if (localDate == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.value(localDate.toString());
    }

    @Override
    public OffsetDateTime read(final JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }

        String text = jsonReader.nextString();
        LOG.debug("Read text {}", text);

        return ZonedDateTime.parse(text).toOffsetDateTime();
    }
}