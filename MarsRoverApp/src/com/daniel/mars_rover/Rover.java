package com.daniel.mars_rover;

public class Rover {
	public static final char NORTH = 'N';
	public static final char EAST = 'E';
	public static final char WEST = 'W';
	public static final char SOUTH = 'S';

	private char direction;
	private Position position;


	public Rover(Position position, char direction) {
		// TODO Auto-generated constructor stub
		this.position=position;
		this.direction=direction;
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
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + direction;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rover other = (Rover) obj;
		if (direction != other.direction)
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}


	public void rotate(char c) {
		// TODO Auto-generated method stub
		String directions = "NWSE";
		int indexDirection = Integer.MAX_VALUE;
		if(c=='R') {
			indexDirection = directions.indexOf(direction)+1;
			indexDirection=(indexDirection==4)?0:indexDirection;
		}else if(c=='L'){
			indexDirection = directions.indexOf(this.direction)-1;
			indexDirection=(indexDirection==-1)?3:indexDirection;
		}
		direction=directions.charAt(indexDirection);
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
