package model;

import java.awt.Point;

public abstract class UnmovableElement extends Model {
	Point position;
	
	public UnmovableElement(Point p) {
		this.position = p;
	}
	
	public UnmovableElement(int x, int y) {
		this.position = new Point(x, y);
	}

	@Override
	public void tick() {
		
	}

	public Point getPosition() {
		return this.position;
	}
}
