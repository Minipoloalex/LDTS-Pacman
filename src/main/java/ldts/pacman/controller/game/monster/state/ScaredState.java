package ldts.pacman.controller.game.monster.state;

import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.controller.game.movement.strategy.ScaredStrategy;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.Pacman;

import static java.lang.Math.pow;

public class ScaredState extends MonsterState {
    @Override
    protected MovementStrategy createStrategy() {
        return new ScaredStrategy();
    }
    @Override
    protected boolean enoughTimeElapsed(Monster monster, Arena arena, long time) {
        if (time - getStateStartTime() > pow (10, 4)) { // 10 seconds
            monster.setState(new ScatterState(monster.getBaseColor()));
            return false;
        }
        return time - getLastMovement() > 500;  // 0.5 seconds
    }

    @Override
    public void getHit(Monster monster, Arena arena) {
        Pacman pacman = arena.getPacman();
        pacman.setScore(pacman.getScore() + 20);
        monster.setState(new EatenState());
    }
    @Override
    public String getColor() {
        // TODO: Color and char
        return "#46bfee";
    }

    @Override
    protected char createDrawingChar() {
        return 'b';
    }
}