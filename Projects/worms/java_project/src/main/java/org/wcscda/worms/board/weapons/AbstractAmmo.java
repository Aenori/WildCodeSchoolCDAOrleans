package org.wcscda.worms.board.weapons;

import java.awt.Shape;
import java.awt.geom.Point2D;
import org.wcscda.worms.Helper;
import org.wcscda.worms.board.*;

public abstract class AbstractAmmo implements IMovableHandler {
  private static final int FIRING_WORM_ANTICOLLISION = 20;

  private final int firedPhase;
  private final int explosionRadius;
  private final int explosionDamage;
/* Se eu uso a classe abaixo como um atributo, o que me permite de mudar o tipo do atributo.
Eu nao poderia fazer isso se eu herdasse a classe. */
  private AbstractRectangularBoardElement movable;

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
  // Draw the moving rectangle when shooting
  protected void createMovableRect(int rectWidth, int rectHeight) {
    this.movable =
        new ARBEWIthHandler(
            Helper.getWormX() - rectWidth / 2,
            Helper.getWormY() - rectHeight / 2,
            rectWidth,
            rectHeight,
            this);

  }

  protected int getFiredPhase() {
    return firedPhase;
  }

  protected void setMovable(AbstractRectangularBoardElement movable) {
    this.movable = movable;
  }

  @Override
  public Boolean isColidingWithAdditionnal(Shape s) {
    if ((s == Helper.getActiveWorm().getShape())
        && Helper.getClock() <= firedPhase + FIRING_WORM_ANTICOLLISION) {
      return false;
    }
    return null;
  }

  @Override
  public void colideWith(AbstractBoardElement movable, Point2D prevPosition) {
    System.out.println("I shooted");
    explode();
    Helper.getCurrentWeapon().triggerAmmoExplosion();
  }

  protected void explode() {

    this.movable.removeSelf();
    Helper.getPC()
        .generateExplosion(
                /* GetCenter = bullet position after explosion */
            this.movable.getCenterX(), this.movable.getCenterY(), explosionRadius, explosionDamage);

  }
}
