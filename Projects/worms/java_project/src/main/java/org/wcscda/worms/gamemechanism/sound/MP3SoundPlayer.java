package org.wcscda.worms.gamemechanism.sound;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/* package */ class MP3SoundPlayer implements ISoundPlayer {
  private HashMap<String, FileInputStream> mp3Mapping = new HashMap<>();
  private HashMap<String, Thread> threadMapping = new HashMap<>();

  public void playSound(String filename) {
    if (!mp3Mapping.containsKey(filename)) {
      loadMP3(filename);
    }

    FileInputStream fis = mp3Mapping.get(filename);
    if (fis == null) return;

    if (threadMapping.containsKey(filename)) {
      threadMapping.get(filename).interrupt();
    }

    Thread newThread =
        new Thread() {
          public void run() {
            Player player = null;
            try {
              player = new Player(fis);
              player.play();
              player.close();
            } catch (JavaLayerException e) {
              e.printStackTrace();
            }
          }
        };

    newThread.start();
    threadMapping.put(filename, newThread);
  }

  private void loadMP3(String filename) {
    try {
      FileInputStream fis = new FileInputStream(filename);
      mp3Mapping.put(filename, fis);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      mp3Mapping.put(filename, null);
    }
  }

  @Override
  public boolean canPlay(String filename) {
    return mp3Mapping.get(filename) != null;
  }
}
