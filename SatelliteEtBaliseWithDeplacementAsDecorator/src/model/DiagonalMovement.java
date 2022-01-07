package model;

import java.awt.Point;

public class DiagonalMovement extends BeaconMovement {
	Point start;
	Point end;
	Boolean fromP1ToP2 = true;
	Boolean startPointX = false;

	public DiagonalMovement(Point p1, Point p2) {
		super (null);
		this.start = p1;
		this.end = p2;
	}
	
	@Override
	public void move(MovableElement target) {
		
		if(startPointX) {
			Point p = target.getPosition();
			int x = p.x;
			int y = p.y;
			
			if (fromP1ToP2) {
				x += 5;
				y += 5;
				if (x > end.x && y > end.y) fromP1ToP2 = false;
			} else {
				x -= 5;
				y -= 5;
				if (y < start.y && x < start.x) fromP1ToP2 = true;
			}
			target.setPosition(new Point(x, y));
		}
		else {
			int x = target.getPosition().x;
			if (x > start.x) {
				x -= 5;
			} else {
				x += 5;
			}

			if (x == start.x) {
				startPointX = true; 
			}
			target.setPosition(new Point(x, target.getPosition().y));
		}
	}
}
