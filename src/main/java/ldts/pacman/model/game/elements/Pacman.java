package ldts.pacman.model.game.elements;

public class Pacman extends Element {
public class Pacman extends MovableElement {
    int health;
    public Pacman(int x, int y) {
        super(x, y);
        this.health = 3;
    }
    public int getHealth() {
        return health;
    }
    public void decreaseHealth() {
        this.health--;
    }
}
