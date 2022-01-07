package model;

import java.awt.Point;

public class Datacenter extends UnmovableElement {
	public Datacenter(int x, int y) {
		super.position = new Point(x, y);
	}
	
	public Datacenter(Point position) {
		super.position = position;
	}
	
	@Override
	public void tick() {
		super.tick();
	}
}
