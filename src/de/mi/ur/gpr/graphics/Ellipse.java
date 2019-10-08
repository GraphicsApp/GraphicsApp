package de.mi.ur.gpr.graphics;

import de.mi.ur.gpr.colors.Color;

public class Ellipse extends GraphicsObject {

    private int radiusX;
    private int radiusY;

    public Ellipse(int x, int y, int radiusX, int radiusY, Color color) {
        super(x,y, color);
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        this.type = GraphicsObjectType.ELLIPSE;
    }

    public Ellipse(int x, int y, int radiusX, int radiusY) {
        super(x,y);
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        this.type = GraphicsObjectType.ELLIPSE;
    }

    public void setRadiusX(int radiusX) {
        this.radiusX = radiusX;
    }

    public void setRadiusY(int radiusY) {
        this.radiusY = radiusY;
    }

    public int getRadiusX() {
        return radiusX;
    }

    public int getRadiusY() {
        return radiusY;
    }

}
