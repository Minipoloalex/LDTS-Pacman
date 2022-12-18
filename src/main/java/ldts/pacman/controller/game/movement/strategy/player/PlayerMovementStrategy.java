package ldts.pacman.controller.game.movement.strategy.player;

import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.MovableElement;
import java.util.List;
import java.util.Map;

public abstract class PlayerMovementStrategy extends MovementStrategy {
    private Map<GUI.OPTION, Position> optionToDirection;

    protected PlayerMovementStrategy(Map<GUI.OPTION, Position> optionToDirection, long timeBetweenMoves) {
        super(timeBetweenMoves);
        this.optionToDirection = optionToDirection;
    }
    public void changeDirection(List<GUI.OPTION> options, MovableElement element) {
        for (GUI.OPTION option : options) {
            if (optionToDirection.containsKey(option)) {
                element.setDirection(optionToDirection.get(option));
            }
        }
    }
    @Override
    public boolean move(MovableElement element, Arena arena, List<GUI.OPTION> options, long time) {
        changeDirection(options, element);
        if (enoughTimeElapsed(time)) {
            setLastMovement(time);
            if (element.getDirection().equals(new Position(0, 0))) return false;
            Position nextPosition = element.getPosition().plus(element.getDirection());
            return movePlayer(element, nextPosition, arena);
        }
        return false;
    }
    private boolean movePlayer(MovableElement element, Position position, Arena arena) {
        if (!arena.isWall(position)) {
            element.setPosition(position);
            return true;
        }
        return false;
    }
}

