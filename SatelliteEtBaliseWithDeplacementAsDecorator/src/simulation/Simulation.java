package simulation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import model.Beacon;
import model.DiagonalMovement;
import model.HorizontalMovement;
import model.SatelliteMovement;
import model.VerticalMovement;
import model.Movement;
import model.Manager;
import model.MaritimeStation;
import model.Satellite;
import nicellipse.component.NiRectangle;
import nicellipse.component.NiSpace;
import views.GrBeacon;
import views.GrEther;
import views.GrMaritimeStation;
import views.GrSatellite;

public class Simulation {
	final int FPS_MIN = 2;
	final int FPS_MAX = 500;
	final int FPS_INIT = 10;
	final int startDelay = 500 / FPS_INIT;
	
	Timer animation;
	Manager manager = new Manager();
	Dimension worldDim = new Dimension(900, 700);
	NiSpace world = new NiSpace("Satellite & Balises", this.worldDim);
	GrEther ether = new GrEther();

	public void animation() {
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				manager.tick();
				ether.repaint();		
			}
		};
		
		this.animation = new Timer(this.startDelay, taskPerformer);
		this.animation.setRepeats(true);
		this.animation.start();
	}
	
	/**
	 * Slider qui permet à l'utilisateur de définir le nombre FPS de la simulation
	 * @return JPanel slider
	 */
	private JPanel fpsSliderPanel() {		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel label = new JLabel(" FPS :", JLabel.RIGHT);
		JSlider framesPerSecond = new JSlider(JSlider.HORIZONTAL, FPS_MIN, FPS_MAX, FPS_INIT);

		framesPerSecond.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				if (!source.getValueIsAdjusting()) {
					int fps = (int) source.getValue();
					int newDelay = 1000 / fps;
					animation.setDelay(newDelay);
					animation.setInitialDelay(newDelay * 10);
				}
			}
		});

		// Turn on labels at major tick marks.
		framesPerSecond.setMajorTickSpacing(50);
		framesPerSecond.setMinorTickSpacing(10);
		framesPerSecond.setPaintTicks(true);
		framesPerSecond.setPaintLabels(false);
		
		panel.add(label);
		panel.add(framesPerSecond);
		return panel;
	}

	/**
	 * Ajouter une balise
	 * @param sea JPanel qui represente la mer
	 * @param memorySize Espace de stockage de la balise
	 * @param startPos Position de départ de la balise
	 * @param depl Méthode de déplacement de la balise
	 */
	public void addBalise(JPanel sea, int memorySize, Point startPos, Movement depl) {
		// model
		Beacon bal = new Beacon(memorySize);
		bal.setPosition(startPos);
		bal.setDeplacement(depl);
		
		manager.addModel(bal);
		
		// vue
		GrBeacon grbal = new GrBeacon(this.ether);
		grbal.setModel(bal);
		sea.add(grbal);
	}

	/**
	 * Ajouter un satellite
	 * @param sea JPanel qui represente le ciel
	 * @param memorySize Espace de stockage du satellite
	 * @param startPos Position de départ du satellite
	 * @param depl Méthode de déplacement du satellite
	 */
	public void addSatelitte(JPanel sky, int memorySize, Point startPos, int vitesse) {
		// model
		Satellite sat = new Satellite(memorySize);
		sat.setPosition(startPos);
		sat.setDeplacement(new SatelliteMovement(-10, 1000, vitesse));
		
		manager.addModel(sat);
		
		// vue
		GrSatellite grSat = new GrSatellite(this.ether);
		grSat.setModel(sat);
		sky.add(grSat);
	}
	
	public void addMaritimeStation(JPanel sky) {
		// vue
		GrMaritimeStation grDatacenter = new GrMaritimeStation(ether);
		
		MaritimeStation datacenter = new MaritimeStation(sky.getWidth() / 2 - grDatacenter.getWidth() / 2, sky.getHeight() - grDatacenter.getHeight());
		
		manager.addModel(datacenter);
		grDatacenter.setModel(datacenter);
		sky.add(grDatacenter);
	}

	/**
	 * Lancer la simulation
	 */
	public void launch() {
		JLayeredPane main = new JLayeredPane();
		main.setOpaque(true);
		main.setSize(this.worldDim);

		this.ether.setBorder(null);
		this.ether.setBackground(Color.gray);
		this.ether.setOpaque(false);
		this.ether.setDimension(this.worldDim);

		NiRectangle sky = new NiRectangle();
		sky.setBackground(Color.white);
		sky.setDimension(new Dimension(this.worldDim.width, this.worldDim.height / 2));
		
		NiRectangle sea = new NiRectangle();
		sea.setBackground(Color.blue);
		sea.setDimension(new Dimension(this.worldDim.width, this.worldDim.height / 2));
		sea.setLocation(new Point(0, this.worldDim.height / 2));

		this.addSatelitte(sky, 2000, new Point(10, 50), 2);
		this.addSatelitte(sky, 2000, new Point(100, 10), 1);
		this.addSatelitte(sky, 2000, new Point(400, 90), 3);
		this.addSatelitte(sky, 2000, new Point(500, 140), 4);
		this.addSatelitte(sky, 2000, new Point(600, 10), 1);
		
		this.addBalise(sea, 300, new Point(400, 200), new HorizontalMovement(50, 750));
		this.addBalise(sea, 400, new Point(100, 100), new VerticalMovement(50, 200));
		this.addBalise(sea, 200, new Point(0, 160), new HorizontalMovement(0, 800));
		this.addBalise(sea, 500, new Point(200, 100), new VerticalMovement(130, 270));
		this.addBalise(sea, 150, new Point(300, 100), new HorizontalMovement(200, 600));
		
		this.addBalise(sea, 150, new Point(400, 0), new DiagonalMovement(new Point(150,250), new Point(100,200)));
		main.add(sky, JLayeredPane.DEFAULT_LAYER);
		main.add(sea, JLayeredPane.DEFAULT_LAYER);
		main.add(this.ether, JLayeredPane.POPUP_LAYER);
		this.addMaritimeStation(sky);
		
		this.world.setLayout(new BoxLayout(this.world, BoxLayout.Y_AXIS));
		this.world.add(main);
		this.world.add(this.fpsSliderPanel());
		this.world.openInWindow();
		
		this.animation();
	}

	public static void main(String[] args) {
		new Simulation().launch();
	}

}
