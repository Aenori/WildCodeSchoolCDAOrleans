package org.wcscda.worms.gamemechanism.sound;

import java.io.File;
import java.util.HashMap;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class WavSoundPlayer implements ISoundPlayer {
  private HashMap<String, Clip> wavMapping = new HashMap<>();

  public void playSound(String filename) {
    if (!wavMapping.containsKey(filename)) {
      loadWav(filename);
    }

    Clip clip = wavMapping.get(filename);
    // loading didn't work properly
    if (clip == null) return;
    clip.setFramePosition(0);
    clip.start();
    //clip.loop(1);
  }

  @Override
  public boolean canPlay(String filename) {
    return wavMapping.get(filename) != null;
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
}