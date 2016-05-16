package com.pleasecompile.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.pleasecompile.Trash;

public class RoomblaJsonSerialiser extends JsonSerializer<RoomblaRequest>{

	@Override
	public void serialize(RoomblaRequest roombla, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {

        gen.writeStartObject();
        gen.writeArrayFieldStart("roomSize");
        gen.writeNumber(roombla.getRoom().getWidth());
        gen.writeNumber(roombla.getRoom().getHeight());
        gen.writeEndArray();
        gen.writeArrayFieldStart("coords");
        gen.writeNumber(roombla.getStartingPosition().getX());
        gen.writeNumber(roombla.getStartingPosition().getY());
        gen.writeEndArray();
        gen.writeArrayFieldStart("patches");
        for(Trash trash : roombla.getTrashPositions()) {
            gen.writeStartArray();
            gen.writeNumber(trash.getX());
            gen.writeNumber(trash.getY());
            gen.writeEndArray();
        }
        gen.writeEndArray();
        gen.writeStringField("instructions", roombla.getRobotMovesAsString());
        gen.writeEndObject();
	}

}


