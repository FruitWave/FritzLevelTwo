package Pioneer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	boolean mortality = true;
	
	Rectangle collisionBox = new Rectangle(x, y, width, height);

	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	void draw(Graphics graphic) {

	}
}