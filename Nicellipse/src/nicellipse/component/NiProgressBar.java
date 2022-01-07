package nicellipse.component;

import javax.swing.JProgressBar;

public class NiProgressBar extends JProgressBar implements NiBorderedComponent {

	private static final long serialVersionUID = 4912104897861653610L;

	public NiProgressBar() {
		super();
	}
	
	public NiProgressBar(int min, int max) {
		super(min, max);
	}
}
