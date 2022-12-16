package ldts.pacman.application.state;

import ldts.pacman.controller.menu.SaveScoreController;
import ldts.pacman.model.menu.SaveScore;
import ldts.pacman.sound.observer.SoundSelection;
import ldts.pacman.sound.subject.SoundSubject;
import ldts.pacman.view.menu.SaveScoreViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveScoreStateTest {
    private SaveScore saveScore;
    private SaveScoreState saveScoreState;
    @BeforeEach
    public void setUp() {
        this.saveScore = Mockito.mock(SaveScore.class);
        saveScoreState = new SaveScoreState(saveScore);
    }
    @Test
    public void getModel() {
        assertEquals(saveScore, saveScoreState.getModel());
    }
    @Test
    public void getViewer(){
        assertEquals(SaveScoreViewer.class, saveScoreState.getViewer().getClass());
    }
    @Test
    public void getController(){
        assertEquals(SaveScoreController.class, saveScoreState.getController().getClass());
    }
}
