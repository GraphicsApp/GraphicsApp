package de.ur.mi.oop.graphics;

/**
 * Die Punktklasse repräsentiert einen Punkt auf der Zeichenfläche.
 */
public class Point {
    private float x;
    private float y;

    /**
     * Erzeugt einen neuen Point bei (0, 0).
     */
    public Point() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    /**
     * Erzeugt einen neuen Point bei (x, y).
     *
     * @param x die x-Koordinate des Punktes
     * @param y die y-Koordinate des Punktes
     */
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getXPos() {
        return this.x;
    }

    public float getYPos() {
        return this.y;
    }

    public Point getPosition() {
        return new Point(this.x, this.y);
    }

    /**
     * Setzt die Position des Punktes auf die angegebene Position.
     *
     * @param x Die x-Position des Punktes
     * @param y y
     *          Die y-Position des Punktes
     */
    public void setLocation(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Bewegt den Punkt auf dem Bildschirm mit den Verschiebungen dx und dy.
     *
     * @param dx Die horizontale Änderung der Position
     * @param dy Die vertikale Änderung der Position
     */
    public void move(float dx, float dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * Setzt die Position des Punktes auf die Position eines neuen Punktobjekts.
     *
     * @param point Der Punkt, der die neuen Positionsinformationen enthält.
     */
    public void setLocation(Point point) {
        this.x = point.x;
        this.y = point.y;
    }
}
