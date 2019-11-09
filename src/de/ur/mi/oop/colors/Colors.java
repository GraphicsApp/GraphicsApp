package de.ur.mi.oop.colors;

import java.util.Random;

/**
 * Eine Sammlung von vordefinierten GraphicsApp-Colors.
 */
public class Colors {

    private static final Random rand = new Random();

    public static final Color RED = new Color(255, 0, 0);
    public static final Color ORANGE = new Color(255, 153, 0);
    public static final Color YELLOW = new Color(255, 255, 0);
    public static final Color GREEN = new Color(51, 204, 51);
    public static final Color BLUE = new Color(0, 102, 255);
    public static final Color PURPLE = new Color(204, 51, 255);
    public static final Color PINK = new Color(255, 102, 153);
    public static final Color BROWN = new Color(204, 102, 0);
    public static final Color WHITE = new Color(255, 255, 255);
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color GREY = new Color(100, 100, 100);
    public static final Color TRANSPARENT = new Color(255, 255, 255, 0);

    /**
     * Erzeugt eine zufällige, opake Farbe.
     *
     * @return Ein Color-Objekt, das mit zufälligen Rot-, Grün- und Blauwerten instantiiert wurde.
     */
    public static final Color getRandomColor() {
        int red = (rand.nextInt(256) + 255) / 2;
        int green = (rand.nextInt(256) + 255) / 2;
        int blue = (rand.nextInt(256) + 255) / 2;
        return new Color(red, green, blue);
    }
}
