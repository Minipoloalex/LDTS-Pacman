package ldts.pacman.view;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
