package com.pleasecompile.service;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pleasecompile.Point;

@Document
@JsonSerialize(using = RoomblaResultJsonSerialiser.class)
public class RoomblaResult {

	//Sprint - persistence auto ID
    @Id
    private String id;
	
	private Point endLocation;
	private int collectedTrash;
	
	public RoomblaResult(Point endLocation, int collectedTrash) {
		super();
		this.endLocation = endLocation;
		this.collectedTrash = collectedTrash;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public RoomblaResult() {
		collectedTrash = 0;
	}

	public void addTrash() {
		collectedTrash++;
	}
	
	public Point getEndLocation() {
		return endLocation;
	}
	
	public void setEndLocation(Point endLocation) {
		this.endLocation = endLocation;
	}
	
	public int getCollectedTrash() {
		return collectedTrash;
	}
	
	public void setCollectedTrash(int collectedTrash) {
		this.collectedTrash = collectedTrash;
	}

	//Convenience override, supplemental in debugging & testing, would not push into prod
	@Override
	public String toString() {
		return "RoomblaResult [endLocation=" + endLocation + ", collectedTrash=" + collectedTrash + "]";
	}
	
}
