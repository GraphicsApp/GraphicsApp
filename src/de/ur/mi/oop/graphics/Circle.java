package de.ur.mi.oop.graphics;

import de.ur.mi.oop.colors.Color;

public class Circle extends GraphicsObject {

    private float radius;

    public Circle(float x, float y, float radius, Color color) {
        super(x,y, color);
        this.radius = radius;
        this.type = GraphicsObjectType.CIRCLE;
    }

    public Circle(float x, float y, float radius) {
        super(x,y);
        this.radius = radius;
        this.type = GraphicsObjectType.CIRCLE;
    }

    public Circle(Point position, float radius) {
        this(position.getXPos(), position.getYPos(), radius);
    }

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
