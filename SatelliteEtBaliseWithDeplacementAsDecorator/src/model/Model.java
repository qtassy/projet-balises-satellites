package model;

import eventHandler.AbstractEvent;
import eventHandler.EventHandler;

public abstract class Model {
	Manager manager;
	EventHandler eventHandler;
	
	public Model() {
		this.eventHandler = new EventHandler();
	}
	
	public abstract void tick();
	
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public Manager getManager() {
		return manager;
	}
	
	// enregistrement des listeners
	public void registerListener(Class<? extends AbstractEvent> whichEventType, Object listener) {
		this.eventHandler.registerListener(whichEventType, listener);
	}
	
	public void unregisterListener(Class<? extends AbstractEvent> whichEventType, Object listener) {
		this.eventHandler.unregisterListener(whichEventType, listener);
	}
	
	// envoi des evenements
	public void send(AbstractEvent event) {
		this.eventHandler.send(event);
	}
}
