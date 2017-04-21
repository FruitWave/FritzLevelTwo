package Pioneer;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Runner {
	JFrame window;
	static final int width = 1000;
	static final int height = 1000;
	Sketcher sketchpanel;

	// constructor
	public Runner() {
		window = new JFrame();
		sketchpanel=new Sketcher();
		builder();

	}

	public static void main(String[] args) {
		Runner headquarters = new Runner();
	}

	void builder() {
		 window.add(sketchpanel);
		window.addKeyListener(sketchpanel);
		window.setTitle("Devastate");
		// window.addKeyListener(gpanel);
		window.setSize(width, height);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 sketchpanel.startGame();
	}
}