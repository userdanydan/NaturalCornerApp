package com.daniel.mars_rover;

public class Rover {
	public static final char NORTH = 'N';
	public static final char EAST = 'E';
	public static final char WEST = 'W';
	public static final char SOUTH = 'S';

	private char direction;
	private Position position;
	private String instructions;
	private boolean alreayMoved;


	public Rover(Position position, char direction, String instructions) {
		// TODO Auto-generated constructor stub
		this.position=position;
		this.direction=direction;
		this.instructions=instructions;
	}


	public char getDirection() {
		return direction;
	}


	public void setDirection(char direction) {
		this.direction = direction;
	}


	public Position getPosition() {
		return position;
	}


	public void setPosition(Position position) {
		this.position = position;
	}
	
	
	


	public String getInstructions() {
		return instructions;
	}


	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}








	public boolean isAlreayMoved() {
		return alreayMoved;
	}


	public void setAlreayMoved(boolean alreayMoved) {
		this.alreayMoved = alreayMoved;
	}


	public void rotate(char c) {
		// TODO Auto-generated method stub
		String directions = "NWSE";
		int indexDirection = Integer.MAX_VALUE;
		if(c=='R') {
			indexDirection = rotateRight(directions);
		}else if(c=='L'){
			indexDirection = rotateLeft(directions);
		}
		direction=directions.charAt(indexDirection);
	}


	private int rotateLeft(String directions) {
		int indexDirection;
		indexDirection = directions.indexOf(this.direction)-1;
		indexDirection=(indexDirection==-1)?3:indexDirection;
		return indexDirection;
	}


	private int rotateRight(String directions) {
		int indexDirection;
		indexDirection = directions.indexOf(direction)+1;
		indexDirection=(indexDirection==4)?0:indexDirection;
		return indexDirection;
	}




	public void move() {
		// TODO Auto-generated method stub
		switch(direction){
			case EAST : 
				position.setX(position.getX()-1);
				break;
			case NORTH : 
				position.setY(position.getY()+1);
				break;
			case SOUTH :
				position.setY(position.getY()-1);
				break;
			case WEST :
				position.setX(position.getX()+1);
				break;
		}
	}


	
	
	


}
