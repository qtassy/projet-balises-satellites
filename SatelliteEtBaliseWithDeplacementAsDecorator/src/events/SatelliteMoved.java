package events;

import eventHandler.AbstractEvent;

/**
 * Evenement pour indiquer le deplacement d'un satellite 
 */
public class SatelliteMoved extends AbstractEvent {
	private static final long serialVersionUID = 480096146703824993L;

	public SatelliteMoved(Object source) {
		super(source);
	}

	public void runOn(Object target) {
		SatelitteMoveListener listener = (SatelitteMoveListener) target;
		listener.whenSatelitteMoved(this);
	}
}
