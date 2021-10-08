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
import org.wcscda.worms.gamemechanism.sound.WormSoundPlayer;

public class Scores extends AbstractDrawableElement {
	int lifePlayer;

	public int getLifePlayer() {
		return lifePlayer;
	}

	public void setLifePlayer(int lifePlayer) {
		this.lifePlayer = lifePlayer;
	}

	@Override
	public void drawMain(Graphics2D g, ImageObserver io) {
		ArrayList<Player> players = Helper.getTC().getPlayers();

		Font font1 = new Font("Verdana", Font.TYPE1_FONT, 12);
		int p = 0;
		int x = 20;
		int y = 20;
		int ligne = 20;
		for (int i = 0; i < players.size(); i++) {

			ArrayList<Worm> worms = players.get(i).getWorms();

			g.setFont(font1);
			g.setColor(Color.YELLOW);
			p = p + 20;


			int lifePlayer = 0;

			for (int j = 0; j < worms.size(); j++) {
				g.drawString("      "+players.get(i).getName(), (int) x, (int) y );
				//int lifeWorm = Helper.getTC().getPlayers().get(i).getWorms().get(j).getLife();
				g.drawString("  " + worms.get(j).getLife(), (int) x +20,
						(int) y + ligne);
				ligne += 20;
				lifePlayer += worms.get(j).getLife();
			}
			g.drawString("Total : " + lifePlayer, (int) x + 20,
					(int) y + ligne);
			x += 140;
			ligne = 20;
		}
	}
}
