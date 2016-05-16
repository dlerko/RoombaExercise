package com.pleasecompile;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import com.pleasecompile.service.RoomblaRequest;

public class RoomblaRequestTest {

	@Test
	public void canMapMovesToCardinalDirections() {
		RoomblaRequestAWS awsRequest = new RoomblaRequestAWS();
		awsRequest.setCoords(new int [] {2, 2});
		awsRequest.setInstructions(new String[]{"SWSSENSENWSNWENW"});
		awsRequest.setPatches(new int [][] {{1,2}, {3,4},{4,5}});
		awsRequest.setRoomSize(new int []{6,6});
	
		RoomblaRequest request = new RoomblaRequest(awsRequest);
		LinkedList<CardinalDirection> direcitons = request.getRobotMoves();
		assertEquals(16, direcitons.size());
		assertTrue(direcitons.get(0) == CardinalDirection.S);
		assertTrue(direcitons.get(1) == CardinalDirection.W);
		assertTrue(direcitons.get(4) == CardinalDirection.E);
		assertTrue(direcitons.get(5) == CardinalDirection.N);
		
	}
}
