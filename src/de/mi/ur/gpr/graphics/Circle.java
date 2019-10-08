package de.mi.ur.gpr.graphics;

import de.mi.ur.gpr.colors.Color;

public class Circle extends GraphicsObject {

    private int radius;

    public Circle(int x, int y, int radius, Color color) {
        super(x,y, color);
        this.radius = radius;
        this.type = GraphicsObjectType.CIRCLE;
    }

    public Circle(int x, int y, int radius) {
        super(x,y);
        this.radius = radius;
        this.type = GraphicsObjectType.CIRCLE;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

}
