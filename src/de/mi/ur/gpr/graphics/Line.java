package de.mi.ur.gpr.graphics;

import de.mi.ur.gpr.app.GraphicsApp;
import de.mi.ur.gpr.colors.Color;

public class Line extends GraphicsObject {
    private float xEndPoint;
    private float yEndPoint;
    private Color borderColor;

    private float lineWidth;

    public Line(float startX, float startY, float endX, float endY, Color color) {
        super(startX, startY, color);
        this.borderColor = color;
        this.xEndPoint = endX;
        this.yEndPoint = endY;
        this.lineWidth = GraphicsApp.getApp().getConfig().getStrokeWidth();
        this.type = GraphicsObjectType.LINE;
    }

    public Line(float startX, float startY, float endX, float endY, Color color, float lineWidth) {
        this(startX, startY, endX, endY, color);
        this.lineWidth = lineWidth;
    }

    public Line(Point start, Point end, Color color) {
        this(start.getX(), start.getY(), end.getX(), end.getY(), color);
    }

    public Line(Point start, Point end, Color color, float lineWidth) {
        this(start.getX(), start.getY(), end.getX(), end.getY(), color, lineWidth);
    }

    public float getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
    }

    public float getStartpointX() {
        return super.getXPos();
    }

    public float getStartpointY() {
        return super.getYPos();
    }

    public float getEndpointX() {
        return this.xEndPoint;
    }

    public float getEndpointY() {
        return this.yEndPoint;
    }

    public void setStartPoint(float xStartPoint, float yStartPoint) {
        super.setPosition(xStartPoint, yStartPoint);
    }

    public void setStartPoint(Point start) {
        this.setStartPoint(start.getX(), start.getY());
    }

    public void setEndPoint(float xEndPoint, float yEndPoint) {
        this.xEndPoint = xEndPoint;
        this.yEndPoint = yEndPoint;
    }

    public void setEndPoint(Point end) {
        this.setEndPoint(end.getX(), end.getY());
    }

    public void setColor(Color newColor) {
        super.setColor(newColor);
        this.setBorderColor(newColor);
    }

    public void move(float dx, float dy) {
        this.setStartPoint(super.getXPos() + dx, super.getXPos() + dy);
        this.setEndPoint(this.xEndPoint + dx, this.yEndPoint + dy);
    }

    public void setPosition(float x, float y) {
        if (x < super.getXPos()) {
            if (super.getXPos() < this.xEndPoint) {
                this.xEndPoint = x + (this.xEndPoint - super.getXPos());
                super.setXPos(x);
            } else {
                super.setXPos(x + (super.getXPos() - this.xEndPoint));
                this.xEndPoint = x;
            }
        } else if (super.getXPos() < this.xEndPoint) {
            this.xEndPoint = x + (this.xEndPoint - super.getXPos());
            super.setXPos(x);
        } else {
            super.setXPos(x + (super.getXPos() - this.xEndPoint));
            this.xEndPoint = x;
        }

        if (y < super.getYPos()) {
            if (super.getYPos() < this.yEndPoint) {
                this.yEndPoint = y + (this.yEndPoint - super.getYPos());
                super.setYPos(y);
            } else {
                super.setYPos(y + (super.getYPos() - this.yEndPoint));
                this.yEndPoint = y;
            }
        } else if (super.getYPos() < this.yEndPoint) {
            this.yEndPoint = y + (this.yEndPoint - super.getYPos());
            super.setYPos(y);
        } else {
            super.setYPos(y + (super.getYPos() - this.yEndPoint));
            this.yEndPoint = y;
        }

    }

    public void setPosition(Point p) {
        this.setPosition(p.getX(), p.getY());
    }

    public void setStartAndEndPoint(float toStartPointX, float toStartPointY, float toEndPointX, float toEndPointY) {
        this.setStartPoint(toStartPointX, toStartPointY);
        this.setEndPoint(toEndPointX, toEndPointY);
    }

    public double getRightBorder() {
        return Math.max(super.getXPos(), this.xEndPoint);
    }

    public double getLeftBorder() {
        return Math.min(super.getXPos(), this.xEndPoint);
    }

    public double getTopBorder() {
        return Math.min(super.getYPos(), this.yEndPoint);
    }

    public double getBottomBorder() {
        return Math.max(super.getYPos(), this.yEndPoint);
    }

    public void scale(float sx, float sy) {
        this.xEndPoint *= sx;
        this.yEndPoint *= sy;
    }

    public final void scale(float sf) {
        this.scale(sf, sf);
    }
}
