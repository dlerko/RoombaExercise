package com.pleasecompile;

/**
 * AWS Lambda serialiser, outside of the scope of exercise. This can now be replaced with deserialisation
 * of RoomblaRequest, hence this code needs to be deprecated.
 * 
 * @author dmitrilerko
 *
 */
public class RoomblaRequestAWS {
	public RoomblaRequestAWS() {}
	
	private int [] roomSize;
	private int [] coords;
	private int[][] patches;// = new ArrayList<String>();
	private String []instructions;
	
	public int[] getRoomSize() {
		return roomSize;
	}
	
	public void setRoomSize(int[] roomSize) {
		this.roomSize = roomSize;
	}
	
	public int [] getCoords() {
		return coords;
	}
	
	public void setCoords(int [] coords) {
		this.coords = coords;
	}
	
	public int[][] getPatches() {
		return patches;
	}
	
	public void setPatches(int[][] patches) {
		this.patches = patches;
	}
	
	public String[] getInstructions() {
		return instructions;
	}
	
	public void setInstructions(String[] instructions) {
		this.instructions = instructions;
	}
	
	public RoomblaRequestAWS(int[] roomSize, int [] coords, int[][] patches, String[] instructions) {
		super();
		this.roomSize = roomSize;
		this.coords = coords;
		this.patches = patches;
		this.instructions = instructions;
	}
}
