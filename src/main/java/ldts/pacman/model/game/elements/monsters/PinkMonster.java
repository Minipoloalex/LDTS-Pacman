package ldts.pacman.model.game.elements.monsters;
import ldts.pacman.controller.game.monster.state.MonsterState;
import ldts.pacman.controller.game.monster.state.ScatterState;
import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.controller.game.movement.strategy.RandomStrategy;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

public class PinkMonster extends Monster {
    public PinkMonster(int x, int y) {
        super(x, y, new Position(2, 16));
    }
    @Override
    protected MonsterState createMonsterState() {
        return new ScatterState(getBaseColor());
    }
    @Override
    public String getBaseColor() {
        return "#ea82e5";
    }
}
