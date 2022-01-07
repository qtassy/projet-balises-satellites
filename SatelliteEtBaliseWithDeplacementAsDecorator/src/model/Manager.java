package model;

import java.util.ArrayList;

import events.SatelliteMoved;

public class Manager {
	ArrayList<Model> models = new ArrayList<Model>();
	
	public void addModel(Model mod) {
		this.models.add(mod);
		mod.setManager(this);
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
