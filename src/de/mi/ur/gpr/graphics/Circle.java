package de.mi.ur.gpr.graphics;

import de.mi.ur.gpr.colors.Color;

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

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

}
