package org.wcscda.worms.board;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.wcscda.worms.Helper;
import org.wcscda.worms.gamemechanism.sound.WormSoundPlayer;
import org.wcscda.worms.utils.DrawHelper;

public class Explosion extends AbstractDrawableElement {
  private static final int LIFE_DURATION = 40;
  private final double centerX;
  private final double centerY;
  private final double radius;
  private final int createdPhase;

  public Explosion(double centerX, double centerY, int explosionRadius) {
    super(true);
    this.centerX = centerX;
    this.centerY = centerY;
    this.radius = explosionRadius;
    this.createdPhase = Helper.getClock();
    
  }
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
  private int getLifeTime() {
    return Helper.getClock() - createdPhase;
  }
  @Override
  protected void drawMain(Graphics2D g, ImageObserver io) {
	 
    Shape explosion =
        DrawHelper.getCircle(
            centerX, centerY, (int) (radius * (0.1 + getLifeTime() * 0.9 / LIFE_DURATION)));
    
    g.setColor(DrawHelper.getColorRGB(255, 255 - 255 * getLifeTime() / LIFE_DURATION, 0));
    g.fill(explosion);
    musicSound("src/resources/sound/Explosion.wav");
   
    if (getLifeTime() == LIFE_DURATION) {
      removeSelf();
      
    }
    
  }
}
