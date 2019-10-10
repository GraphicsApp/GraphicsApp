package de.ur.mi.oop.graphics;

import de.ur.mi.oop.colors.Color;

public class Arc extends GraphicsObject {

    private float radius;
    private float start;
    private float end;

    public Arc(float x, float y, float radius, float start, float end, Color color) {
        super(x,y, color);
        this.radius = radius;
        this.start = start;
        this.end = end;
        this.type = GraphicsObjectType.ARC;
    }

    public Arc(float x, float y, float radius) {
        super(x,y);
        this.radius = radius;
        this.start = 0;
        this.end = 360;
        this.type = GraphicsObjectType.ARC;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

    public float getStart() {
        return start;
    }

    public void setStart(float start) {
        this.start = start;
    }

    public float getEnd() {
        return end;
    }

    public void setEnd(float end) {
        this.end = end;
    }
}
