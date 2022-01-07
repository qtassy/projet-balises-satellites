package views;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import nicellipse.component.NiImage;

public class GrDatacenter extends GrUnmovableElement {

	private static final long serialVersionUID = -7735833496959159110L;

	public GrDatacenter(GrEther ether) {
		super(ether);
		File path = new File("datacenter.png");
		BufferedImage datacenter = null;
		try {
			datacenter = ImageIO.read(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.add(new NiImage(datacenter));
		this.setDimension(new Dimension(datacenter.getWidth(), datacenter.getHeight()));
	}
}
