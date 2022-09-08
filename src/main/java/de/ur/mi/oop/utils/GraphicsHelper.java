package de.ur.mi.oop.utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicsHelper {

    public static BufferedImage resizeImage(BufferedImage image, int newWidth, int newHeight) {
        return GraphicsHelper.resizeImage(image, newWidth, newHeight, false);
    }

    public static BufferedImage resizeImage(BufferedImage image, int newWidth, int newHeight, boolean smooth) {
        int scaleHint = smooth ? Image.SCALE_SMOOTH : java.awt.Image.SCALE_DEFAULT;
        java.awt.Image toolkitImage = image.getScaledInstance(newWidth, newHeight, scaleHint);
        BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics g = newImage.getGraphics();
        g.drawImage(toolkitImage, 0, 0, null);
        g.dispose();
        return newImage;
    }
}
