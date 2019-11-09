package de.ur.mi.oop.graphics;

import de.ur.mi.oop.colors.Color;

/**
 * Die Rectangle-Klasse ist ein grafisches Objekt, das ein Rechteck darstellt.
 */
public class Rectangle extends GraphicsObject {

    /**
     * Konstruiert ein neues Rechteck mit der angegebenen Breite, Höhe, und Farbe,
     * das an den Koordinaten x und y positioniert ist.
     *
     * @param x      Die x-Position der linken oberen Ecke des Rechtecks.
     * @param y      Die y-Position der linken oberen Ecke des Rechtecks.
     * @param width  Die Breite des Rechtecks in Pixel
     * @param height Die Höhe des Rechtecks in Pixel
     * @param color  Die Hintergrundfarbe für das Rechteck
     */
    public Rectangle(float x, float y, float width, float height, Color color) {
        super(x, y, color);
        super.setWidth(width);
        setHeight(height);
        this.type = GraphicsObjectType.RECTANGLE;
    }

    /**
     * Konstruiert ein neues Rechteck mit der angegebenen Breite, Höhe,
     * das an den Koordinaten x und y positioniert ist.
     *
     * @param x      Die x-Position der linken oberen Ecke des Rechtecks.
     * @param y      Die y-Position der linken oberen Ecke des Rechtecks.
     * @param width  Die Breite des Rechtecks in Pixel
     * @param height Die Höhe des Rechtecks in Pixel
     */
    public Rectangle(float x, float y, float width, float height) {
        super(x, y);
        setWidth(width);
        setHeight(height);
        this.type = GraphicsObjectType.RECTANGLE;
    }
}
