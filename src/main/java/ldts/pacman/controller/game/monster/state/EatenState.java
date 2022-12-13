package ldts.pacman.controller.game.monster.state;

import ldts.pacman.controller.game.movement.strategy.EatenStrategy;
import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

public class EatenState extends MonsterState {
    @Override
    protected MovementStrategy createStrategy() {
        return new EatenStrategy();
    }
    @Override
    public String getColor() {
        // TODO: Color and char
        return "#FFFFFF";
    }

    @Override
    protected boolean enoughTimeElapsed(Monster monster, Arena arena, long time) {
        if (monster.getPosition().equals(monster.getInitialPosition())) {
            monster.setState(new ScatterState(monster.getBaseColor()));
        }
        return time - getLastMovement() > 100;  // 0.1 seconds
    }

    @Override
    public void getHit(Monster monster, Arena arena) {}

    @Override
    protected char createDrawingChar() {
        return 0;
    }
}