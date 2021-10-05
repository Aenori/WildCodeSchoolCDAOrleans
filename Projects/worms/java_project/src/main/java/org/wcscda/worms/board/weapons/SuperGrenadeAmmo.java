package org.wcscda.worms.board.weapons;

import org.wcscda.worms.Helper;
import org.wcscda.worms.board.ARBEWithGravityAndHandler;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

public class SuperGrenadeAmmo extends AbstractAmmo {
	private static final int GRENADE_RECT_SIZE = 10;
	private static final int EXPLOSION_RADIUS = 100;
	private static final int EXPLOSION_DAMAGE = 50;
	private static final int INITIAL_SPEED = 7;
	private static final String[] imagePath = {
			"src/resources/weapons/SainteGrenade1.png",
			"src/resources/weapons/SainteGrenade1.png",
			"src/resources/weapons/SainteGrenade2.png",
			"src/resources/weapons/SainteGrenade2.png",
			"src/resources/weapons/SainteGrenade3.png",
			"src/resources/weapons/SainteGrenade3.png",
			"src/resources/weapons/SainteGrenade4.png",
			"src/resources/weapons/SainteGrenade4.png"
	};
	private static final Image[] SUPERGRENADE = new Image[8];
	private final double initialX;
	private final double initialY;

	public SuperGrenadeAmmo(Double angle) {
		super(EXPLOSION_RADIUS, EXPLOSION_DAMAGE);
		createMovableRect(GRENADE_RECT_SIZE, GRENADE_RECT_SIZE);
		getMovable().setDirection(angle);
		getMovable().setSpeed(INITIAL_SPEED);

		initialX = Helper.getWormX();
		initialY = Helper.getWormY();
	}

	private static void initImages() {
		for (int i = 0; i < imagePath.length; i++) {
			SUPERGRENADE[i] = new ImageIcon(imagePath[i]).getImage().getScaledInstance(30, 30, 0);
		}
	}
	
	@Override
	protected void createMovableRect(int rectWidth, int rectHeight) {
		setMovable(new ARBEWithGravityAndHandler(
				Helper.getWormX() - rectWidth / 2,
				Helper.getWormY() - rectHeight / 2,
				rectWidth,
				rectHeight,
				this));
	}

	@Override
	public void drawMain(Graphics2D g, ImageObserver io) {
		if (SUPERGRENADE[0] == null) {
			initImages();
		}
		if (Helper.getActiveWorm().getDirection() > Math.PI / 2) {
			g.drawImage(SUPERGRENADE[Helper.getClock() % SUPERGRENADE.length], (int) getMovable().getCenterX(), (int) getMovable().getCenterY() - 18, io);
		} else {
			AffineTransform trans =
					AffineTransform.getTranslateInstance(getMovable().getX(), getMovable().getY());
			trans.scale(-1, 1);
			g.drawImage(SUPERGRENADE[Helper.getClock() % SUPERGRENADE.length], trans, io);
		}
	}
}
