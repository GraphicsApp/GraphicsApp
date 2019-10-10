package de.ur.mi.oop.graphics;

import de.ur.mi.oop.colors.Color;


public class Rectangle extends  GraphicsObject {

    public Rectangle(float x, float y, float width, float height, Color color) {
        super(x,y,color);
        super.setWidth(width);
        setHeight(height);
        this.type = GraphicsObjectType.RECTANGLE;
    }

    public Rectangle(float x, float y, float width, float height) {
        super(x,y);
        setWidth(width);
        setHeight(height);
        this.type = GraphicsObjectType.RECTANGLE;
    }
}
