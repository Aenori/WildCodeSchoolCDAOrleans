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

		Font font1 = new Font("Verdana", Font.BOLD, 12);
		int p = 0;

		for (int i = 0; i < players.size(); i++) {

			ArrayList<Worm> worms = players.get(i).getWorms();

			g.setFont(font1);
			g.setColor(Color.YELLOW);
			p = p + 20;

			for (int j = 0; j < worms.size(); j++) {

				int lifeWorm = Helper.getTC().getPlayers().get(i).getWorms().get(j).getLife();
				lifePlayer = worms.get(j).getPlayer().getWorms().size() * lifeWorm;

			}
			g.drawString(" Player: " + players.get(i).getName() + "  Worms life: " + lifePlayer, 600, 20 + p);
		}

	}

}
