package model;

import java.awt.Point;

public class HorizontalMovement extends BeaconMovement {
	Integer start;
	Integer end;
	Boolean fromStartToEnd = true;

	public HorizontalMovement(Integer start, Integer end) {
		super (null);
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void move(MovableElement target) {
		Point p = target.getPosition();
		int x = p.x;
		if (fromStartToEnd) {
			x += 6;
			if (x > end) fromStartToEnd = false;
		} else {
			x -= 2;
			if (x < start) fromStartToEnd = true;
		}
		target.setPosition(new Point(x, p.y));
	}

}
