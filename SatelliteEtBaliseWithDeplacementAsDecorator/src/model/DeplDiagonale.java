package model;

import java.awt.Point;

public class DeplDiagonale extends DeplacementBalise {
	Point start;
	Point end;
	Boolean fromP1ToP2 = true;
	Boolean startPointX = false;

	public DeplDiagonale(Point p1, Point p2) {
		super (null);
		this.start = p1;
		this.end = p2;
	}
	
	@Override
	public void bouge(ElementMobile target) {
		
		if(startPointX) {
			Point p = target.getPosition();
			int x = p.x;
			int y = p.y;
			
			if (fromP1ToP2) {
				x += 5;
				y += 5;
				if (x > end.x && y > end.y) fromP1ToP2 = false; System.out.println("Descend { x : " + x + " | y : " + y + "} --> { x : " + end.x + " | y : " + end.y + "}");
			} else {
				x -= 5;
				y -= 5;
				if (y < start.y && x < start.x) fromP1ToP2 = true; System.out.println("Monte { x : " + x + " | y : " + y + "} --> { x : " + start.x + " | y : " + start.y + "}");
			}
			target.setPosition(new Point(x, y));
		}
		else {
			int x = target.getPosition().x;
			if (x > start.x) {
				x -= 5;
			} else {
				x += 5;
			}

			if (x == start.x) {
				startPointX = true; 
			}
			target.setPosition(new Point(x, target.getPosition().y));
		}
	}
}
