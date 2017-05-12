package Pioneer;

import java.awt.Color;
import java.awt.Graphics;

public class Tank2 extends GameObject {
	int movefactorX;
	int movepfactorY;

	public Tank2(int x, int y, int width, int height) {
		super(x, y, width, height);
		movefactorX = 0;
		movepfactorY = 0;
	}

	void update() {

	}

	void draw(Graphics tankB) {
		tankB.setColor(Color.WHITE);
		tankB.fillRect(x, y, width, height);
	}
}
