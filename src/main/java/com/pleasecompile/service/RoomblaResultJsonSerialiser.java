package com.pleasecompile.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class RoomblaResultJsonSerialiser extends JsonSerializer<RoomblaResult>{

	@Override
	public void serialize(RoomblaResult result, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {

		gen.writeStartObject();
		gen.writeArrayFieldStart("coords");
		gen.writeNumber(result.getEndLocation().getX());
		gen.writeNumber(result.getEndLocation().getY());
		gen.writeEndArray();
		gen.writeNumberField("patches", result.getCollectedTrash());
		gen.writeEndObject();
	}

}
