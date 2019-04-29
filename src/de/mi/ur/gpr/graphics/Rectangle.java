package de.mi.ur.gpr.graphics;

import de.mi.ur.gpr.colors.Color;


public class Rectangle extends  GraphicsObject {

    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x,y,color);
        this.width = width;
        this.height = height;
        this.type = GraphicsObjectType.RECTANGLE;
    }

    public Rectangle(int x, int y, int width, int height) {
        super(x,y);
        this.width = width;
        this.height = height;
        this.type = GraphicsObjectType.RECTANGLE;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
