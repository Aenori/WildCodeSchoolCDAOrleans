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
import org.wcscda.worms.board.weapons.Grenade;
import org.wcscda.worms.board.weapons.Hadoken;
import org.wcscda.worms.board.weapons.Shotgun;
import org.wcscda.worms.board.weapons.SuperGrenade;
import org.wcscda.worms.gamemechanism.phases.WormMovingPhase;

public class Inventory extends AbstractDrawableElement {
	private Player player = Helper.getActivePlayer();
	private Image grenade = new ImageIcon("src/resources/weapons/grenade1.png").getImage().getScaledInstance(50, 50, 0);
	private Image hadoken = new ImageIcon("src/resources/weapons/hadoken.png").getImage().getScaledInstance(50, 50, 0);
	private Image sainteGrenade = new ImageIcon("src/resources/weapons/SainteGrenade1.png").getImage().getScaledInstance(50, 50, 0);
	private Image shotgun = new ImageIcon("src/resources/weapons/Shotgun_small.png").getImage().getScaledInstance(50, 50, 0);

	@Override
	protected void drawMain(Graphics2D g, ImageObserver io) {
		
		if (player.isInventory()) {
			if(player.getCurrentWeapon() instanceof Hadoken) {
				g.drawString(">>>>", (int) 1070, (int) 50);
			}else if(player.getCurrentWeapon() instanceof Shotgun){
				g.drawString(">>>>", (int) 1070, (int) 100);
			}else if(player.getCurrentWeapon() instanceof Grenade){
				g.drawString(">>>>", (int) 1070, (int) 150);
			}else if(player.getCurrentWeapon() instanceof SuperGrenade){
				g.drawString(">>>>", (int) 1070, (int) 200);
			}
			g.drawString("∞", (int) 1170, (int) 50);
			g.drawString("∞", (int) 1170, (int) 100);
			g.drawString("∞", (int) 1170, (int) 150);
			g.drawImage(hadoken, (int) 1110, (int) 20, io);
			g.drawImage(shotgun, (int) 1110, (int) 70, io);
			g.drawImage(grenade, (int) 1110, (int) 120, io);
			if(player.getSuperGrenadeAmmo()>0) {
			g.drawImage(sainteGrenade, (int) 1110, (int) 170, io);
			g.drawString(""+player.getSuperGrenadeAmmo(), (int) 1170, (int) 200);
			}
		}
	}

}
