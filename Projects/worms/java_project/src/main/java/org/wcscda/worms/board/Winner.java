package org.wcscda.worms.board;

import org.wcscda.worms.Helper;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Winner extends AbstractDrawableElement{
    private static int positionX;
    private static int positionY;
    private static final Image[] winner = new Image[13];
    private static final String[] imagePath = {
            "src/resources/winner/winner-1.png",
            "src/resources/winner/winner-2.png",
            "src/resources/winner/winner-3.png",
            "src/resources/winner/winner-4.png",
            "src/resources/winner/winner-5.png",
            "src/resources/winner/winner-6.png",
            "src/resources/winner/winner-7.png",
            "src/resources/winner/winner-8.png",
            "src/resources/winner/winner-9.png",
            "src/resources/winner/winner-10.png",
            "src/resources/winner/winner-11.png",
            "src/resources/winner/winner-12.png",
            "src/resources/winner/winner-13.png",
    };

    public Winner(int positionWormX, int positionWormY) {
        positionX = positionWormX;
        positionY = positionWormY;
    }

    private static void initImages() {
        for (int i = 0; i < imagePath.length; i++) {
            winner[i] = new ImageIcon(imagePath[i]).getImage().getScaledInstance(43, 70, 0);
        }
    }

    @Override
    protected void drawMain(Graphics2D g, ImageObserver io) {
        if (winner[0] == null) {
            initImages();
        }

        for (int i = 0; i < Helper.getActivePlayer().getWorms().size(); i++) {
            g.drawImage(winner[(Helper.getClock()) % winner.length], (int) Helper.getActivePlayer().getWorms().get(i).getX() - 20, Helper.getActivePlayer().getWorms().get(i).getY() - 25, io);
        }
    }
}
