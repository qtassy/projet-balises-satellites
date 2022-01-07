package model;

import java.awt.Point;

import events.PositionChanged;

public abstract class ElementMobile extends Model {
	Deplacement depl;
	Point position;
	int memorySize;
	int dataSize;

	public ElementMobile(int memorySize) {
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

	public Deplacement deplacement() {
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
		this.bouge();
	}

	public void bouge() {
		this.depl.bouge(this);
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

	public void setDeplacement(Deplacement depl) {
		this.depl = depl;
	}
}
