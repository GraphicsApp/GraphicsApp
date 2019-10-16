package de.ur.mi.oop.graphics;

import de.ur.mi.oop.colors.Color;

public class Ellipse extends GraphicsObject {

    private float radiusX;
    private float radiusY;

    public Ellipse(float x, float y, float radiusX, float radiusY, Color color) {
        super(x,y, color);
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        this.type = GraphicsObjectType.ELLIPSE;
    }

    public Ellipse(float x, float y, float radiusX, float radiusY) {
        super(x,y);
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

}
