package planeGame;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class ButtonUp extends MyButton{

	public ButtonUp(Map map) {
		super(map);
		setIcon (new ImageIcon ("up.png"));
		setActionCommand("up");
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		map.doAction(e);
	}

}
