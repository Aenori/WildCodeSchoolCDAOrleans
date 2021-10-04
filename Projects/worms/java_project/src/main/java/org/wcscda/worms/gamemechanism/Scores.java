package org.wcscda.worms.gamemechanism;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import org.wcscda.worms.Helper;
import org.wcscda.worms.Player;
import org.wcscda.worms.Worm;
import org.wcscda.worms.board.AbstractDrawableElement;

public class Scores extends AbstractDrawableElement{
	@Override
	public void drawMain(Graphics2D g, ImageObserver io) {
		ArrayList<Player> players =Helper.getTC().getPlayers();
		 ArrayList<Worm> worms = Helper.
		 Font font1 = new Font("Verdana", Font.BOLD, 12);
		 int p=0;
	for(int i=0;i<players.size();i++) {
			g.setFont(font1);
			p=p+20;
			g.drawString("Player: "+players.get(i).getName().toString(), 600+p, 20+p );
			g.drawString("Worm  : "+players., 800+p, 30+p );
		
		
		
	}
		
		
		
		
		
	}

}
