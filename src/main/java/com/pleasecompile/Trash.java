package com.pleasecompile;

public class Trash implements Point2D {

	private int x, y;
	
	public Trash(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Trash with coordinates [" + getX() + ", " + getY() + "].";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + x;
		result = 31 * result + y;
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Trash))
			return false;
		Trash p = (Trash) obj;
		return p.x == x && p.y == y;
	}

}

