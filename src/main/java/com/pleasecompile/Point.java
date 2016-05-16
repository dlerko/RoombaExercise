package com.pleasecompile;

public class Point implements Point2D {

	private int x, y;

	public void setX(int x) {
		
		this.x = x;
	}

	public void setY(int y) {
		
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Point(int [] input) {
		super();

		this.x = input[0];
		this.y = input[1];
	}

	public Point(int x, int y) {
		super();
		
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}
