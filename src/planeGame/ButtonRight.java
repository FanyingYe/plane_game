package planeGame;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class ButtonRight extends MyButton{
	public ButtonRight(Map map) {
		super(map);
		setIcon (new ImageIcon ("right.png"));
		setActionCommand("right");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		map.doAction(e);
	}
}
