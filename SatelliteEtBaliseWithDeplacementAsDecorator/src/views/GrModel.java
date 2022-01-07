package views;

import events.SynchroEvent;
import events.SynchroEventListener;
import nicellipse.component.NiRectangle;

public abstract class GrModel extends NiRectangle implements SynchroEventListener {
	Boolean duringSynchro = false;
	GrEther ether;
	
	private static final long serialVersionUID = 9076312960026105984L;
	
	@Override
	public void whenStartSynchro(SynchroEvent arg) {
		duringSynchro = true;
	}

	@Override
	public void whenStopSynchro(SynchroEvent arg) {
		duringSynchro = false;
	}
}
