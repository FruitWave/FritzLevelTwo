package Pioneer;

import java.awt.Color;
import java.awt.Graphics;

public class Tank1 extends ObjectConstructor {
	
	public Tank1(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	void update(){
		
	}
	void draw(Graphics tankA){
		tankA.setColor(Color.magenta);
		tankA.fillRect(x, y, width, height);
	}
}
