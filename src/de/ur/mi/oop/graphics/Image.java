package de.ur.mi.oop.graphics;

import de.ur.mi.oop.utils.FileHelper;
import de.ur.mi.oop.utils.GraphicsHelper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image extends GraphicsObject {

    private BufferedImage image;

    public Image(float x, float y, String filePath) {
        super(x, y);
        this.type = GraphicsObjectType.IMAGE;
        loadImage(filePath);
        super.setWidth(image.getWidth());
        super.setHeight(image.getHeight());
        rescale();
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setWidth(float width) {
        super.setWidth(width);
        rescale();
    }

    public void setHeight(float height) {
        super.setHeight(height);
        rescale();
    }

    private void rescale() {
        image = GraphicsHelper.resizeImage(image, (int) getWidth(), (int) getHeight());
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
