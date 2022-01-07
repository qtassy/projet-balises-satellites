package model;

import events.SatelitteMoveListener;
import events.SatelliteMoved;


public class Beacon extends MovableElement implements SatelitteMoveListener{
	
	// Précise si la balise collecte des données ou non
	boolean collect = true;
	
	public Beacon(int memorySize) {
		super(memorySize);
	}
	
	public int deepness() { 
		return this.getPosition().y; 
	}
	
	protected void readSensors() {
		if (collect) {
			this.dataSize++;
		}
	}
	
	public void tick() {
		this.readSensors();
		
		// Si la balise est en collecte de données et pleine, alors l'action de synchronisation se lance
		if (this.memoryFull() && collect == true) {
			Movement goDown = new GoDown(this.movements(), this.deepness());
			Movement synchroMovement = new SynchronizationMovement(goDown);
			Movement nextMovement = new GoUpToSynchronization(synchroMovement);
			this.setDeplacement(nextMovement);
			this.collect = false;
		} 
		super.tick();
	}
	
	public void move () {
		super.move();
	}

	@Override
	public void whenSatelitteMoved(SatelliteMoved arg) {
		BeaconMovement dp = (BeaconMovement) this.depl;
		dp.whenSatelitteMoved(arg, this);
	}


}
