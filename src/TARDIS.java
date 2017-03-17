import java.awt.Color;
import java.awt.Graphics;

public class TARDIS extends GameObject {
	int x;
	int y;
	int width;
	int height;
	int warpfactorX;
	int warpfactorY;
	int noninitializedRealityWarpFactors;

	public TARDIS(int xvar, int yvar, int widthvar, int heightvar) {
		x = xvar;
		y = yvar;
		width = widthvar;
		height = heightvar;
		warpfactorX = 5;
	}

	void update() {
		x += warpfactorX;
		y += warpfactorY;
	}

	void draw(Graphics batman) {
		batman.setColor(Color.BLUE);
		batman.fillRect(x, y, width, height);

	}

}

