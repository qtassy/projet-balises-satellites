package views;

import events.SynchroEvent;
import model.UnmovableElement;

public abstract class GrUnmovableElement extends GrModel {

	private static final long serialVersionUID = 7032873724568151943L;
	
	UnmovableElement model;
	
	public GrUnmovableElement(GrEther ether) {
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

	public UnmovableElement getModel() {
		return model;
	}

	public void setModel(UnmovableElement model) {
		this.model = model;
		this.setLocation(this.model.getPosition());
	}
}
