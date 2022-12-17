package ldts.pacman.model.menu;

import ldts.pacman.sound.observer.SoundSelection;
import ldts.pacman.sound.subject.SoundSubject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveScoreTest {
    private SaveScore saveScore;
    @BeforeEach
    public void setUp() {
        this.saveScore = new SaveScore(100);
    }
    @Test
    public void getters() {

        int expectedSizeOfTimeStamp = 5;

        assertEquals(100, saveScore.getScore());
        assertEquals(expectedSizeOfTimeStamp, saveScore.getTimeStamp().length());
    }
}
