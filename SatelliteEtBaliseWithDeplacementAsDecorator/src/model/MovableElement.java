package model;

import java.awt.Point;

import events.PositionChanged;

public abstract class MovableElement extends Model {
	Movement depl;
	Point position;
	int memorySize;
	int dataSize;

	public MovableElement(int memorySize) {
		super();
		this.memorySize = memorySize;
		this.dataSize = 0;
		this.position = new Point(0, 0);
	}

	public int dataSize() {
		return this.dataSize;
	}

	public int memorySize() {
		return this.memorySize;
	}

	public Movement movements() {
		return depl;
	}
	
	protected void resetData() {
		this.dataSize = 0;
	}

	protected boolean memoryFull() {
		return (this.dataSize >= this.memorySize);
	}

	@Override
	public void tick() {
		this.move();
	}

	public void move() {
		this.depl.move(this);
		super.send(new PositionChanged(this));
	}

	public void setPosition(Point position) {
		if (this.position.equals(position))
			return;
		this.position = position;
	}

	public Point getPosition() {
		return position;
	}

	public void setDeplacement(Movement depl) {
		this.depl = depl;
	}
}
