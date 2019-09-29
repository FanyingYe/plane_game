package planeGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MyRadio extends JPanel implements ItemListener {
	private int type=1;
	
    public MyRadio () {
		// Border around our JPanel
		setBorder (new LineBorder(Color.BLUE, 1));
	
		// ButtonGroup makes them behave as radio buttons
		ButtonGroup g = new ButtonGroup ();
	
		JCheckBox cb = new JCheckBox ("Toy", true);
		add (cb);
		g.add (cb);
		cb.addItemListener (this);
	
		cb = new JCheckBox ("Stunt", false);
		add (cb);
		g.add (cb);
		cb.addItemListener (this);
    }
    
    public int getType(){
    	return type;
    }
    
    public void itemStateChanged (ItemEvent e) {
		if (e.getStateChange()==ItemEvent.SELECTED) {
			if(((JCheckBox)e.getItem()).getText().equals("Toy")){
				type = 1;
			}else {
				type = 2;
			}
		}
    }
}