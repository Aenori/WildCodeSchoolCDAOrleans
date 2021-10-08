package org.wcscda.worms.board.weapons;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

import org.wcscda.worms.Helper;

public class ShotgunAmmo extends AbstractAmmo {
  private static final int EXPLOSION_RADIUS = 30;
  private static final int EXPLOSION_DAMAGE = 15;
  private static final int HADOKEN_RECT_SIZE = 10;
  private static final String[] imagePath = {
			"src/resources/weapons/shotgunAmmo.png"
	};
	private static final Image[] SUPERGRENADE = new Image[1];
  public ShotgunAmmo(Double angle) {
    super(EXPLOSION_RADIUS, EXPLOSION_DAMAGE);
    createMovableRect(HADOKEN_RECT_SIZE, HADOKEN_RECT_SIZE);
    getMovable().setDirection(angle);
    getMovable().setSpeed(5);

    setInitialPosition();
  }

	private static void initImages() {
		for (int i = 0; i < imagePath.length; i++) {
			SUPERGRENADE[i] = new ImageIcon(imagePath[i]).getImage().getScaledInstance(30, 30, 0);
		}
	}
	
  @Override
  public void drawMain(Graphics2D g, ImageObserver io) {
		if (SUPERGRENADE[0] == null) {
			initImages();
		}
		if (Helper.getActiveWorm().getDirection() < Math.PI / 2) {
			g.drawImage(SUPERGRENADE[Helper.getClock() % SUPERGRENADE.length], (int) getMovable().getCenterX(), (int) getMovable().getCenterY() - 18, io);
		} else {
			AffineTransform trans =
					AffineTransform.getTranslateInstance(getMovable().getX(), getMovable().getY());
			trans.scale(-1, 1);
			g.drawImage(SUPERGRENADE[Helper.getClock() % SUPERGRENADE.length], trans, io);
		}
  }
}
