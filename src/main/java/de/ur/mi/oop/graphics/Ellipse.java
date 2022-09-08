package de.ur.mi.oop.graphics;

import de.ur.mi.oop.colors.Color;

/**
 * Die Ellipse-Klasse ist ein grafisches Objekt, das eine Ellipse darstellt.
 */
public class Ellipse extends GraphicsObject {

    private float radiusX;
    private float radiusY;

    /**
     * Konstruiert eine neue Ellipse mit dem angegebenen vertikalen und horizontalen Radius, deren
     * Mittelpunkt an den Koordinaten x und y positioniert ist.
     *
     * @param x       Die x-Position der Ellipse in Pixel
     * @param y       Die y-Position der Ellipse in Pixel
     * @param radiusX Der horizontale Radius der Ellipse in Pixel
     * @param radiusY Der vertikale Radius der Ellipse in Pixel
     * @param color   Die Füllfarbe für die Ellipse
     */
    public Ellipse(float x, float y, float radiusX, float radiusY, Color color) {
        super(x, y, color);
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        this.type = GraphicsObjectType.ELLIPSE;
    }

    /**
     * Konstruiert eine neue Ellipse mit dem angegebenen vertikalen und horizontalen Radius, deren
     * Mittelpunkt an den Koordinaten x und y positioniert ist und mit einer
     * Default-Farbe gefärbt ist.
     *
     * @param x       Die x-Position der Ellipse in Pixel
     * @param y       y
     *                Die y-Position der Ellipse in Pixel
     * @param radiusX Der horizontale Radius der Ellipse in Pixel
     * @param radiusY Der vertikale Radius der Ellipse in Pixel
     */
    public Ellipse(float x, float y, float radiusX, float radiusY) {
        super(x, y);
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        this.type = GraphicsObjectType.ELLIPSE;
    }

    public void setRadiusX(float radiusX) {
        this.radiusX = radiusX;
    }

    public void setRadiusY(float radiusY) {
        this.radiusY = radiusY;
    }

    public float getRadiusX() {
        return radiusX;
    }

    public float getRadiusY() {
        return radiusY;
    }

    public float getWidth() {
        return this.radiusX * 2.f;
    }

    public float getHeight() {
        return this.radiusY * 2.f;
    }

    public void setWidth(float width) {
        setRadiusX(0.5f * width);
    }

    public void setHeight(float height) {
        setRadiusY(0.5f * height);
    }

    public float getRightBorder() {
        return this.radiusX + getXPos();
    }

    public float getLeftBorder() {
        return getXPos() - this.radiusX;
    }

    public float getTopBorder() {
        return getYPos() - this.radiusY;
    }

    public float getBottomBorder() {
        return getYPos() + this.radiusY;
    }
}
