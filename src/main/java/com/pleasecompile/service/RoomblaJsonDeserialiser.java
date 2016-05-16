package com.pleasecompile.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.pleasecompile.Point;
import com.pleasecompile.Room;
import com.pleasecompile.Trash;

public class RoomblaJsonDeserialiser extends JsonDeserializer<RoomblaRequest>{

	@Override
	public RoomblaRequest deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		JsonNode node = jp.getCodec().readTree(jp);
		Iterator<JsonNode> it = node.get("roomSize").elements();

		Room room = new Room(it.next().asInt(), it.next().asInt());
		
		it = node.get("coords").elements();
		Point coords = new Point(it.next().asInt(), it.next().asInt());
		
		HashSet<Trash> trashPositions = new HashSet<Trash>();
		
		it = node.get("patches").elements();
		while(it.hasNext()) {
			JsonNode patch = it.next();
			Iterator<JsonNode> patchIt = patch.elements();
			trashPositions.add(new Trash(patchIt.next().asInt(), patchIt.next().asInt()));
		}
		String moves = node.get("instructions").asText();
		RoomblaRequest request = new RoomblaRequest(room, coords, trashPositions, null);
		request.setRobotMoves(request.mapToCardinalDirections(moves));
		
		return request;
	}

}
