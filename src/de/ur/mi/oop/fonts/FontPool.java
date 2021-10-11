package de.ur.mi.oop.fonts;

import java.awt.*;
import java.util.HashMap;


public class FontPool {

    private static final HashMap<String, Font> pool = new HashMap<>();

    public static Font getFont(String name, int style, int size) {
        String key = name.concat(String.valueOf(style)).concat(String.valueOf(size));
        Font font = pool.get(key);
        if(font == null) {
            font = new Font(name, style, size);
            pool.put(key, font);
        }
        return font;
    }
}
