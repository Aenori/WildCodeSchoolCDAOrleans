package org.wcscda.worms.board.weapons;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

import org.wcscda.worms.Helper;

public class HadokenAmmo extends AbstractAmmo {
  private static final int HADOKEN_AMMO_RADIUS = 15;
  private static final int HADOKEN_RECT_SIZE = 10;
  private static final int EXPLOSION_RADIUS = 30;
  private static final int EXPLOSION_DAMAGE = 30;
  private static final int INITIAL_SPEED = 5;

	private static final String[] imagePath = {
			"src/resources/weapons/hadoken1.png",
			"src/resources/weapons/hadoken1.png",
			"src/resources/weapons/hadoken2.png",
			"src/resources/weapons/hadoken2.png",
			"src/resources/weapons/hadoken3.png",
			"src/resources/weapons/hadoken3.png",
			"src/resources/weapons/hadoken4.png",
			"src/resources/weapons/hadoken4.png"
	};
	private static final Image[] hadoken = new Image[8];
	private final double initialX;
	private final double initialY;
	private int initTimer;

  public HadokenAmmo(Double angle) {
    super(EXPLOSION_RADIUS, EXPLOSION_DAMAGE);
    createMovableRect(HADOKEN_RECT_SIZE, HADOKEN_RECT_SIZE);
    getMovable().setDirection(angle);
    getMovable().setSpeed(INITIAL_SPEED);

    initialX = Helper.getWormX();
    initialY = Helper.getWormY();

    setInitialPosition();
  }

	private static void initImages() {
		for (int i = 0; i < imagePath.length; i++) {
			hadoken[i] = new ImageIcon(imagePath[i]).getImage().getScaledInstance(30, 30, 0);
		}
	}
	
  @Override
  public void drawMain(Graphics2D g, ImageObserver io) {
		if (hadoken[0] == null) {
			initImages();
		}
		if (Helper.getActiveWorm().getDirection() < Math.PI / 2) {
			g.drawImage(hadoken[Helper.getClock() % hadoken.length], (int) getMovable().getCenterX(), (int) getMovable().getCenterY() - 18, io);
		} else {
			AffineTransform trans =
					AffineTransform.getTranslateInstance(getMovable().getX(), getMovable().getY());
			trans.scale(-1, 1);
			g.drawImage(hadoken[Helper.getClock() % hadoken.length], trans, io);
		}
  }
}
