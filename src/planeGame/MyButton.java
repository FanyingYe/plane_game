package planeGame;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class MyButton extends JButton implements ActionListener{
	protected Map map;
	public MyButton(Map map) {
		this.map = map;
		addActionListener(this);
	}
}
