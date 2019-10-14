    package de.ur.mi.oop.graphics;

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;

public abstract class GraphicsObject {

    ///////////////////////////////////////////////////////////////////////////
    // Members and constants
    ///////////////////////////////////////////////////////////////////////////

    protected static final Color DEFAULT_COLOR = Colors.RED;
    protected static final Color DEFAULT_BORDER_COLOR = Colors.BLACK;

    private float xPos;
    private float yPos;

    private float width;
    private float height;

    private Color color;
    private Color strokeColor;
    protected float strokeWeight;

    protected GraphicsObjectType type;

    ///////////////////////////////////////////////////////////////////////////
    // Constructors
    ///////////////////////////////////////////////////////////////////////////

    public GraphicsObject(float x, float y, Color color) {
        this.xPos = x;
        this.yPos = y;
        this.width = 0;
        this.height = 0;
        this.color = color;
        this.strokeWeight = 0;
        this.strokeColor = DEFAULT_BORDER_COLOR;
        this.type = GraphicsObjectType.NONE;
        GraphicsApp.getApp().addObject(this);
    }

    public GraphicsObject(float x, float y) {
        this(x , y, GraphicsApp.getApp().getConfig().getDefaultColor());
    }

    public GraphicsObject(float x, float y, float width, float height, Color color) {
        this(x, y, color);
        this.width = width;
        this.height = height;
    }

    public GraphicsObject(float x, float y, float width, float height, Color color, Color borderColor) {
        this(x, y, width, height, color);
        this.strokeColor = borderColor;
    }

    public GraphicsObject(Point point) {
        this(point.getXPos(), point.getYPos());
    }

    ///////////////////////////////////////////////////////////////////////////
    // Drawing
    ///////////////////////////////////////////////////////////////////////////

    public void draw() {
        GraphicsApp.getApp().addToDrawBuffer(this);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Getters and Setters
    ///////////////////////////////////////////////////////////////////////////

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

    public void setPosition(float xPos, float yPos) {
        setXPos(xPos);
        setYPos(yPos);
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getTopBorder() {
        return this.getYPos();
    }

    public float getBottomBorder() {
        return this.getYPos() + this.getHeight();
    }

    public float getLeftBorder() {
        return this.getXPos();
    }

    public float getRightBorder() {
        return this.getXPos() + this.getWidth();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setBorderColor(Color color) {
        this.strokeColor = color;
    }

    public void setBorderWeight(float weight) {
        this.strokeWeight = weight;
    }

    public void setBorder(Color color, float weight) {
        this.setBorderColor(color);
        this.setBorderWeight(weight);
    }

    public float getBorderWeight() {
        return this.strokeWeight;
    }

    public Color getBorderColor() {
        return this.strokeColor;
    }

    public GraphicsObjectType getType() {
        return type;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Utility Methods
    ///////////////////////////////////////////////////////////////////////////

    public void move(float dx, float dy) {
        this.xPos += dx;
        this.yPos += dy;
    }

    public boolean hitTest(float x, float y) {
        return x >= this.getLeftBorder() && x <= this.getRightBorder() && y >= this.getTopBorder() && y <= this.getBottomBorder();
    }

    public double distanceTo(GraphicsObject object) {
        double dx = object.getXPos() - this.getXPos();
        double dy = object.getYPos() - this.getYPos();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        GraphicsApp.getApp().removeObject(this);
    }
}
