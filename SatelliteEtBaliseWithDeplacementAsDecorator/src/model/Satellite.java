package model;

import events.SatelliteMoved;

public class Satellite extends MovableElement {
			
	public Satellite(int memorySize) {
		super(memorySize);
	}
	
	public void move () {
		super.move();
		this.send(new SatelliteMoved(this));		
	}
}
