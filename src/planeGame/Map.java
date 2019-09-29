package planeGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JComponent;

public class Map extends JComponent{
	
	private Image bg = GameUtil.getImage("images/bg.jpg");	
	private Plane plane;
	private List<Bullet> bullets = new ArrayList<Bullet>();
	private Date startTime, endTime,currentTime;
	private double period;
	Explode explode;
	private StartButton start;
	
	public Map () {
		new PaintThread().start();
	}
	
	public void addPlane (int type) {	   
	    if (type == 1){
	    	plane = new ToyPlane(150,350,this);
	    } else{
	    	plane = new StuntPlane(150,350,this);
	    }
	}
	
	public void setStartButton(StartButton start){
		this.start = start;
	}
	
	public void startGame(){
		for(int i=0;i<10;i++){
    		Bullet b = new Bullet();
    		bullets.add(b);
    	}
		startTime = new Date();
	}
	
	/**
	 * callback of left, up, down, right button
	 * @param e
	 */
	public void doAction(ActionEvent e){
		if(plane != null){
			if(e.getActionCommand().equals("left"))
				plane.left();
			if(e.getActionCommand().equals("right"))
				plane.right();
			if(e.getActionCommand().equals("up"))
				plane.up();
			if(e.getActionCommand().equals("down"))
				plane.down();
		}		
	}
	
	/**
	 * print information on the window
	 * @param g
	 * @param str: string needs to be print out
	 * @param size: printed string size
	 */
	public void printInfo(Graphics g,String str,int size,int x,int y){
		Color c = g.getColor();
		g.setColor(Color.white);
		Font f = new Font("SansSerif", Font.ITALIC, size);
		g.setFont(f);
		g.drawString(str, x, y);
		g.setColor(c);
	}
	
    /**
     * This is the draw callback
     */
    public void paintComponent (Graphics g) {
    	g.drawImage(bg,0,0,null);
    	if(plane != null && plane.isAlive) {
    		plane.draw(g);
    		if(startTime != null){
    			currentTime = new Date();
        		double liveTime = (double)(currentTime.getTime()-startTime.getTime())/1000.0;
        		printInfo(g,"Time:"+liveTime+"s",10,200,30);
    		}		
    		for(Bullet b:bullets){
    			b.draw(g);
    			boolean bomb = b.getRect().intersects(plane.getRect());
    			if (bomb) {
    				System.out.println("Bomb!!!");
    				plane.isAlive = false;
    				bullets.clear();
    				endTime = new Date();
    				period = (double)(endTime.getTime()-startTime.getTime())/1000.0;
    				if(explode == null){
    					explode = new Explode(plane.x,plane.y);
    				}
    				explode.draw(g);
    				start.setEnabled(false);
    				break;
    			}
    		}
    	} else if(plane!=null&& !plane.isAlive){	
    		printInfo(g,"GAME OVER",50,100,200);
    		printInfo(g,"Final Time:"+period+"s",20,100,300);
    		startTime = null;
    	}
    }
    
      
    class PaintThread extends Thread {
    	public void run() {
    		while (true){
    			repaint();
    			try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    		}
    	}
    }    
}

