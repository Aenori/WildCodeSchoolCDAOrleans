package wcscda.small_game;

import java.awt.*;
import java.awt.image.ImageObserver;

<<<<<<< HEAD
import org.w3c.dom.events.MouseEvent;

public class Chess extends Drawable implements SmallGameInterface {
    @Override
    public void draw(Graphics2D g, ImageObserver io) {
    	
        drawGrid(g,io);
        
        
        g.setFont(new Font("Roboto", Font.BOLD, 50));
        g.drawString("Chessnb;:,b", 50, 50);
        
    }

    private void drawGrid(Graphics2D g,ImageObserver io) {
		
		int width = 670;
		int x = 0;
		int y = 0;
		g.setColor(Color.YELLOW);
		g.drawLine(width / 3 + x, y, width / 3 + x, y + width);
		g.drawLine(width / 3 * 2 + x, y, width / 3 * 2 + x, y + width);

		// draw horizontal grid lines
		g.drawLine(x, width / 3 + y, x + width, width / 3 + y);
		g.drawLine(x, width / 3 * 2 + y, x + width, width / 3 * 2 + y);
		/*for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int totalWidth =100;
				
            }
    	
    }*/
    }  
=======
public class Chess extends Drawable implements SmallGameInterface {
    @Override
    public void draw(Graphics2D g, ImageObserver io) {
        drawGrid(g, io);

        g.setFont(new Font("Roboto", Font.BOLD, 50));
        g.drawString("Chess", 50, 50);
    }

    private void drawGrid(Graphics2D g, ImageObserver io) {
    }
>>>>>>> aenori_main
}
