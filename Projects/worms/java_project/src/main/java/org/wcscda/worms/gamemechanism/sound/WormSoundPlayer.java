package org.wcscda.worms.gamemechanism.sound;

/*import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;*/

import java.util.HashMap;
import java.util.Map;

/* NRO 2021-09-30 : Test class to play sound
 *  don't use for the moment as it requires some thread
 *  management, which hasn't been covered yet
 */
public class WormSoundPlayer {
  private static WormSoundPlayer instance;

  public static WormSoundPlayer getWormSoundPlayer() {
    if (instance == null) {
      instance = new WormSoundPlayer();
    }

    return instance;
  }

  private final Map<String, ISoundPlayer> soundPlayers = new HashMap<>();

  public WormSoundPlayer() {
    register(".wav", new WavSoundPlayer());
    register(".mp3", new MP3SoundPlayer());
  }

  private void register(String extension, ISoundPlayer soundPlayer) {
    soundPlayers.put(extension, soundPlayer);
  }

  public void playSound(String filename) {
    for (Map.Entry<String, ISoundPlayer> entry : soundPlayers.entrySet()) {
      if (filename.endsWith(entry.getKey())) {
        entry.getValue().playSound(filename);
        return;
      }
    }

    System.err.println("Unsupported file format : " + filename);
  }

  public boolean canPlay(String filename) {
    for (Map.Entry<String, ISoundPlayer> entry : soundPlayers.entrySet()) {
      if (filename.endsWith(entry.getKey())) {
        return entry.getValue().canPlay(filename);
      }
    }

    return false;
  }
}
