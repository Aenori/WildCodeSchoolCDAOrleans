package org.wcscda.worms.gamemechanism;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.wcscda.worms.Helper;
import org.wcscda.worms.Player;
import org.wcscda.worms.Worm;
import org.wcscda.worms.board.AbstractDrawableElement;
import org.wcscda.worms.gamemechanism.phases.WormMovingPhase;

public class Inventory extends AbstractDrawableElement {
	private Player player = Helper.getActivePlayer();
	private Image grenade = new ImageIcon("src/resources/weapons/grenade1.png").getImage().getScaledInstance(50, 50, 0);
	private Image hadoken = new ImageIcon("src/resources/weapons/hadoken.png").getImage().getScaledInstance(50, 50, 0);
	private Image sainteGrenade = new ImageIcon("src/resources/weapons/SainteGrenade1.png").getImage().getScaledInstance(50, 50, 0);
	private Image shotgun = new ImageIcon("src/resources/weapons/Shotgun_small.png").getImage().getScaledInstance(50, 50, 0);

	@Override
	protected void drawMain(Graphics2D g, ImageObserver io) {
		if (Helper.getActivePlayer().isInventory()) {
			g.drawString("∞", (int) 1110, (int) 50);
			g.drawString("∞", (int) 1110, (int) 100);
			g.drawString("∞", (int) 1110, (int) 150);

			g.drawImage(hadoken, (int) 1130, (int) 20, io);
			g.drawImage(shotgun, (int) 1130, (int) 70, io);
			g.drawImage(grenade, (int) 1130, (int) 120, io);
			if(Helper.getActivePlayer().getSuperGrenadeAmmo()>0) {
			g.drawImage(sainteGrenade, (int) 1130, (int) 170, io);
			g.drawString(""+Helper.getActivePlayer().getSuperGrenadeAmmo(), (int) 1110, (int) 200);
			}
		}
	}

}
