package de.ur.mi.oop.graphics;

import de.ur.mi.oop.colors.Color;

/**
 * Die Arc-Klasse ist ein grafisches Objekt, das einen Kreisbogen darstellt.
 */
public class Arc extends GraphicsObject {

    private float radius;
    private float start;
    private float end;

    /**
     * Konstruiert einen Kreisbogen an der Stelle (x, y)
     *
     * @param x      Die x-Koordinate des Mittelpunkts
     * @param y      Die y-Koordinate des Mittelpunkts
     * @param radius Der Radius des Bogens
     * @param start  Der Startwinkel des Bogens in Grad.
     * @param end    Die Winkelausdehnung des Bogens in Grad.
     * @param color  Die Füllfarbe des Bogens
     */
    public Arc(float x, float y, float radius, float start, float end, Color color, boolean open) {
        super(x, y, color);
        this.radius = radius;
        this.start = start;
        this.end = end;
        if(open) {
            this.type = GraphicsObjectType.ARC;
        } else {
            this.type = GraphicsObjectType.PIE_ARC;
        }
    }

    /**
     * Konstruiert einen vollständigen Kreisbogen an der Stelle (x, y)
     *
     * @param x      x-Koordinate des Mittelpunkts
     * @param y      y-Koordinate des Mittelpunkts
     * @param radius der Radius des Bogens
     */
    public Arc(float x, float y, float radius, boolean open) {
        super(x, y);
        this.radius = radius;
        this.start = 0;
        this.end = 360;
        if(open) {
            this.type = GraphicsObjectType.ARC;
        } else {
            this.type = GraphicsObjectType.PIE_ARC;
        }
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

    /**
     * Liefert den Startwinkel des Bogens in Grad.
     *
     * @return Startwinkel des Bogens in Grad
     */
    public float getStart() {
        return start;
    }

    /**
     * Setzt den Startwinkel des Bogens in Grad.
     *
     * @param start Der Startwinkel des Bogens in Grad.
     */
    public void setStart(float start) {
        this.start = start;
    }

    /**
     * Liefer die Winkelausdehnung des Bogens in Grad.
     *
     * @return die Winkelausdehnung des Bogens in Grad
     */
    public float getEnd() {
        return end;
    }

    /**
     * Setzt die Winkelausdehnung des Bogens in Grad.
     *
     * @param end Die Winkelausdehnung des Bogens in Grad.
     */
    public void setEnd(float end) {
        this.end = end;
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
}
