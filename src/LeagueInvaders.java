import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frameA;
	final int width = 500;
	final int height = 800;
	GamePanel gpanel;

	public LeagueInvaders() {
		frameA = new JFrame();
		gpanel = new GamePanel();
		setup();
	}

	public static void main(String[] args) {
		LeagueInvaders commandcenter = new LeagueInvaders();
	}

	void setup() {
		frameA.add(gpanel);
		frameA.setTitle("League Invaders");
		frameA.addKeyListener(gpanel);
		frameA.setSize(width, height);
		frameA.setVisible(true);
		frameA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gpanel.startGame();
	}
}
