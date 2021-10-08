package org.wcscda.worms.board.weapons;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.wcscda.worms.Helper;
import org.wcscda.worms.board.*;
import org.wcscda.worms.utils.MathHelper;

public abstract class AbstractAmmo implements IMovableHandler {
	private static final int FIRING_WORM_ANTICOLLISION = 20;
  private static final double INITIAL_DISTANCE_MARGIN = 0.5;

	private final int firedPhase;
	private final int explosionRadius;
	private final int explosionDamage;


  private AbstractRectangularBoardElement movable;
  private boolean initialPositionSet = false;

	public AbstractAmmo(int explosionRadius, int explosionDamage) {
		firedPhase = Helper.getClock();

		this.explosionDamage = explosionDamage;
		this.explosionRadius = explosionRadius;
	}

	public AbstractRectangularBoardElement getMovable() {
		return movable;
	}


  // Override this method if you want to have another movement
  // behaviour
  protected void createMovableRect(int rectWidth, int rectHeight) {
    this.movable = new ARBEWIthHandler(0, 0, rectWidth, rectHeight, this);
  }

  /* Important ! must be called at the end of construction process */
  protected void setInitialPosition() {
    double x = Helper.getWormX();
    double y = Helper.getWormY();

    Rectangle2D wormRect = Helper.getActiveWorm().getInnerRect();

    double distance =
        MathHelper.distance(wormRect.getWidth(), wormRect.getHeight())
            + MathHelper.distance(
                movable.getInnerRect().getWidth(), movable.getInnerRect().getHeight())
            + INITIAL_DISTANCE_MARGIN;

    movable.setPosition(
        new Point2D.Double(
            x + distance * Math.cos(movable.getDirection()) - movable.getInnerRect().getWidth() / 2,
            y
                + distance * Math.sin(movable.getDirection())
                - movable.getInnerRect().getHeight() / 2));

    initialPositionSet = true;
  }

  protected int getFiredPhase() {
    return firedPhase;
  }
//son explosion
  HashMap<String, Clip> wavMapping = new HashMap<>();
  public void musicSound(String filename) {
	  
	    if (!wavMapping.containsKey(filename)) {
	      loadWav(filename);
	    }

	    Clip clip = wavMapping.get(filename);
	    // loading didn't work properly
	    if (clip == null) return;
	    clip.setFramePosition(0);
	    clip.start();
	    clip.loop(0);
	    
	  }
  private void loadWav(String filename) {
		wavMapping.put(filename, tryLoadWav(filename));
		
	}
  private Clip tryLoadWav(String filename) {
	    try {
	      AudioInputStream audioInputStream =
	          AudioSystem.getAudioInputStream(new File(filename).getAbsoluteFile());
	      Clip clip = AudioSystem.getClip();
	      clip.open(audioInputStream);
	      return clip;
	    } catch (Exception e) {
	      e.printStackTrace();
	      return null;
	    }
	  }
	@Override
	public void colideWith(AbstractBoardElement movable, Point2D prevPosition) {
		explode();

		Helper.getCurrentWeapon().triggerAmmoExplosion();
		  musicSound("src/resources/sound/Explosion.wav");
	}

	protected void explode() {
		this.movable.removeSelf();
		Helper.getPC()
		.generateExplosion(
				this.movable.getCenterX(), this.movable.getCenterY(), explosionRadius, explosionDamage);
	}

	protected void setMovable(AbstractRectangularBoardElement movable) {
		this.movable = movable;
	}
}
