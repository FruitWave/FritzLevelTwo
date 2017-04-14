package leagueInvasion;
import java.awt.Color;
import java.awt.Graphics;

public class TARDIS extends GameObject {
//	int x;
//	int y;
//	int width;
//	int height;
	int warpfactorX;
	int warpfactorY;
	int noninitializedRealityWarpFactors;

	public TARDIS(int xvar, int yvar, int widthvar, int heightvar) {
		super();
		x = xvar;
		y = yvar;
		width = widthvar;
		height = heightvar;
		warpfactorX = 5;
		warpfactorY = 5;
	}

	void update() {
		super.update();
		x += warpfactorX;
		y += warpfactorY;
	}

	void draw(Graphics batman) {
		batman.drawImage(GamePanel.rocketImg, x, y, width, height, null);


	}

}

