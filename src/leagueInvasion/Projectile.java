package leagueInvasion;
import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	
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
		super();
		x = px;
		y = py;
		width = bx;
		height = by;
	}

	void update() {
		super.update();
		y -= speed;
		if (y < 0) {
			isAlive = false;
		}
	}

	void draw(Graphics arrow) {
		arrow.drawImage(GamePanel.bulletImg, x, y, width, height, null);

	}
}
