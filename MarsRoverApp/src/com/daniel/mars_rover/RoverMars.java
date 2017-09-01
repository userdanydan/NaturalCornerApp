package com.daniel.mars_rover;

import java.util.ArrayList;
import java.util.List;

public class RoverMars {
	
	private Plateau plateau;
	private List<Rover> rovers;
	
	public RoverMars() {
		// TODO Auto-generated constructor stub
		plateau = new Plateau(5, 5);
		rovers = new ArrayList<>();
	}
	
	public RoverMars(Plateau plateau, List<Rover> rovers) {
		super();
		this.plateau = plateau;
		this.rovers = new ArrayList<>();
	}

	public void setPlateau(Plateau plateau) {
		// TODO Auto-generated method stub
		this.plateau=plateau;
	}

	public Plateau getPlateau() {
		// TODO Auto-generated method stub
		return this.plateau;
	}

	public boolean addRover(Rover rover) {
		// TODO Auto-generated method stub
		return this.rovers.add(rover);
	}

	public Rover getRover(int i) {
		// TODO Auto-generated method stub
		return this.rovers.get(i);
	}

	public void moveRovers() {
		// TODO Auto-generated method stub
		
	}

}
