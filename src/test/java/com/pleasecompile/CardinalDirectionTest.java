package com.pleasecompile;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardinalDirectionTest {

	private Room room;
	private Point middleOfRoom;
	
	@Before
	public void setUp() {
		room = new Room(5,5);
		middleOfRoom = new Point(2, 2);
	}
	
	@Test
	public void canMoveN() {
		CardinalDirection.N.move(middleOfRoom, room);
		assertEquals(3, middleOfRoom.getY());
	}
	
	@Test
	public void willSkidWhenMoveN() {
		Point topOfTheRoom = new Point(2, 4);
		CardinalDirection.N.move(topOfTheRoom, room);
		assertEquals(4, topOfTheRoom.getY());
	}
	
	@Test
	public void canMoveE() {
		CardinalDirection.E.move(middleOfRoom, room);
		assertEquals(3, middleOfRoom.getX());
	}
	
	@Test
	public void willSkidWhenMoveE() {
		Point rightOfTheRoom = new Point(4, 2);
		CardinalDirection.E.move(rightOfTheRoom, room);
		assertEquals(4, rightOfTheRoom.getX());
	}
	
	@Test
	public void canMoveS() {
		CardinalDirection.S.move(middleOfRoom, room);
		assertEquals(1, middleOfRoom.getY());
	}
	
	@Test
	public void willSkidWhenMoveS() {
		Point bottomOfTheRoom = new Point(2, 0);
		CardinalDirection.S.move(bottomOfTheRoom, room);
		assertEquals(0, bottomOfTheRoom.getY());
	}
	
	@Test
	public void canMoveW() {
		CardinalDirection.W.move(middleOfRoom, room);
		assertEquals(1, middleOfRoom.getX());
	}
	
	@Test
	public void willSkidWhenMoveW() {
		Point leftOfTheRoom = new Point(0, 2);
		CardinalDirection.W.move(leftOfTheRoom, room);
		assertEquals(0, leftOfTheRoom.getX());
	}
}
