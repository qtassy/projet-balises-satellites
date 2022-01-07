package model;

import events.SatelliteMoved;

public class BeaconMovement extends Movement {

	protected Movement next;
	
	public BeaconMovement (Movement next) {
		this.next = next;
	}
	
	public void move(Beacon target) {
	}

	@Override
	public void move(MovableElement target) {
		this.move((Beacon) target);
	}

	public void whenSatelitteMoved(SatelliteMoved arg, Beacon target) { }
}
