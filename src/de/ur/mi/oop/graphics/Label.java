package de.ur.mi.oop.graphics;

import de.ur.mi.oop.colors.Color;

/**
 * Die Klasse Label ist ein grafisches Objekt, das einen Text darstellt.
 */
public class Label extends GraphicsObject {

    private String text;

    /**
     * Konstruiert ein neues Label, das an den Koordinaten x und y mit
     * angegebenem Text und Schriftfarbe.
     *
     * @param x    Die x-Position der Grundlinie in Pixel
     * @param y    Die y-Position der Grundlinie in Pixel
     * @param text Der Text des Labels
     */
    public Label(float x, float y, String text) {
        super(x, y);
        this.text = text;
        this.type = GraphicsObjectType.LABEL;
    }

    /**
     * Konstruiert ein neues Label, das an den Koordinaten x und y mit
     * angegebenem Text und Schriftfarbe.
     *
     * @param x         Die x-Position der Grundlinie in Pixel
     * @param y         y
     *                  Die y-Position der Grundlinie in Pixel
     * @param text      Der Text des Labels
     * @param fontColor Die Farbe des Labels
     */
    public Label(float x, float y, String text, Color fontColor) {
        this(x, y, text);
        this.setColor(fontColor);
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
