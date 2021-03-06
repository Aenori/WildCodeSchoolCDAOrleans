package wcscda.small_game;

import java.awt.*;
import java.awt.image.ImageObserver;

public class Chess extends Drawable implements SmallGameInterface {
    @Override
    public void draw(Graphics2D g, ImageObserver io) {
        drawGrid(g, io);

        g.setFont(new Font("Roboto", Font.BOLD, 50));
        g.drawString("Chess", 50, 50);
    }

    private void drawGrid(Graphics2D g, ImageObserver io) {
    }
}
