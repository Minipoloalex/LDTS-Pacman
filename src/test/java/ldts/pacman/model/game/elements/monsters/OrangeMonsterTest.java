package ldts.pacman.model.game.elements.monsters;

import ldts.pacman.controller.game.movement.strategy.RandomStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrangeMonsterTest {
    private OrangeMonster orangeMonster;
    @BeforeEach
    public void setUp() {orangeMonster = new OrangeMonster(1, 6);}

    @Test
    public void testOrangeMonsterMovementStrategy() {
        assertTrue(orangeMonster.getMovementStrategy(null) instanceof RandomStrategy);
    }
    @Test
    public void testOrangeMonsterPosition() {
        assertEquals(1, orangeMonster.getPosition().getX());
        assertEquals(6, orangeMonster.getPosition().getY());
        assertNotEquals(6, orangeMonster.getPosition().getX());
        assertNotEquals(9, orangeMonster.getPosition().getY());
    }
    @Test
    public void testOrangeMonsterColor(){
        assertEquals("#db851c", orangeMonster.getColor());
        assertNotEquals("#000000", orangeMonster.getColor());
    }
}
