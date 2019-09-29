package planeGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class StartButton extends JButton implements ActionListener{
	
	private Map map;
	
	public StartButton(Map map) {
		setText("Start Game");
		this.map = map;
		addActionListener(this);
		setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
    	map.startGame();
	}
}
