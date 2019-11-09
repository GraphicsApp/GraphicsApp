package de.ur.mi.oop.graphics;

import de.ur.mi.oop.colors.Color;

/**
 * Die Circle-Klasse ist ein grafisches Objekt, das einen Kreis darstellt.
 */
public class Circle extends GraphicsObject {

    private float radius;

    /**
     * Konstruiert einen neuen Kreis mit dem angegebenen Radius, deren
     * Mittelpunkt an den Koordinaten x und y positioniert ist.
     *
     * @param x      Die x-Position der Ellipse in Pixel
     * @param y      Die y-Position der Ellipse in Pixel
     * @param radius Der Radius des Kreises in Pixel
     * @param color  Die Füllfarbe für den Kreis
     */
    public Circle(float x, float y, float radius, Color color) {
        super(x, y, color);
        this.radius = radius;
        this.type = GraphicsObjectType.CIRCLE;
    }

    /**
     * Konstruiert einen neuen Kreis mit dem angegebenen Radius, deren
     * Mittelpunkt an den Koordinaten x und y positioniert ist.
     *
     * @param x      Die x-Position der Ellipse in Pixel
     * @param y      y
     *               Die y-Position der Ellipse in Pixel
     * @param radius Der Radius des Kreises in Pixel
     */
    public Circle(float x, float y, float radius) {
        super(x, y);
        this.radius = radius;
        this.type = GraphicsObjectType.CIRCLE;
    }

    /**
     * Konstruiert einen neuen Kreis mit dem angegebenen Radius, deren
     * Mittelpunkt an den Koordinaten positioniert ist, die durch einen Point gegeben sind.
     *
     * @param position Koordinaten des Mittelpunkts
     * @param radius   Der Radius des Kreises in Pixel
     */
    public Circle(Point position, float radius) {
        this(position.getXPos(), position.getYPos(), radius);
    }

    /**
     * Konstruiert einen neuen Kreis mit dem angegebenen Radius, deren
     * Mittelpunkt an den Koordinaten positioniert ist, die durch einen Point gegeben sind.
     *
     * @param position Koordinaten des Mittelpunkts
     * @param radius   Der Radius des Kreises in Pixel
     * @param color    Die Füllfarbe für den Kreis
     */
    public Circle(Point position, float radius, Color color) {
        this(position.getXPos(), position.getYPos(), radius, color);
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

    public float getWidth() {
        return this.radius * 2.f;
    }

    public float getHeight() {
        return this.radius * 2.f;
    }

    public void setWidth(float width) {
        setRadius(0.5f * width);
    }

    public void setHeight(float height) {
        setRadius(0.5f * height);
    }

    public float getRightBorder() {
        return this.radius + getXPos();
    }

    public float getLeftBorder() {
        return getXPos() - this.radius;
    }

    public float getTopBorder() {
        return getYPos() - this.radius;
    }

    public float getBottomBorder() {
        return getYPos() + this.radius;
    }
}
