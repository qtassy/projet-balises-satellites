package model;

public abstract class Movement {
	abstract public void move(MovableElement target) ;
	public Movement replacement() { return this; }
}
