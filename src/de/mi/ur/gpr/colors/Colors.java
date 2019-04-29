package de.mi.ur.gpr.colors;

import java.util.Random;

public class Colors {

    private static final Random rand = new Random();

    public static final Color RED = new Color(255,0,0);
    public static final Color WHITE = new Color(255,255,255);

    public static final Color getRandomColor() {
        int red = (rand.nextInt(256) + 255)/2;
        int green = (rand.nextInt(256) + 255)/2;
        int blue = (rand.nextInt(256) + 255)/2;
        return new Color(red, green, blue);
    }
}
