package org.wcscda.worms.gamemechanism;

import static org.junit.Assert.*;

import org.junit.Test;
import org.wcscda.worms.gamemechanism.sound.WormSoundPlayer;

public class WormSoundPlayerTest {
  private static final String testFilename = "src/resources/Explosion1.wav";
  private static final String testMp3Filename = "src/resources/Castle_In_The_Sky.mp3";

  @Test
  public void playWav() {
    /* int threadCount = Thread.activeCount();
    WormSoundPlayer wsp = new WormSoundPlayer();

    for (int i = 0; i < 100; ++i) {
      wsp.playSound(testFilename);
    }

    assertTrue(wsp.canPlay(testFilename));
    assertTrue(Thread.activeCount() < threadCount + 3);
    */
  }


  @Test
  public void playMP3() {
    /*
    int threadCount = Thread.activeCount();
    WormSoundPlayer wsp = new WormSoundPlayer();

    for (int i = 0; i < 100; ++i) {
      wsp.playSound(testMp3Filename);
    }

    assertTrue(wsp.canPlay(testMp3Filename));
    // System.out.println(threadCount + " / " + Thread.activeCount());
    // assertTrue(Thread.activeCount() < threadCount + 3);
    */
  }
}
