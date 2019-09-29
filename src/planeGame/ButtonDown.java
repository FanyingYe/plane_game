package planeGame;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class ButtonDown extends MyButton{
	public ButtonDown(Map map) {
		super(map);
		setIcon (new ImageIcon("down.png"));
		setActionCommand("down");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		map.doAction(e);		
	}
}
