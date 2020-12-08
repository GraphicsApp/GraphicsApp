package de.ur.mi.oop.utils;

import de.ur.mi.oop.app.GraphicsApp;

import java.awt.*;

public class FontHelper {

    public static FontMetrics getFontMetrics(String fontName, int fontSize) {
        Graphics2D context = GraphicsApp.getApp().getAppManager().getGraphicsContext();
        Font actualFont = new Font(fontName, Font.PLAIN, fontSize);
        return context.getFontMetrics(actualFont);
    }

}
