package ldts.packman.gui;

import ldts.packman.model.game.Position;
import ldts.packman.model.game.elements.Coin;
import ldts.packman.model.game.elements.Pacman;
import ldts.packman.model.game.elements.Wall;

import javax.crypto.NullCipher;
import java.io.IOException;

public interface GUI {
    OPTION getNextOption() throws IOException;
    void drawPacman(Position position);
    void drawWall(Position position);
    void drawCoin(Position position);
    void drawText(Position position, String text, String color);
    void drawCharacter(Position position, char ch, String color);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;
    enum OPTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}
