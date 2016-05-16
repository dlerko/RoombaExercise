package com.pleasecompile.service;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RoomblaJsonDeserialiserTest {

	@Test
	public void canDeserialiseRoomblaRequest() throws JsonParseException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		JsonParser jsonParser = mapper.getFactory().createJsonParser("{\"roomSize\":[5,5],\"coords\":[1,2],\"patches\":[[1,0],[2,2],[2,3]],\"instructions\":\"NNESEESWNWW\"}");
		RoomblaRequest request = mapper.readValue(jsonParser, RoomblaRequest.class);
		
		assertEquals(5, request.getRoom().getWidth());
		assertEquals(5, request.getRoom().getHeight());
		assertEquals(1, request.getStartingPosition().getX());
		assertEquals(2, request.getStartingPosition().getY());
		assertEquals(3, request.getTrashPositions().size());
		assertEquals(11, request.getRobotMoves().size());
	}
}
