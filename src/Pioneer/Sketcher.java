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
	Tank1 tanka = new Tank1(500, 800, 100, 100);
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;

	public Sketcher() {
		Godclock = new Timer(1000 / 60, this);

	}

	void startGame() {
		Godclock.start();
	}

	void updateMenuState() {

	}

	void updateGameState() {
		tanka.update();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics a) {
		a.setColor(Color.blue);
		a.fillRect(0, 0, 1000, 1000);
	}

	void drawGameState(Graphics b) {
		
		b.setColor(Color.GREEN);
		b.fillRect(0, 0, 1000, 1000);
		tanka.draw(b);
	}

	void drawEndState(Graphics c) {
		c.setColor(Color.red);
		c.fillRect(0, 0, 1000, 1000);
	}

	public void paintComponent(Graphics inkswipe) {
		if (currentState == MENU_STATE) {
			drawMenuState(inkswipe);
		} else if (currentState == GAME_STATE) {
			drawGameState(inkswipe);
		} else if (currentState == END_STATE) {
			drawEndState(inkswipe);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		// System.out.println("action performed");
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("typed");

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyChar() == KeyEvent.VK_UP) {

		} else if (e.getKeyChar() == KeyEvent.VK_LEFT) {

		} else if (e.getKeyChar() == KeyEvent.VK_RIGHT) {

		} else if (e.getKeyChar() == KeyEvent.VK_DOWN) {

		} else if (e.getKeyChar() == KeyEvent.VK_SHIFT) {

		}

		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
			} else if (currentState == GAME_STATE) {
				currentState = END_STATE;
			} else if (currentState == END_STATE) {
				currentState = MENU_STATE;
			}
			System.out.println(currentState);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("released");

	}
}
