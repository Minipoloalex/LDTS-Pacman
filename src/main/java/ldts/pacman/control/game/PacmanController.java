package ldts.pacman.control.game;

import ldts.pacman.Game;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Pacman;

public class PacmanController extends GameController {
    private long lastMovement;
    public enum Direction { NONE, UP, DOWN, LEFT, RIGHT }
    private Direction direction;
    public PacmanController(Arena model) {
        super(model);
        direction = Direction.NONE;
        lastMovement = 0;
    }
    public void movePacman(Position position) {
        if (!getModel().isWall(position)) {
            getModel().getPacman().setPosition(position);
            if (getModel().isMonster(position)) getModel().getPacman().decreaseHealth();
            // getModel().retrieveCoins(position);
            // or retrieve coins from pacmanController? //TODO
            // also keep track of score
            // TODO: (for later) if getModel().isPowerUp() -> ...
        }
    }
    public void movePacmanUp() {
        movePacman(getModel().getPacman().getPosition().getUp());
    }
    public void movePacmanDown() {
        movePacman(getModel().getPacman().getPosition().getDown());
    }
    public void movePacmanLeft() {
        movePacman(getModel().getPacman().getPosition().getLeft());
    }
    public void movePacmanRight() {
        movePacman(getModel().getPacman().getPosition().getRight());
    }
    public void movePacmanInDirection() {
        switch (direction) {
            case UP: movePacmanUp(); break;
            case DOWN: movePacmanDown(); break;
            case LEFT: movePacmanLeft(); break;
            case RIGHT: movePacmanRight(); break;
        }
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public Pacman getPacman() {
        return getModel().getPacman();
    }
    @Override
    public void step(Game game, GUI.OPTION option, long time) {
        switch (option) {
            case UP -> setDirection(Direction.UP);
            case DOWN -> setDirection(Direction.DOWN);
            case LEFT -> setDirection(Direction.LEFT);
            case RIGHT -> setDirection(Direction.RIGHT);
        }

        if (time - lastMovement > 500 && this.direction != Direction.NONE) {
            movePacmanInDirection();
            lastMovement = time;
        }
    }
}
