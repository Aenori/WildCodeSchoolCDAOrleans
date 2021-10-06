package org.wcscda.worms.gamemechanism;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.Timer;
import org.wcscda.worms.Config;
import org.wcscda.worms.Player;
import org.wcscda.worms.Worm;
import org.wcscda.worms.gamemechanism.phases.AbstractPhase;
import org.wcscda.worms.gamemechanism.phases.WormMovingPhase;
import org.wcscda.worms.gamemechanism.playerrecorder.KeyboardControllerPlayer;
import org.wcscda.worms.gamemechanism.playerrecorder.KeyboardControllerRecorder;
import org.wcscda.worms.gamemechanism.sound.WormSoundPlayer;

public class TimeController implements ActionListener {
  private static TimeController instance;

  public KeyboardController getKeyboardController() {
    return keyboardController;
  }

  private final KeyboardController keyboardController;
  private PhysicalController board;
  private Timer timer;
  private ArrayList<Player> players = new ArrayList<Player>();
  private int activePlayerIndex = 0;
  private AbstractPhase currentPhase;
  private int phaseCount = 0;
  private boolean delayedSetNextWorm;
  private ScriptPlayer scriptPlayer;

  public ScriptPlayer getScriptPlayer() {
    return scriptPlayer;
  }

  public TimeController() {
    instance = this;
    keyboardController = createController();
    initGame();
    board.addKeyListener(keyboardController);

    timer = new Timer(Config.getClockDelay(), this);
    timer.start();

    new WormSoundPlayer().playSound("src/resources/Castle_In_The_Sky.mp3");
  }

  private KeyboardController createController() {
    if (Config.getRecordGame()) {
      return new KeyboardControllerRecorder(WormLauncher.getInstance());
    } else if (Config.getPlayRecord()) {
      System.out.println("Creating player ...");
      return KeyboardControllerPlayer.loadFromFile(Config.getScriptFilename());
    } else {
      return new KeyboardController();
    }
  }

  private void initGame() {
    board = new PhysicalController();
    // Lucky luke because for the moment he is a poor lonesome
    // player
    Player luckyLuke = createPlayer("Lucky Luke", Color.RED);

    for (String name : new String[] {"Joly jumper", "rantanplan"}) {
      Worm worm = luckyLuke.createWorm(name);
      board.wormInitialPlacement(worm);
    }

    /*if(Config.getScriptFilename() != null) {
      scriptPlayer = new ScriptPlayer(Config.getScriptFilename());
    }*/

    doSetNextWorm();
  }

  public void setNextWorm() {
    delayedSetNextWorm = true;
  }

  protected void delayedActions() {
    if (delayedSetNextWorm) {
      delayedSetNextWorm = false;
      doSetNextWorm();
    }
  }

  protected void doSetNextWorm() {
    for (int i = 0; i < players.size(); ++i) {
      activePlayerIndex += 1;
      activePlayerIndex %= players.size();
      if (getActivePlayer().hasWorms()) break;
    }

    // No player have any worm, it is sad ...
    if (!getActivePlayer().hasWorms()) {
      return;
    }

    getActivePlayer().setNextWorm();
    getActivePlayer().initWeapon();

    AbstractPhase phase = new WormMovingPhase();
    this.setCurrentPhase(phase);
  }

  private Player createPlayer(String name, Color color) {
    Player player = new Player(name, color);
    players.add(player);

    return player;
  }

  public Component getBoard() {
    return board;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    phaseCount++;
    board.actionPerformed(e);
  }

  public static TimeController getInstance() {
    if (instance == null) {
      instance = new TimeController();
    }
    return instance;
  }

  public AbstractPhase getCurrentPhase() {
    return currentPhase;
  }

  public void setCurrentPhase(AbstractPhase currentPhase) {
    if ((this.currentPhase != null) && this.currentPhase != currentPhase) {
      this.currentPhase.removeSelf();
    }
    this.currentPhase = currentPhase;
  }

  public ArrayList<Player> getPlayers() {
    return players;
  }

  public int getPhaseCount() {
    return phaseCount;
  }

  public void setPhaseCount(int phaseCount) {
    this.phaseCount = phaseCount;
  }

  public Player getActivePlayer() {
    return players.get(activePlayerIndex);
  }
}
