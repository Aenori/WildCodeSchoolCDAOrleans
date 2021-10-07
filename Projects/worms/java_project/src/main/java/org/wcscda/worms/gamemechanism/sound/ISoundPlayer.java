package org.wcscda.worms.gamemechanism.sound;

/* package */ interface ISoundPlayer {
  void playSound(String filename);

  boolean canPlay(String filename);
}