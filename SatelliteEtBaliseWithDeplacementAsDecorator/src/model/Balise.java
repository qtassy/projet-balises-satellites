package model;

import events.SatelitteMoveListener;
import events.SatelliteMoved;

public class Balise extends ElementMobile implements SatelitteMoveListener{
	
	// Précise si la balise collecte des données ou non
	boolean collecte = true;
	
	public Balise(int memorySize) {
		super(memorySize);
	}
	
	public int profondeur() { 
		return this.getPosition().y; 
	}
	
	protected void readSensors() {
		if (collecte) {
			this.dataSize++;
		}
	}
	
	public void tick() {
		this.readSensors();
		
		// Si la balise est en collecte de données et pleine, alors l'action de synchronisation se lance
		if (this.memoryFull() && collecte == true) {
			Deplacement redescendre = new Redescendre(this.deplacement(), this.profondeur());
			Deplacement deplSynchro = new DeplSynchronisation(redescendre);
			Deplacement nextDepl = new MonteSurfacePourSynchro(deplSynchro);
			this.setDeplacement(nextDepl);
			this.collecte = false;
		} 
		super.tick();
	}

	@Override
	public void whenSatelitteMoved(SatelliteMoved arg) {
		DeplacementBalise dp = (DeplacementBalise) this.depl;
		dp.whenSatelitteMoved(arg, this);
	}


}
