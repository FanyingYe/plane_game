package planeGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

public class ToyPlane extends Plane{

	private Image img = GameUtil.getImage("images/ToyPlane.jpg");
	
	ToyPlane(int x, int y, Map map) {
		super(x,y,map);
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}

	@Override
	public Rectangle getRect() { 
		return new Rectangle(x,y,img.getWidth(null),img.getHeight(null));
	}	

	@Override
	public boolean isInside(Point p) {
		Rectangle loc = new Rectangle(x,y,img.getWidth(null),img.getHeight(null));
		return loc.contains (p);
	}
}