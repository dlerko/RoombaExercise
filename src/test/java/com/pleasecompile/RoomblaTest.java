package com.pleasecompile;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomblaTest {

	@Test
	public void roomblaYieldCorrectResult() {
		RoomblaRequestAWS awsRequest = new RoomblaRequestAWS();
		awsRequest.setCoords(new int [] {1, 2});
		awsRequest.setInstructions(new String[]{"NNESEESWNWW"});
		awsRequest.setPatches(new int [][] {{1,0}, {2,2},{2,3}});
		awsRequest.setRoomSize(new int []{5,5});
		
		Roombla roombla = new Roombla();
		//Poor assert, using to validate interim implementation against sample data
		assertEquals("RoomblaResult [endLocation=Point [x=1, y=3], collectedTrash=1]", roombla.myHandler(awsRequest, null));
	}
}
