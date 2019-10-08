package de.mi.ur.gpr.graphics;

import de.mi.ur.gpr.utils.FileHelper;
import de.mi.ur.gpr.utils.GraphicsHelper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image extends GraphicsObject {

    private BufferedImage image;
    private int width;
    private int height;

    public Image(int x, int y, String filePath) {
        super(x, y);
        this.type = GraphicsObjectType.IMAGE;
        loadImage(filePath);
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        resacale();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height; resacale();
    }


    private void resacale() {
        image = GraphicsHelper.resizeImage(image, width, height);
    }

    private void loadImage(String filePath) {
        try {
            File file = FileHelper.loadFile(filePath);
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
