package com.pleasecompile.algorithm;

import java.util.HashSet;

import com.pleasecompile.CardinalDirection;
import com.pleasecompile.Point;
import com.pleasecompile.Room;
import com.pleasecompile.Trash;
import com.pleasecompile.service.RoomblaRequest;
import com.pleasecompile.service.RoomblaResult;

public class RoomblaHashSetStrategy implements RoomblaStrategy {

	@Override
	public RoomblaResult execute(RoomblaRequest request) {

		HashSet<Trash> trashPositions = request.getTrashPositions();
		RoomblaResult result = new RoomblaResult();
		Room room = request.getRoom();
		Point currentPosition = request.getStartingPosition();

		if(trashPositions.contains(new Trash(currentPosition.getX(), currentPosition.getY()))) {
			result.addTrash();
			trashPositions.remove(currentPosition);
		}
		
		for(CardinalDirection move : request.getRobotMoves()) {
			move.move(currentPosition, room);
			if(trashPositions.contains(new Trash(currentPosition.getX(), currentPosition.getY()))) {
				result.addTrash();
				trashPositions.remove(new Trash(currentPosition.getX(), currentPosition.getY()));
			}
		}
		result.setEndLocation(currentPosition);

		return result;
	}

}