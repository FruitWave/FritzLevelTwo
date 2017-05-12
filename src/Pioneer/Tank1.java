package Pioneer;

import java.awt.Color;
import java.awt.Graphics;

public class Tank1 extends GameObject {
	int movefactorX;
	int movefactorY;

	public Tank1(int x, int y, int width, int height) {
		super(x, y, width, height);
		movefactorX = 0;
		movefactorY = 0;
	}

	void update() {
		super.update();
		x += movefactorX;
		y += movefactorY;
	}

	void draw(Graphics tankA) {
		tankA.setColor(Color.BLACK);
		tankA.fillRect(x, y, width, height);
	}
}
