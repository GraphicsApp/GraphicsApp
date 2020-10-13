package de.ur.mi.oop.graphics;

/**
 * Hintergrund-Objekt für die GraphicsApp
 */
public class Background extends Rectangle {

    public Background(int width, int height) {
        super(0, 0, width, height);
        this.type = GraphicsObjectType.BACKGROUND;
    }

}
