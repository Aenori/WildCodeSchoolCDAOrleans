package wcscda.small_game;

import java.awt.*;
<<<<<<< HEAD
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

import org.w3c.dom.events.MouseEvent;

public class Morpion extends Drawable implements SmallGameInterface {
	 char player = 'X';
	 //char player2 = 'O';
    @Override
    public void draw(Graphics2D g, ImageObserver io) {
    	
    	int Width = 600;
    	int x = 600;
    	int y = 600;
    	
    	for (int i = 0; i < 3; i++) {
    	    for (int j = 0; j < 3; j++) {
				drawGrid(g, x / 3 * i, y/ 3 * j, Width / 3);
    	    }
    	}
    	
    }

    private void drawGrid(Graphics g, int x, int y, int width) {
    	int[] tictacto = new int [9];
    	for(int i=0;i<tictacto.length;i++) {
    		
    	}
		g.setColor(Color.YELLOW);
		//g.drawRect(300, y, width, width);
		//g.drawLine(width / 3 + x, y, width / 3 + x, y + width);
		g.drawLine(width / 3 * 3 + x, y, width / 3 * 3 + x, y + width);
		//g.drawLine(x, width / 3 + y, x + width, width / 3 + y);
		g.drawLine(x, width / 3 * 3 + y, x + width, width / 3 * 3 + y);
		
		
    }
    
	
=======
import java.awt.image.ImageObserver;

public class Morpion extends Drawable implements SmallGameInterface {
    @Override
    public void draw(Graphics2D g, ImageObserver io) {
        drawGrid(g, io);

        g.setFont(new Font("Roboto", Font.BOLD, 50));
        g.drawString("TicTacToe", 50, 50);
    }

    private void drawGrid(Graphics2D g, ImageObserver io) {
    }
>>>>>>> aenori_main
}
