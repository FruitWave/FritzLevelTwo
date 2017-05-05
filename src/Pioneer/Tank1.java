package Pioneer;

import java.awt.Color;
import java.awt.Graphics;


public class Tank1 extends GameObject {
	
	public Tank1(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	void update(){
		
	}
	void draw(Graphics tankA){
		tankA.setColor(Color.BLACK);
		tankA.fillRect(x, y, width, height);
	}
}
