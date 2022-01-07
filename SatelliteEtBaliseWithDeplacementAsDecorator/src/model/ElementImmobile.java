package model;

import java.awt.Point;

public abstract class ElementImmobile extends Model {
	Point position;
	
	@Override
	public void tick() {
		
	}

	public Point getPosition() {
		return this.position;
	}
}
