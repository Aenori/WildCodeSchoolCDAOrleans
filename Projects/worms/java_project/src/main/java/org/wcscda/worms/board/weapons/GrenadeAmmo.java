package org.wcscda.worms.board.weapons;

import org.wcscda.worms.Helper;
import org.wcscda.worms.board.ARBEWithGravityAndHandler;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

public class GrenadeAmmo extends AbstractAmmo {
	private static final int GRENADE_RECT_SIZE = 10;
	private static final int EXPLOSION_RADIUS = 50;
	private static final int EXPLOSION_DAMAGE = 30;
	private static final int INITIAL_SPEED = 10;
	private static final String[] imagePath = {
			"src/resources/weapons/grenade1.png",
			"src/resources/weapons/grenade2.png",
			"src/resources/weapons/grenade3.png",
			"src/resources/weapons/grenade4.png"
	};
	private static final Image[] grenade = new Image[4];
	private final double initialX;
	private final double initialY;

	public GrenadeAmmo(Double angle) {
		super(EXPLOSION_RADIUS, EXPLOSION_DAMAGE);
		createMovableRect(GRENADE_RECT_SIZE, GRENADE_RECT_SIZE);
		getMovable().setDirection(angle);
		getMovable().setSpeed(INITIAL_SPEED);

		initialX = Helper.getWormX();
		initialY = Helper.getWormY();
	}

	private static void initImages() {
		for (int i = 0; i < imagePath.length; i++) {
			grenade[i] = new ImageIcon(imagePath[i]).getImage().getScaledInstance(30, 30, 0);
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
				System.err.print(rectWidth+" "+rectHeight);
	}

	@Override
	public void drawMain(Graphics2D g, ImageObserver io) {
		if (grenade[0] == null) {
			initImages();
		}
		if (Helper.getActiveWorm().getDirection() > Math.PI / 2) {
			g.drawImage(grenade[Helper.getClock() % grenade.length], (int) getMovable().getCenterX(), (int) getMovable().getCenterY() - 18, io);
		} else {
			AffineTransform trans =
					AffineTransform.getTranslateInstance(getMovable().getX(), getMovable().getY());
			trans.scale(-1, 1);
			g.drawImage(grenade[Helper.getClock() % grenade.length], trans, io);
		}
	}
}
