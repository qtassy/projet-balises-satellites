package model;

import events.SatelliteMoved;
import events.SynchroEvent;

public class SynchronizationMovement extends BeaconMovement {
	private int synchroTime;
	private Satellite synchro;
	
	public Boolean synchroStarted() {
		return this.synchro != null;
	}
	
	public SynchronizationMovement(Movement next) {
		super(next);
		this.synchroTime = 10;
		this.synchro = null;
	}
	
	@Override
	public void whenSatelitteMoved(SatelliteMoved arg, Beacon target) {
		if (this.synchro != null) return;
		Satellite sat = (Satellite) arg.getSource();
		int satX = sat.getPosition().x;
		int tarX = target.getPosition().x;
		if (satX > tarX - 10 && satX < tarX + 10 && !sat.memoryFull()) {
			this.synchro = sat;
			target.send(new SynchroEvent(this));
			this.synchro.send(new SynchroEvent(this));
			sat.dataSize += target.dataSize;
			target.resetData();
		}
	}

	@Override
	public void move(Beacon target) {
		if (this.synchro == null) return;
		this.synchroTime--;
		if (synchroTime <= 0) {
			Satellite sat = this.synchro;
			this.synchro = null;
			this.synchroTime = 10;
			target.send(new SynchroEvent(this));
			sat.send(new SynchroEvent(this));
			target.getManager().baliseSynchroDone(target);
			target.setDeplacement(next);
		}		
	}
}
