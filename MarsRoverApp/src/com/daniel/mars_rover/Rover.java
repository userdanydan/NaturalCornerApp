package com.daniel.mars_rover;

public class Rover {
	public static final String NORTH = "N";
	public static final String EAST = "E";
	public static final String WEST = "W";
	public static final String SOUTH = "S";

	private String direction;
	private Position position;


	public Rover(Position position, String direction) {
		// TODO Auto-generated constructor stub
		this.position=position;
		this.direction=direction;
	}


	public String getDirection() {
		return direction;
	}


	public void setDirection(String direction) {
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
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
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
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	
	


}
