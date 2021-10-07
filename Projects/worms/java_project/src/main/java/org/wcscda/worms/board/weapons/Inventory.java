package org.wcscda.worms.board.weapons;

import org.wcscda.worms.Helper;
import org.wcscda.worms.Player;
import org.wcscda.worms.Worm;
import org.wcscda.worms.board.AbstractDrawableElement;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Inventory extends AbstractDrawableElement {


    private final ArrayList<AbstractWeapon> weapons = new ArrayList<>();
    private final Map<Worm, ArrayList<AbstractWeapon>> wormWeaponInventory = new HashMap<>();
    private Boolean isInventoryOpen = false;


    public void createInventory() {

        weapons.add(new Shotgun());
        weapons.add(new Hadoken());
        weapons.add(new Grenade());
        weapons.add(new SuperGrenade());
        weapons.add(new GrenadeTimer());


        for (Player player : Helper.getTC().getPlayers()) {
            for (Worm worm : player.getWorms()) {
                wormWeaponInventory.put(worm, weapons);
            }
        }

        for (Map.Entry<Worm, ArrayList<AbstractWeapon>> entry : wormWeaponInventory.entrySet()) {
            Worm worm = entry.getKey();
            ArrayList<AbstractWeapon> abstractWeapon = entry.getValue();
            System.out.println(worm.getName() + ": Size: " + abstractWeapon.size() + " Type: " + entry.getValue());
        }

    }

    public Boolean getInventoryOpen() {
        return isInventoryOpen;
    }

    public void setInventoryOpen(Boolean inventoryOpen) {
        isInventoryOpen = inventoryOpen;
    }

    @Override
    protected void drawMain(Graphics2D g, ImageObserver io) {
        if (isInventoryOpen) {
            Rectangle2D.Double inventoryRect = new Rectangle2D.Double(Helper.getActivePlayer().getActiveWorm().getCenterX(), Helper.getActivePlayer().getActiveWorm().getCenterY(), 100, 100);
        g.setColor(Color.lightGray);
        g.draw(inventoryRect);
    } else {
            System.out.println("ola");
        }

    }
}
