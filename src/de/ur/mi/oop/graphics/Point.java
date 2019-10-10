package de.ur.mi.oop.graphics;

public class Point {
    private float x;
    private float y;

    public Point() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getXPos() {
        return this.x;
    }

    public float getYPos() {
        return this.y;
    }

    public Point getPosition() {
        return new Point(this.x, this.y);
    }

    public void setLocation(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void move(float dx, float dy) {
        this.x += dx;
        this.y += dy;
    }

    public void setLocation(Point point) {
        this.x = point.x;
        this.y = point.y;
    }
}
