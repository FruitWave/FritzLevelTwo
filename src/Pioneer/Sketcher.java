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

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (tanka.movefactorY == -1 || tanka.movefactorY == 1) {
				tanka.movefactorY = 0;
				tanka.movefactorX = 0;
			}
			tanka.movefactorY -= 5;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (tanka.movefactorX == -1 || tanka.movefactorX == 1) {
				tanka.movefactorX = 0;
				tanka.movefactorY = 0;
			}
			tanka.movefactorX -= 5;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (tanka.movefactorX == -1 || tanka.movefactorX == 1) {
				tanka.movefactorX = 0;
				tanka.movefactorY = 0;
			}
			tanka.movefactorX += 5;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (tanka.movefactorY == -1 || tanka.movefactorY == 1) {
				tanka.movefactorY = 0;
				tanka.movefactorX = 0;
			}
			tanka.movefactorY += 5;
			// tanka.movefactorY += 5; , for additives/subtractitives
			// not "absolute" speeds
		} else if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			System.out.println("pew pew");
		}
		// int momentum = (tanka.movefactorX + tanka.movefactorY)/2;

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
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
		if (tanka.movefactorX < 0) {
			for (int i = tanka.movefactorX; i != 0; i++) {
				tanka.movefactorX += 1;
				System.out.println("x stop down");
			}
			tanka.movefactorX = -1;/* MAKES IT NEVER STOP left */
		} else if (tanka.movefactorX > 0) {
			for (int i = tanka.movefactorX; i != 0; i--) {
				tanka.movefactorX -= 1;
				System.out.println("x stop up");
			}
			tanka.movefactorX = 1;/* MAKES IT NEVER STOP right */
		}
		if (tanka.movefactorY < 0) {
			for (int i = tanka.movefactorY; i != 0; i++) {
				tanka.movefactorY += 1;
			}
			tanka.movefactorY = -1;/* MAKES IT NEVER STOP down */
		} else if (tanka.movefactorY > 0) {
			for (int i = tanka.movefactorY; i != 0; i--) {
				tanka.movefactorY -= 1;
			}
			tanka.movefactorY = 1;/* MAKES IT NEVER STOP up */
		}
	}
}
