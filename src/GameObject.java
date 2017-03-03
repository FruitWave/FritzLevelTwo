import java.awt.Graphics;

public class GameObject {
	int x;
	int y;
	int widthGO;
	int heightGO;

	void update() {
		x = 100;
		y = 10;
		
	}

	void draw(Graphics vector) {
		System.out.println(x + "." + y);
		vector.fillRect(x, y, 100, 100);

	}
}
