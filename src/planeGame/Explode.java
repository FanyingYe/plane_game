package planeGame;

import java.awt.Graphics;
import java.awt.Image;

public class Explode {
	int x,y;
	static Image[] imgs = new Image[16];
	static {
		for(int i=1;i<6;i++){
			imgs[i-1] = GameUtil.getImage("images/e"+i+".gif");
		}
	}
	
	int count = 0;
	public void draw(Graphics g){
		if(count <=5){
			g.drawImage(imgs[count], x, y, null);
			count++;
		}
	}
	
	public Explode(int x,int y) {
		this.x =x;
		this.y =y;
	}
}
