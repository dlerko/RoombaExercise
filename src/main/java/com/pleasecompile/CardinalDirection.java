package com.pleasecompile;

public enum CardinalDirection {
	N { public Point move(Point currentPosition, Room room) {
		if(room.canMoveUp(currentPosition)) currentPosition.setY(currentPosition.getY() + 1);
		return currentPosition;
	}},
	E { public Point move(Point currentPosition, Room room) {
		if(room.canMoveRight(currentPosition)) currentPosition.setX(currentPosition.getX() + 1);
		return currentPosition;
	}}, 
	S { public Point move(Point currentPosition, Room room) {
		if(room.canMoveDown(currentPosition)) currentPosition.setY(currentPosition.getY() - 1);
		return currentPosition;
	}}, 
	W { public Point move(Point currentPosition, Room room) {
		if(room.canMoveLeft(currentPosition)) currentPosition.setX(currentPosition.getX() - 1);
		return currentPosition;
	}};
	
	public abstract Point move(Point currentPosition, Room room);
}
