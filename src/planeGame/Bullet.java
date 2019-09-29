package planeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {
	private double x,y;
	private int speed;
	private double degree;
	private int diameter = 10;
	
	public Bullet(){
		speed = 3;
		degree = Math.random()*Math.PI*2;
		x = 220;
		y = 80;
	}
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, diameter, diameter);
		
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		if(y>510||y<0){
			//degree = Math.PI-degree;
			degree = -degree;
		}
		if(x<0||x>500){
			degree = Math.PI-degree;
			//degree = -degree;
		}
		g.setColor(c);
	}
	
	public Rectangle getRect() { 
		return new Rectangle((int)x,(int)y,diameter,diameter);
	}
}