package Pioneer;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectIntel {
	ArrayList<GameObject> objects;

	//previously score was initialized here, privately, to 0
	
	long enemyTimer = 0;
	int enemySpawnTime = 1;

	public ObjectIntel() {
		objects = new ArrayList<GameObject>();
	}

	public void addObject(GameObject o) {
		objects.add(o);
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.update();
		}

		purgeObjects();
	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
	}

	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).mortality) {
				objects.remove(i);
			}
		}
	}

	// public void manageEnemies() {
	// if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
	// addObject(new Hydra(new Random().nextInt(Runner.width), 0, 200, 200));
	// enemyTimer = System.currentTimeMillis();
	// }
	// }

	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);

				if (o1.collisionBox.intersects(o2.collisionBox)) {

					if ((o1 instanceof Tank1 && o2 instanceof ProjectileA)
							|| (o2 instanceof Tank1 && o1 instanceof ProjectileA)
							|| (o1 instanceof Tank2 && o2 instanceof ProjectileA)
							|| (o2 instanceof Tank2 && o1 instanceof ProjectileA)) {
						System.out.println("true");
						score++;
						System.out.println(score);
						o1.mortality = false;
						o2.mortality = false;
					} else if ((o1 instanceof Hydra && o2 instanceof Tank1)
							|| (o2 instanceof Hydra && o1 instanceof Tank1)) {
						o1.mortality = false;
						o2.mortality = false;
					}

				}
			}
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int s) {
		score = s;
	}

	public void reset() {
		objects.clear();
	}
}
