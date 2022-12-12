package ldts.pacman.controller.game.movement.strategy.target;

import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.MovableElement;

public class EatenStrategy extends TargetStrategy {
    @Override
    protected Position getTarget(MovableElement element, Arena arena) {
        return element.getInitialPosition();
    }
}
