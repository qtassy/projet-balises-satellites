package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import nicellipse.component.NiImage;
import nicellipse.component.NiRectangle;

public class GrSatellite extends GrElementMobile {
	private static final long serialVersionUID = -8534493300853878234L;
	private NiRectangle jaugeDatasize;

	public GrSatellite(GrEther ether) {
		super(ether);
		File path = new File("satellite.png");
		BufferedImage rawImage = null;
		try {
			rawImage = ImageIO.read(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		NiRectangle jauge = new NiRectangle();
		jauge.setSize(new Dimension(rawImage.getWidth(), 10));
		jauge.setLocation(new Point(0, rawImage.getHeight() + 5));
		
		jaugeDatasize = new NiRectangle();
		jaugeDatasize.setBackground(Color.RED);
		jaugeDatasize.setSize(new Dimension(0, 10));
		jaugeDatasize.setLocation(new Point(0, rawImage.getHeight() + 5));
		
		this.add(jaugeDatasize);
		
		this.add(jauge);
		this.add(new NiImage(rawImage));
		
		this.setDimension(new Dimension(rawImage.getWidth(), rawImage.getHeight() + 15));
	}
	
	public void updateJaugeDataSize(int width) {
		jaugeDatasize.setSize(new Dimension(width, jaugeDatasize.getHeight()));
	}
	
}