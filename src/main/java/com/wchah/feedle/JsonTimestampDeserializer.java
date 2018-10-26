package com.wchah.feedle;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class JsonTimestampDeserializer extends JsonDeserializer<Timestamp> {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");


    public void serialize(Timestamp arg0, JsonGenerator arg1, SerializerProvider arg2)
            throws IOException, JsonProcessingException {
        String formattedDate = dateFormat.format(arg0);
        arg1.writeString(formattedDate);

    }

    @Override
    public Timestamp deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return null;
    }
}