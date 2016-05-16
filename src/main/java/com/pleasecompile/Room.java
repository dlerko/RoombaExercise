package com.pleasecompile;

public class Room {

	private final int width, height;

	public Room(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	private boolean isWithinRoom(Point currentPosition) {
		
		assert currentPosition != null;
		return currentPosition.getX() >= 0 && currentPosition.getX() < width && currentPosition.getY() >= 0 && currentPosition.getY() < height;
	}
	
	public boolean canMoveUp(Point currentPosition) {
		
		return isWithinRoom(currentPosition) && currentPosition.getY() < height - 1;
	}

	public boolean canMoveDown(Point currentPosition) {

		return isWithinRoom(currentPosition) && currentPosition.getY() > 0;
	}

	public boolean canMoveLeft(Point currentPosition) {

		return isWithinRoom(currentPosition) && currentPosition.getX() > 0;
	}
	
	public boolean canMoveRight(Point currentPosition) {
		
		return isWithinRoom(currentPosition) &&  currentPosition.getX() < width - 1;
	}
}
