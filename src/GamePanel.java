import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font font;
	Font funFont;
	static int casualtyCount;
	TARDIS tardis = new TARDIS(250, 700, 50, 50);
	ObjectManager control = new ObjectManager();

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		font = new Font("Arial", Font.PLAIN, 48);
		funFont = new Font("Comic Sans MS", Font.CENTER_BASELINE, 30);
		casualtyCount = 0;
		control.addObject(tardis);
	}

	void updateMenuState() {

	}

	void updateGameState() {
		control.update();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics readyPlayerOne) {
		readyPlayerOne.setColor(Color.BLUE);
		readyPlayerOne.setFont(font);
		readyPlayerOne.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		readyPlayerOne.setColor(Color.WHITE);
		readyPlayerOne.drawString("READY PLAYER ONE", 5, 250);
		readyPlayerOne.setColor(Color.CYAN);
		readyPlayerOne.drawString("press enter to play", 48, 350);
		readyPlayerOne.setFont(funFont);
		readyPlayerOne.setColor(Color.MAGENTA);
		readyPlayerOne.drawString("press space for instructions", 48, 450);

	}

	void drawGameState(Graphics massatar) {
		massatar.setColor(Color.BLACK);
		massatar.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		tardis.draw(massatar);
	}

	void drawEndState(Graphics apocalypse) {
		apocalypse.setColor(Color.RED);
		apocalypse.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		apocalypse.setFont(font);
		apocalypse.setColor(Color.WHITE);
		apocalypse.drawString("GAME OVER", 90, 250);
		apocalypse.setColor(Color.BLACK);
		apocalypse.drawString("You killed " + casualtyCount + " aliens.", 60, 350);
		apocalypse.setFont(funFont);
		apocalypse.setColor(Color.WHITE);
		apocalypse.drawString("press delete to restart", 75, 450);
	}

	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}

	}

	void startGame() {
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
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
		// TODO Auto-generated method stub
		System.out.println("keyTyped");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyPressed");
		if (e.getKeyCode() == 10) {
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
			} else if (currentState == GAME_STATE) {
				currentState = END_STATE;
			} else if (currentState >= END_STATE) {
				currentState = MENU_STATE;
			}
		}
		if (e.getKeyCode() == 8) {
			if (currentState >= END_STATE) {
				currentState = MENU_STATE;
			}
		}
		// System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 38) {
			tardis.warpfactorY = -5;
		} else if (e.getKeyCode() == 37) {
			tardis.warpfactorX = -5;
		} else if (e.getKeyCode() == 40) {
			tardis.warpfactorY = 5;
		} else if (e.getKeyCode() == 39) {
			tardis.warpfactorX = 5;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyReleased");
		tardis.warpfactorX = 0;
		tardis.warpfactorY = 0;

	}

}
