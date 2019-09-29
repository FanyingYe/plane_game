package planeGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JFrame{
		
	private Map myMap;
	public static void main (String [] args) {
		new Main();
    }

    public Main () {
    	// Window setup
    	setLocation (100, 100);
		setSize (500, 800);
		setDefaultCloseOperation (EXIT_ON_CLOSE);
		
		Container content = getContentPane();
		content.setLayout (new BorderLayout());
		content.setBackground(Color.BLUE);
		
		myMap = new Map();
		content.add (myMap, BorderLayout.CENTER);
		JPanel controls1 = new JPanel ();
		//controls1.setLayout (new GridLayout(1, 3));
		MyRadio radio = new MyRadio();
		controls1.add(radio);
		StartButton start = new StartButton(myMap);
		myMap.setStartButton(start);
		controls1.add(new AddPlaneButton(myMap,radio,start));
		controls1.add(start);
		
		JPanel controls2 = new JPanel ();
		controls2.add(new ButtonUp(myMap));
		JPanel controls3 = new JPanel ();
		controls3.add(new ButtonLeft(myMap));
		controls3.add(new ButtonDown(myMap));
		controls3.add(new ButtonRight(myMap));
		
		JPanel controls = new JPanel ();
		controls.setLayout (new GridLayout(2, 1));
		//controls.add (controls1);
		controls.add (controls2);
		controls.add (controls3);
			
		content.add (controls1, BorderLayout.NORTH);
		content.add (controls, BorderLayout.SOUTH);
		// And show the whole window
		setVisible (true);
    }
    
}
