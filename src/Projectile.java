import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
	private int x;
	private int y;
	private int width;
	private int height;
	private int speed = 10;

	/**
	 * 
	 * @param px
	 *            position x
	 * @param py
	 *            position y
	 * @param bx
	 *            body x (size)
	 * @param by
	 *            body y (size)
	 */
	public Projectile(int px /* p = position */, int py,
			int bx /* b = body (width in this case) */, int by) {
		x = px;
		y = py;
		width = bx;
		height = by;
	}

	void update() {
		y -= speed;
		if (y < 0) {
			isAlive = false;
		}
	}

	void draw(Graphics arrow) {
		arrow.setColor(Color.red);
		arrow.fillRect(x, y, width, height);
	}
}
