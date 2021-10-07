package org.wcscda.worms.gamemechanism;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Map.Entry;

import javax.swing.Timer;
import org.wcscda.worms.Config;
import org.wcscda.worms.Helper;
import org.wcscda.worms.Player;
import org.wcscda.worms.Worm;
import org.wcscda.worms.gamemechanism.phases.AbstractPhase;
import org.wcscda.worms.gamemechanism.phases.WormMovingPhase;
import org.wcscda.worms.gamemechanism.playerrecorder.KeyboardControllerPlayer;
import org.wcscda.worms.gamemechanism.playerrecorder.KeyboardControllerRecorder;

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
    initGame();
    keyboardController = createController();
    board.addKeyListener(keyboardController);

    timer = new Timer(Config.getClockDelay(), this);
    timer.start();
  }

  private KeyboardController createController() {
    if (Config.getRecordGame()) {
      return new KeyboardControllerRecorder(this.board);
    } else if (Config.getPlayRecord()) {
      return new KeyboardControllerPlayer();
    } else {
      return new KeyboardController();
    }
  }

  private void initGame() {
		board = new PhysicalController();
		createPlayersAndWorms();
		isBeginer();
		doSetNextWorm();
		new Scores();
	}

	public void createPlayersAndWorms() {
		//Création des equipes et des worms qui leur appartient
		Map<String, String[]> playerAndWorms = new HashMap<>();
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Nombre de joueur ? ");
		int nbPlayer = scan1.nextInt();
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Nombre de worms ? ");
		int nbWorms = scan2.nextInt();

		for(int i = 0; i < nbPlayer; i++) {
			Scanner scan3 = new Scanner(System.in);
			System.out.println("Nom du joueur "+(i+1)+" : ");
			String namePlayer = scan3.nextLine();
			System.out.println("Le joueur "+(i+1)+" est "+namePlayer);
			playerAndWorms.put(namePlayer, new String[nbWorms]);
			for(int j = 0; j < nbWorms;j++) {
				Scanner scan4 = new Scanner(System.in);
				System.out.println("Nom du worms "+(1+j)+" : ");
				playerAndWorms.get(namePlayer)[j] = scan4.nextLine();
			}
		}


		Color color[] = {Color.RED, Color.blue, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.PINK};

		//Color color[] = {Color.RED, Color.blue, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN};

		int colorIndex = 0;
		for (Entry<String, String[]> player : playerAndWorms.entrySet()) {        //parcourir map [player] et ensuite [player][worms]
			String joueurMap = player.getKey();										//clef de la map
			String[] worms = player.getValue();										//tableau de valeur de la map
			Player joueur = createPlayer(joueurMap, color[colorIndex]);						//creation de l'equipe
			colorIndex++;
			for (String nomWorm : worms) {												// valeur des clefs de la map
				Worm worm = joueur.createWorm(nomWorm);								//ajout des worms
				board.wormInitialPlacement(worm);
			}
		}
	}


	public void isBeginer() {
		for (int i = 0; i < players.size(); i++) {
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Le joueur "+players.get(i).getName()+" est il débutant ? (oui/non) : ");
			String beginer = scan1.nextLine();
			if(beginer.equals("oui")) {
				players.get(i).setBeginer(true);
			}
		}
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
	new Inventory();
	Helper.getActivePlayer().setInventory(true);
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
