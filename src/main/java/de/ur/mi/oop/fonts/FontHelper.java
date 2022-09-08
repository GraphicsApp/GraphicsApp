package de.ur.mi.oop.fonts;

import de.ur.mi.oop.app.GraphicsApp;

import java.awt.*;

public class FontHelper {

    public static FontMetrics getFontMetrics(String fontName, int fontSize) {
        Graphics2D context = GraphicsApp.getApp().getAppManager().getGraphicsContext();
        Font actualFont = FontPool.getFont(fontName, Font.PLAIN, fontSize);
        return context.getFontMetrics(actualFont);
    }

}
