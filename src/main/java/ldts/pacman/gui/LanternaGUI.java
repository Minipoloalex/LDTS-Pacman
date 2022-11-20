package ldts.pacman.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import ldts.pacman.model.game.Position;

import java.io.IOException;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(Screen screen) {this.screen = screen;}

    public LanternaGUI(int width, int height) throws IOException{
        Terminal terminal = createTerminal(width, height);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException{
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }
    private Terminal createTerminal(int width, int height) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    @Override
    public OPTION getNextOption() throws IOException {
        KeyStroke keyStroke = screen.readInput();
        if (keyStroke == null) return OPTION.NONE;
        KeyType keyType = keyStroke.getKeyType();
        if (keyType == KeyType.EOF) return OPTION.QUIT;
        if (keyType == KeyType.ArrowUp) return OPTION.UP;
        if (keyType == KeyType.ArrowDown) return OPTION.DOWN;
        if (keyType == KeyType.ArrowLeft) return OPTION.LEFT;
        if (keyType == KeyType.ArrowRight) return OPTION.RIGHT;
        if (keyType == KeyType.Enter) return OPTION.SELECT;
        return OPTION.NONE;
    }

    @Override
    public void drawPacman(Position position){
        drawCharacter(position,'@', "#FFFFFF");
    }
    @Override
    public void drawWall(Position position){
        drawCharacter(position,'|', "#FFFFFF");
    }
    @Override
    public void drawCoin(Position position){
        drawCharacter(position,'o', "#d4af37");
    }

    @Override
    public void drawText(Position position, String text, String color){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.putString(position.getX(), position.getY(), text);
    }

    @Override
    public void drawCharacter(Position position, char ch, String color){
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.putString(position.getX(), position.getY(), "" + ch);
    }

    @Override
    public void clear(){
        screen.clear();
    }

    @Override
    public void refresh() throws IOException{
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}
