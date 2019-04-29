package de.mi.ur.gpr.colors;

public class Color {

    private final int red;
    private final int green;
    private final int blue;

    private java.awt.Color awtColor;

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
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

    public java.awt.Color asAWTColor() {
        if(awtColor == null) {
            awtColor = new java.awt.Color(red, green, blue);
        }
        return awtColor;
    }

}
