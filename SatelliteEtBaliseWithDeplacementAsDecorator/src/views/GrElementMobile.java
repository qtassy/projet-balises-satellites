package views;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import events.PositionChanged;
import events.SynchroEvent;
import model.MovableElement;
import nicellipse.component.NiProgressBar;

/**
 * Représentation graphique d'un élément mobile
 *
 */
public class GrElementMobile extends GrModel  {
	MovableElement model;
	GrEther ether;
	Boolean duringSynchro = false;
	NiProgressBar dataBar;
	
	public GrElementMobile(GrEther ether) {
		this.ether = ether;
		this.setBorder(null);
		this.setBackground(null);
		this.setOpaque(false);
	}

	Object getModel() { return this.model; }
	
	public void setModel(MovableElement model) {
		this.model = model;
		model.registerListener(PositionChanged.class, this);
		model.registerListener(SynchroEvent.class, this);
		this.setUpDataBar();
		this.add(dataBar);
		this.setLocation(this.model.getPosition());
		this.repaint();		
	}
	
	private void setUpDataBar() {
		if(this.dataBar != null) {
			this.remove(dataBar);
		}
		
		this.dataBar = new NiProgressBar(0, this.model.memorySize());
		this.dataBar.setOrientation(NiProgressBar.VERTICAL);
		this.dataBar.setValue(this.model.dataSize());
		this.dataBar.setBounds(0, 0, 10, this.getHeight() - 10);
		this.dataBar.setForeground(Color.GREEN);
		this.setDimension(new Dimension(this.getWidth() + this.dataBar.getWidth(), this.getHeight()));
		this.add(this.dataBar);
		this.dataBar.setLocation(this.getWidth() - this.dataBar.getWidth(), 0);
	}
	
	@Override
	public void whenStartSynchro(SynchroEvent arg) {
		this.updateDataBar();
		duringSynchro = true;
		this.ether.startSync(this);	
	}

	@Override
	public void whenStopSynchro(SynchroEvent arg) {
		this.updateDataBar();
		duringSynchro = false;
		this.ether.stopSync(this);	
	}

	@Override
	public void whenPositionChanged(PositionChanged arg) {
		this.updateDataBar();
		this.setLocation(this.model.getPosition());
		this.repaint();
	}
	
	public void updateDataBar() {
		this.dataBar.setValue(this.model.dataSize());
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
	
}