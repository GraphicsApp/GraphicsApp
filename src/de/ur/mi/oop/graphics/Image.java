package de.ur.mi.oop.graphics;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.utils.FileHelper;
import de.ur.mi.oop.utils.GraphicsHelper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Die Image-Klasse ist ein grafisches Objekt, das ein Bild anzeigt.
 */
public class Image extends GraphicsObject {

    private BufferedImage image;

    /**
     * Lädt und erstellt ein Bild, das an den Koordinaten x und y positioniert ist, und zwar mit
     * die angegebene Breite und Höhe.
     *
     * @param x        Die x-Position der linken oberen Ecke des Bildes.
     * @param y        Die y-Position der linken oberen Ecke des Bildes.
     * @param filePath Der Dateipfad zum anzuzeigenden Bild
     */
    public Image(float x, float y, String filePath) {
        super(x, y);
        this.type = GraphicsObjectType.IMAGE;
        loadImage(filePath);
        super.setWidth(image.getWidth());
        super.setHeight(image.getHeight());
        rescale();
    }

    /**
     * Liefert das AWT-Image-Objekt zurück
     *
     * @return das AWT-Image-Objekt
     */
    public BufferedImage getImage() {
        return image;
    }

    public int[][] getPixelArray() {
        int[][] pixels = new int[image.getHeight()][image.getWidth()];
        for(int x = 0; x < image.getWidth(); x++) {
            for(int y = 0; y < image.getHeight(); y++) {
                pixels[y][x] = image.getRGB(x,y);
            }
        }
        return pixels;
    }

    public void setPixelArray(int[][] pixels) {
        for(int x = 0; x < image.getWidth(); x++) {
            for(int y = 0; y < image.getHeight(); y++) {
                image.setRGB(x,y,pixels[y][x]);
            }
        }
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
