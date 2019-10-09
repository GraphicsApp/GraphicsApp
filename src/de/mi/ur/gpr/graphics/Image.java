package de.mi.ur.gpr.graphics;

import de.mi.ur.gpr.utils.FileHelper;
import de.mi.ur.gpr.utils.GraphicsHelper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image extends GraphicsObject {

    private BufferedImage image;

    public Image(int x, int y, String filePath) {
        super(x, y);
        this.type = GraphicsObjectType.IMAGE;
        loadImage(filePath);
        setWidth(image.getWidth());
        setHeight(image.getHeight());
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
