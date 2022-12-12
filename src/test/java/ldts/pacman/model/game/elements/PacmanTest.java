package ldts.pacman.model.game.elements;

import ldts.pacman.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacmanTest {
    private Pacman pacman;
    @BeforeEach
    public void setUp() {
        this.pacman = new Pacman(5, 3);
    }
    @Test
    public void testSetScore(){
        pacman.setScore(10);
        assertEquals(10,pacman.getScore());
    }
    @Test
    public void testGetPosition() {
        assertEquals(new Position(5, 3), pacman.getPosition());

        pacman.setPosition(new Position(0, -1));
        assertEquals(new Position(0, -1), pacman.getPosition());
    }
    @Test
    public void testIncreaseScore() {
        int score = pacman.getScore();
        pacman.increaseScore();
        assertEquals(score + 1, pacman.getScore());
    }
    @Test
    public void testDecreaseHealth() {
        int health = pacman.getHealth();
        pacman.decreaseHealth();
        assertEquals(health - 1, pacman.getHealth());
    }
}
