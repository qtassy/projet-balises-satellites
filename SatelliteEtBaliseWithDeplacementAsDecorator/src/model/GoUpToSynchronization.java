package model;

import java.awt.Point;

public class GoUpToSynchronization extends BeaconMovement {
	
	public GoUpToSynchronization(Movement next) {
		super (next);
	}
		
	@Override
	public void move(MovableElement target) {
		Point p = target.getPosition();
		int y = p.y;
		if (y > 0) {
			y -= 3;
			if (y < 0) y = 0;
			target.setPosition(new Point(p.x, y));
		} else {
			target.getManager().baliseReadyForSynchro((Beacon) target);
			target.setDeplacement(this.next);			
		}
	}
	
}
