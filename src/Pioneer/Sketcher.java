package Pioneer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Sketcher extends JPanel implements ActionListener, KeyListener {
	Timer Godclock;
	

	public Sketcher() {
		Godclock = new Timer(1000 / 60, this);
		
	}

	void startGame() {
		Godclock.start();
	}

	public void paintComponent(Graphics inkswipe) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		// System.out.println("action performed");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("typed");

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_UP) {
			
		} else {

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("released");

	}
}
