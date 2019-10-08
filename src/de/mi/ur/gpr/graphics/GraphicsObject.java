package de.mi.ur.gpr.graphics;

import de.mi.ur.gpr.app.GraphicsApp;
import de.mi.ur.gpr.colors.Color;
import de.mi.ur.gpr.colors.Colors;

public abstract class GraphicsObject {


    protected static final Color DEFAULT_COLOR = Colors.RED;

    private float xPos;
    private float yPos;
    private Color color;
    protected GraphicsObjectType type;

    public GraphicsObject(int x, int y) {
        this(x , y, DEFAULT_COLOR);
    }

    public GraphicsObject(int x, int y, Color color) {
        this.xPos = x;
        this.yPos = y;
        this.color = color;
        this.type = GraphicsObjectType.NONE;
        GraphicsApp.getApp().addObject(this);
    }

    public void draw() {
        GraphicsApp.getApp().addToDrawBuffer(this);
    }

    public float getXPos() {
        return xPos;
    }

    public void setXPos(float xPos) {
        this.xPos = xPos;
    }

    public float getYPos() {
        return yPos;
    }

    public void setYPos(float yPos) {
        this.yPos = yPos;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public GraphicsObjectType getType() {
        return type;
    }

    public void move(float dx, float dy) {
        this.xPos += dx;
        this.yPos += dy;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        GraphicsApp.getApp().removeObject(this);
    }
}
