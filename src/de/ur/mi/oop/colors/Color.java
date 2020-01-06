package de.ur.mi.oop.colors;


/**
 * Repräsentiert eine RGB-Farbe. Instanzen dieser Klasse können an GraphicsObjects übergeben werden,
 * um diese einzufärben.
 */
public class Color {

    private final int red;
    private final int green;
    private final int blue;
    private final int alpha;

    private java.awt.Color awtColor;

    /**
     * Erstellt eine neue Color-Instanz aus den angegebenen RGB-Werten.
     *
     * @param red   der Rotwert der neuen Farbe (0-255)
     * @param green der Grünwert der neuen Farbe (0-255)
     * @param blue  der Blauwert der neuen Farbe (0-255)
     */
    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = 255;
    }

    /**
     * Erstellt eine neue Color-Instanz aus den angegebenen RGB-Werten.
     *
     * @param red   der Rotwert der neuen Farbe (0-255)
     * @param green der Grünwert der neuen Farbe (0-255)
     * @param blue  der Blauwert der neuen Farbe (0-255)
     * @param alpha der Transparenzwert der neuen Farbe (0-255)
     */
    public Color(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    /**
     * Erstellt eine neue Color-Instanz aus den angegebenen RGB-Wert im Binärformat.
     *
     * @param rgb   der Farbwert (RGB) im Binärformat
     */
    public Color (int rgb) {
        java.awt.Color color = new java.awt.Color(rgb);
        this.red = color.getRed();
        this.green = color.getGreen();
        this.blue = color.getBlue();
        this.alpha = color.getAlpha();
    }

    /**
     * Gibt den Rotwert zurück
     *
     * @return Rotwert (0-255)
     */
    public int red() {
        return red;
    }

    /**
     * Gibt den Grünwert zurück
     *
     * @return Grünwert (0-255)
     */
    public int green() {
        return green;
    }

    /**
     * Gibt den Blauwert zurück
     *
     * @return Blauwert (0-255)
     */
    public int blue() {
        return blue;
    }

    /**
     * Gibt den Transparenzwert zurück
     *
     * @return Transparenzwert (0-255)
     */
    public int alpha() {
        return alpha;
    }


    /**
     * Gibt die Farbe als RGB-Wert im Binärformat zurück.
     *
     * @return Farbwert (RGB) im Binärformat
     */
    public int toInt() {
        java.awt.Color color = this.asAWTColor();
        return color.getRGB();
    }

    /**
     * Transformiert die GraphicsApp-Farbinstanz in eine AWT-Farbe um mit Java2D benutzt werden zu können.
     *
     * @return die RGB-Farbe als AWT-Objekt
     */
    public java.awt.Color asAWTColor() {
        if (awtColor == null) {
            awtColor = new java.awt.Color(red, green, blue, alpha);
        }
        return awtColor;
    }

}
