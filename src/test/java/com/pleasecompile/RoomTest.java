package com.pleasecompile;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RoomTest {

	private Room room;
	private Point middleOfRoom;
	private Point notInTheRoom;
	
	@Before
	public void setUp() {
		room = new Room(5, 5);
		middleOfRoom = new Point(2, 2);
		notInTheRoom = new Point(Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	
	@Test
	public void canCreate() {
		assertNotNull(room);
	}
	
	@Test
	public void canMoveUp() {
		assertTrue(room.canMoveUp(middleOfRoom));
	}
	
	@Test
	public void canNotMoveUp() {
		Point topOfTheRoom = new Point(2,4);
		assertFalse(room.canMoveUp(topOfTheRoom));
	}
	
	@Test
	public void pointOutsideOfTheRoom() {
		
		assertFalse(room.canMoveUp(notInTheRoom));
	}
	
	@Test
	public void canMoveDown() {
		
		assertTrue(room.canMoveDown(middleOfRoom));
	}
	
	@Test
	public void canNotMoveDown() {
		Point bottomOfTheRoof = new Point(2, 0);
		assertFalse(room.canMoveDown(bottomOfTheRoof));
	}
	
	@Test
	public void canMoveLeft() {
		assertTrue(room.canMoveLeft(middleOfRoom));
	}
	
	@Test
	public void canNotMoveLeft() {
		Point leftOfTheRoom = new Point(0, 2);
		assertFalse(room.canMoveLeft(leftOfTheRoom));
	}
	
	@Test
	public void canMoveRight() {
		assertTrue(room.canMoveRight(middleOfRoom));
	}
	
	@Test
	public void canNotMoveRight() {
		Point rightOfTheRoom = new Point(4, 2);
		assertFalse(room.canMoveRight(rightOfTheRoom));
	}
	
	@Test
	public void canMoveToTheWall() {
		Point oneCellAwayFromRightWall = new Point(3, 2);
		assertTrue(room.canMoveRight(oneCellAwayFromRightWall));
	}
}
