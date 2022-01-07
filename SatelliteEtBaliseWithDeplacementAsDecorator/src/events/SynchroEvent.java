package events;

import eventHandler.AbstractEvent;
import model.SynchronizationMovement;

/**
 * Evenement pour indiquer une synchronisation entre un satellite et une balise
 *
 */
public class SynchroEvent extends AbstractEvent {
	private static final long serialVersionUID = 480096146703824993L;

	public SynchroEvent(Object source) {
		super(source);
	}

	public void runOn(Object target) {
		SynchroEventListener listener = (SynchroEventListener) target;
		SynchronizationMovement depl = (SynchronizationMovement) this.getSource();
		if (depl.synchroStarted())
			listener.whenStartSynchro(this);
		else 
			listener.whenStopSynchro(this);
	}
}
