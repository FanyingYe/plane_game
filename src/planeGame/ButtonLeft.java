package planeGame;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class ButtonLeft extends MyButton{
	public ButtonLeft(Map map) {
		super(map);
		setIcon (new ImageIcon ("left.png"));
		setActionCommand("left");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		map.doAction(e);
	}
}
