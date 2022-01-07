package model;

import java.util.ArrayList;

import events.SatelliteMoved;

public class Manager {
	ArrayList<Model> models = new ArrayList<Model>();
	
	public void addBalise(Balise bal) {
		this.models.add(bal);
		bal.setManager(this);
	}
	public void addSatellite(Satellite sat) {
		this.models.add(sat);
		sat.setManager(this);
	}
	public void addDatacenter(Datacenter data) {
		this.models.add(data);
		data.setManager(this);
	}
	public void tick() {
		for (Model m : this.models) {
			m.tick();
		}
	}
	
	public void baliseReadyForSynchro(Balise b) {
		for (Model m : this.models) {
			if(m instanceof Satellite) {
				m.registerListener(SatelliteMoved.class, b);
			}
		}
	}
	public void baliseSynchroDone(Balise b) {
		for (Model m : this.models) {
			if(m instanceof Satellite) {
				m.unregisterListener(SatelliteMoved.class, b);
			}
		}
	}

}
