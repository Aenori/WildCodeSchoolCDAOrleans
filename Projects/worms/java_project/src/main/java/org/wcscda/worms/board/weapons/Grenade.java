package org.wcscda.worms.board.weapons;

import org.wcscda.worms.Helper;
import org.wcscda.worms.gamemechanism.phases.WormMovingPhase;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.ImageObserver;


public class Grenade extends AbstractWeapon {

    private static final String imagePath = "src/resources/weapons/grenade.png";
    private static Image image = null;
    private static final int grenadeRadius = 50;


    private static void initImages() {
        image = new ImageIcon(imagePath).getImage().getScaledInstance(50, 30, 0);
    }


    @Override
    public void draw(Graphics2D g, ImageObserver io) {
        if (image == null) {
            initImages();
        }
   /*     Ellipse2D circle =
                new Ellipse2D.Double(
                        Helper.getWormX() - grenadeRadius,
                        Helper.getWormY() - grenadeRadius,
                        2 * grenadeRadius,
                        2 * grenadeRadius);

*/
        g.setColor(Color.ORANGE);
        /* Size of aiming system */
        g.setStroke(new BasicStroke(10));

    /*    g.draw(circle);*/
        g.drawImage(image, (int) Helper.getWormX(), (int) Helper.getWormY(), io);

       if (getAngle() > Math.PI / 2) {
            AffineTransform trans =
                    AffineTransform.getTranslateInstance(Helper.getWormX() + 100, Helper.getWormY());
            trans.scale(10, 10);

            g.drawImage(image, trans, io);
        } else {
            g.drawImage(image, (int) Helper.getWormX(), (int) Helper.getWormY(), io);
        }
    }

}
