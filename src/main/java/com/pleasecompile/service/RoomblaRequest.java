package com.pleasecompile.service;

import java.util.HashSet;
import java.util.LinkedList;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pleasecompile.CardinalDirection;
import com.pleasecompile.Point;
import com.pleasecompile.Room;
import com.pleasecompile.RoomblaRequestAWS;
import com.pleasecompile.Trash;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonSerialize(using = RoomblaJsonSerialiser.class)
@JsonDeserialize(using = RoomblaJsonDeserialiser.class)
@Document
public class RoomblaRequest {

	//Sprint - persistence auto ID
    @Id
    private String id;
	
	private Room room;
	private Point startingPosition;
	private HashSet<Trash> trashPositions;
	private LinkedList<CardinalDirection> robotMoves;
	
	public RoomblaRequest(Room room, Point startingPosition, HashSet<Trash> trashPositions,
			LinkedList<CardinalDirection> robotMoves) {
		super();
		this.room = room;
		this.startingPosition = startingPosition;
		this.trashPositions = trashPositions;
		this.robotMoves = robotMoves;
	}
	
	public RoomblaRequest(RoomblaRequestAWS awsRequest) {
		super();
		this.room = new Room(awsRequest.getRoomSize()[0], awsRequest.getRoomSize()[1]);
		this.startingPosition = new Point(awsRequest.getCoords()[0], awsRequest.getCoords()[1]);
        this.trashPositions = mapToTrash(awsRequest.getPatches());
        this.robotMoves = mapToCardinalDirections(awsRequest.getInstructions()[0]);
	}

	private HashSet<Trash> mapToTrash(int[][] trashPositions) {
		HashSet<Trash> trashSet = new HashSet<Trash>();
        for(int i = 0; i < trashPositions.length; i++) {
        	trashSet.add(new Trash(trashPositions[i][0], trashPositions[i][1]));
        }
		return trashSet;
	}
	
	public LinkedList<CardinalDirection> mapToCardinalDirections(String directions) {
		LinkedList<CardinalDirection> cardinalDirections = new LinkedList<CardinalDirection>();
		for(char direction : directions.toCharArray()) {
			switch (direction) {
				case 'N': cardinalDirections.add(CardinalDirection.N);
					break;
				case 'E': cardinalDirections.add(CardinalDirection.E);
					break;
				case 'S': cardinalDirections.add(CardinalDirection.S);
					break;
				case 'W': cardinalDirections.add(CardinalDirection.W);
					break;
				default:
					break;
			}
		}
		return cardinalDirections;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Room getRoom() {
		return room;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public Point getStartingPosition() {
		return startingPosition;
	}
	
	public void setStartingPosition(Point startingPosition) {
		this.startingPosition = startingPosition;
	}
	
	public HashSet<Trash> getTrashPositions() {
		return trashPositions;
	}
	
	public void setTrashPositions(HashSet<Trash> trashPositions) {
		this.trashPositions = trashPositions;
	}
	
	public LinkedList<CardinalDirection> getRobotMoves() {
		return robotMoves;
	}
	
	public void setRobotMoves(LinkedList<CardinalDirection> robotMoves) {
		this.robotMoves = robotMoves;
	}
	
	public String getRobotMovesAsString() {
		StringBuffer sf = new StringBuffer();
		for(CardinalDirection move : robotMoves) {
			sf.append(move.name());	
		}
		return sf.toString();
	}

	@Override
	public String toString() {
		return "RoomblaRequest [id=" + id + ", room=" + room + ", startingPosition=" + startingPosition
				+ ", trashPositions=" + trashPositions + ", robotMoves=" + robotMoves + "]";
	}

	
}
