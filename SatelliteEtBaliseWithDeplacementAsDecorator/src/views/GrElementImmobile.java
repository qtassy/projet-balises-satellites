package views;

import events.SynchroEvent;
import model.ElementImmobile;

public abstract class GrElementImmobile extends GrModel {

	private static final long serialVersionUID = 7032873724568151943L;
	
	ElementImmobile model;
	
	public GrElementImmobile(GrEther ether) {
		super.ether = ether;
		this.setBorder(null);
		this.setBackground(null);
		this.setOpaque(false);
	}
	
	@Override
	public void whenStartSynchro(SynchroEvent arg) {
		super.whenStartSynchro(arg);
	}

	@Override
	public void whenStopSynchro(SynchroEvent arg) {
		super.whenStopSynchro(arg);
	}

	public ElementImmobile getModel() {
		return model;
	}

	public void setModel(ElementImmobile model) {
		this.model = model;
		this.setLocation(this.model.getPosition());
	}
}
