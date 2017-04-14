package Pioneer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Sketcher extends JPanel implements ActionListener {
	Timer Godclock;

	public Sketcher() {

	}

	void startGame() {
		Godclock.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
