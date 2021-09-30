package org.wcscda.worms.gamemechanism;

import java.awt.Color;
import java.awt.Component;
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

public class TimeController implements ActionListener {
  private static TimeController instance;
  private PhysicalController board;
  private Timer timer;
  private ArrayList<Player> players = new ArrayList<Player>();
  private int activePlayerIndex = 0;
  private AbstractPhase currentPhase;
  private int phaseCount = 0;

  public TimeController() {
    instance = this;
    initGame();

    board.addKeyListener(new KeyboardController());

    timer = new Timer(Config.getClockDelay(), this);
    timer.start();
  }

  private void initGame() {
    board = new PhysicalController();
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
    
    Color color[] = {Color.RED, Color.blue, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN};
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

    setNextWorm();
  }

  public void setLooserAndWinner() {

	    int nbLooser = 0;
		for (int i = 0; i < Helper.getTC().getPlayers().size(); i++) {

			if ((Helper.getActivePlayer().getWorms().size() > 0) && (Helper.getTC().getPlayers().get(i).getWorms().size() < 1)) {
				System.out.println(" l'équipe " + Helper.getTC().getPlayers().get(i).getName() + " à perdu");
				nbLooser++;
				if (nbLooser == players.size()-1) {
					System.out.println(" l'équipe " + Helper.getActivePlayer().getName() + " à gagné");
				}
			}
		}
  }
  
  public void setNextWorm() {

	setLooserAndWinner();
    activePlayerIndex += 1;
    activePlayerIndex %= players.size();
    
    
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
    boolean inGame = board.actionPerformed(e);

    if (!inGame) {
      timer.stop();
    }
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
