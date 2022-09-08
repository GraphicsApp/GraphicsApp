package de.ur.mi.oop.graphics;

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;

import java.awt.image.BufferedImage;

/**
 * Diese Klasse ist die gemeinsame Oberklasse aller grafischen Objekte, die in
 * einer GraphicsApp angezeigt werden können. Da es sich um eine abstrakte Klasse handelt, ist es nicht erlaubt,
 * direkt ein Objekt vom Typ GraphicsObject zu konstruieren. Stattdessen wird eine der konkreten Unterklassen
 * wie Rectangle oder Line erzeugt. Der Zweck dieser Klassendefinition ist es, Methoden zu definieren, die für alle
 * grafische Objekte unabhängig von ihrer spezifischen Klasse gelten.
 */
public abstract class GraphicsObject {

    ///////////////////////////////////////////////////////////////////////////
    // Members and constants
    ///////////////////////////////////////////////////////////////////////////

    protected static final Color DEFAULT_COLOR = Colors.RED;
    protected static final Color DEFAULT_BORDER_COLOR = Colors.BLACK;

    private float xPos;
    private float yPos;

    private float width;
    private float height;

    private Color color;
    private Color strokeColor;
    protected float strokeWeight;

    protected GraphicsObjectType type;

    ///////////////////////////////////////////////////////////////////////////
    // Constructors
    ///////////////////////////////////////////////////////////////////////////

    public GraphicsObject(float x, float y, Color color) {
        this.xPos = x;
        this.yPos = y;
        this.width = 0;
        this.height = 0;
        this.color = color;
        this.strokeWeight = 0;
        this.strokeColor = DEFAULT_BORDER_COLOR;
        this.type = GraphicsObjectType.NONE;
    }

    public GraphicsObject(float x, float y) {
        this(x, y, GraphicsApp.getApp().getConfig().getDefaultColor());
    }

    public GraphicsObject(float x, float y, float width, float height, Color color) {
        this(x, y, color);
        this.width = width;
        this.height = height;
    }

    public GraphicsObject(float x, float y, float width, float height, Color color, Color borderColor) {
        this(x, y, width, height, color);
        this.strokeColor = borderColor;
    }

    public GraphicsObject(Point point) {
        this(point.getXPos(), point.getYPos());
    }

    ///////////////////////////////////////////////////////////////////////////
    // Drawing
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Zeichnet das Grafikobjekt auf den Canvas.
     */
    public void draw() {
        GraphicsApp.getApp().addToDrawBuffer(this);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Getters and Setters
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Liefert die x-Koordinate des Objekts.
     *
     * @return die x-Koordinate des Objekts.
     */
    public float getXPos() {
        return xPos;
    }

    /**
     * Setzt die x-Koordinate des Objekts.
     *
     * @param xPos Die neue x-Koordinate
     */
    public void setXPos(float xPos) {
        this.xPos = xPos;
    }

    /**
     * Liefert die y-Koordinate des Objekts.
     *
     * @return die y-Koordinate des Objekts.
     */
    public float getYPos() {
        return yPos;
    }

    /**
     * Setzt die y-Koordinate des Objekts.
     *
     * @param yPos Die neue y-Koordinate
     */
    public void setYPos(float yPos) {
        this.yPos = yPos;
    }

    /**
     * Setzt die Position des Objekts,
     * gegeben durch xPos und yPos
     *
     * @param xPos Die neue x-Koordinate
     * @param yPos Die neue y-Koordinate
     */
    public void setPosition(float xPos, float yPos) {
        setXPos(xPos);
        setYPos(yPos);
    }

    /**
     * Liefert die Breite des Objekts.
     *
     * @return die Breite des Objekts.
     */
    public float getWidth() {
        return this.width;
    }

    /**
     * Liefert die Höhe des Objekts.
     *
     * @return die Höhe des Objekts.
     */
    public float getHeight() {
        return this.height;
    }

    /**
     * Setzt die Breite des Objekts.
     *
     * @param width die neue Breite
     */
    public void setWidth(float width) {
        this.width = width;
    }

    /**
     * Setzt die Höhe des Objekts.
     *
     * @param height die neue Breite
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * Liefert den oberen Rand des Objekts.
     *
     * @return der obere Rand des Objekts.
     */
    public float getTopBorder() {
        return this.getYPos();
    }

    /**
     * Liefert den unteren Rand des Objekts.
     *
     * @return der untere Rand des Objekts.
     */
    public float getBottomBorder() {
        return this.getYPos() + this.getHeight();
    }

    /**
     * Liefert den linken Rand des Objekts.
     *
     * @return der linke Rand des Objekts.
     */
    public float getLeftBorder() {
        return this.getXPos();
    }

    /**
     * Liefert den rechten Rand des Objekts.
     *
     * @return der rechte Rand des Objekts.
     */
    public float getRightBorder() {
        return this.getXPos() + this.getWidth();
    }

    /**
     * Liefert die Hintergrundfarbe des Objekts
     *
     * @return die Hintergrundfarbe
     */
    public Color getColor() {
        return color;
    }

    /**
     * Setzt die Hintergrundfarbe des Objekts
     *
     * @param color die neue Hintergrundfarbe
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Setzt die Randfarbe des Objekts
     *
     * @param color die neue Randfarbe
     */
    public void setBorderColor(Color color) {
        this.strokeColor = color;
    }

    /**
     * Setzt die Randstärke des Objekts
     *
     * @param weight die neue Randstärke
     */
    public void setBorderWeight(float weight) {
        this.strokeWeight = weight;
    }

    /**
     * Setzt die Randeigenschaften des Objekts
     *
     * @param color  die neue Randfarbe
     * @param weight die neue Randstärke
     */
    public void setBorder(Color color, float weight) {
        this.setBorderColor(color);
        this.setBorderWeight(weight);
    }

    /**
     * Liefert die Randstärke des Objekts
     *
     * @return die Randstärke des Objekts
     */
    public float getBorderWeight() {
        return this.strokeWeight;
    }

    /**
     * Liefert die Randfarbe des Objekts
     *
     * @return die Randfarbe des Objekts
     */
    public Color getBorderColor() {
        return this.strokeColor;
    }

    /**
     * Liefert den Grafik-Typ des Objekts
     *
     * @return der Grafik-Typ des Objekts
     */
    public GraphicsObjectType getType() {
        return type;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Utility Methods
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Bewegt das Objekt auf dem Bildschirm mit den Verschiebungen dx und dy.
     *
     * @param dx Die horizontale Änderung der Position
     * @param dy Die vertikale Änderung der Position
     */
    public void move(float dx, float dy) {
        this.xPos += dx;
        this.yPos += dy;
    }

    /**
     * Prüft, ob dieses Objekt die angegebenen Koordinaten enthält.
     *
     * @param x Die zu testende x-Position
     * @param y y
     *          Die zu testende y-Position
     * @return true, wenn sich der Punkt (x, y) innerhalb des Objekts befindet,
     * und false andernfalls
     */
    public boolean hitTest(float x, float y) {
        return x >= this.getLeftBorder() && x <= this.getRightBorder() && y >= this.getTopBorder() && y <= this.getBottomBorder();
    }

    /**
     * Liefert den Abstand zu einem anderen Grafikobjekt.
     *
     * @param object das andere Grafikobjekt
     * @return Abstand zwischen diesem Objekt und dem angegebenen Objekt
     */
    public double distanceTo(GraphicsObject object) {
        double dx = object.getXPos() - this.getXPos();
        double dy = object.getYPos() - this.getYPos();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
