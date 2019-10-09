package de.ur.mi.oop.colors;

public class Color {

    private final int red;
    private final int green;
    private final int blue;
    private final int alpha;

    private java.awt.Color awtColor;

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = 255;
    }

    public Color(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public int red() {
        return red;
    }

    public int green() {
        return green;
    }

    public int blue() {
        return blue;
    }

    public int alpha() { return alpha; }

    public java.awt.Color asAWTColor() {
        if(awtColor == null) {
            awtColor = new java.awt.Color(red, green, blue, alpha);
        }
        return awtColor;
    }

}
