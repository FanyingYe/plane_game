package planeGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AddPlaneButton extends JButton implements ActionListener{

	private Map map;
	private MyRadio radio;
	private StartButton start;
	
	public AddPlaneButton(Map map, MyRadio radio,StartButton start) {
		setText("Add");
		this.map = map;
		this.radio = radio;
		this.start = start;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		map.addPlane(radio.getType());
		start.setEnabled(true);
		map.repaint();
	}
}
