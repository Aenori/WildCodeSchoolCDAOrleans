package org.wcscda.worms.board.weapons;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

import org.wcscda.worms.Helper;

public class Grenade extends AbstractWeapon {
	private static final String imagePath = "src/resources/weapons/grenade1.png";
	private static Image image = null;
	// private static final int grenadeRadius = 20;
	private static void initImages() {
	    image = new ImageIcon(imagePath).getImage().getScaledInstance(50, 30, 0);
	  }
	@Override
	  public void draw(Graphics2D g, ImageObserver io) {
	    if (image == null) {
	      initImages();
	    }

	    if (getAngle() > Math.PI / 2) {
	      AffineTransform trans =
	          AffineTransform.getTranslateInstance(Helper.getWormX(), Helper.getWormY());
	      trans.scale(-1, 1);

	      g.drawImage(image, trans, io);
	    } else {
	      g.drawImage(image, (int) Helper.getWormX(), (int) Helper.getWormY(), io);
	    }
	  }
	
}
