package ldts.pacman.controller.game.monster.state;

import ldts.pacman.controller.game.movement.strategy.ChasePacmanStrategy;
import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.controller.game.movement.strategy.TargetStrategy;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

import static java.lang.Math.pow;

public class ChaseState extends MonsterState {
    // needs color in constructor
    private final String color;
    public ChaseState(String color) {
        this.color = color;
    }
    @Override
    protected MovementStrategy createStrategy() {
        return new ChasePacmanStrategy();
    }
    @Override
    public String getColor() {
        return this.color;
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
        arena.resetPositions();
        arena.getPacman().decreaseHealth();
        for (Monster monsterInArena: arena.getMonsters()) {
            monsterInArena.setState(new ScatterState(monsterInArena.getBaseColor()));
        }
    }

    @Override
    protected char createDrawingChar() {
        return 0;
    }
}