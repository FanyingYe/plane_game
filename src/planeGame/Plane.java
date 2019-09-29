package planeGame;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class Plane {
	protected int x;
	protected int y;
	protected Map map;
	protected int speed;
	protected boolean isAlive;

	public Plane(int x, int y, Map map) {
		this.x = x;
		this.y = y;
		this.map = map;
		this.speed = 1;
		isAlive = true;
	}
	public abstract void draw(Graphics g);
	public abstract Rectangle getRect();	
	public abstract boolean isInside(Point p);
	public void left () {
		x -= 10;
		map.repaint();
	}

	public void right () {
		x += 10;
		map.repaint();
	}
	
	public void up () {
		y -= 10;
		map.repaint();
	    }

	public void down () {
		y += 10;
		map.repaint();
	}
}


