package de.ur.mi.oop.app;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.events.*;
import de.ur.mi.oop.graphics.Background;

import java.awt.event.MouseEvent;

/*! \mainpage GraphicsApp API
 *
 * <p>Die <i>GraphicsApp</i>-Bibliothek erlaubt die Umsetzung einfacher 2D-Anwendungen mit der Programmiersprache Java und richtet
 * sich explizit an Programmieranfänger*innen. Die Bibliothek wird von Mitarbeiter*innen des
 * <a href= "https://www.uni-regensburg.de/sprache-literatur-kultur/medieninformatik/aktuelles/index.html">Lehrstuhls für Medieninformatik</a>
 * der Universität Regensburg <a href="https://github.com/OOP-Regensburg/GraphicsApp-Reborn-Library">entwickelt</a>. Der Quellcode kann
 * auf <a href="https://github.com/OOP-Regensburg/GraphicsApp-Reborn-Library">GitHub</a> eingesehen werden und unter der MIT-Lizenz verwendet werden.
 * Vorbereitete JAR-Dateien für die Integration in eigene Projekte finden sich ebenfalls <a href="https://github.com/OOP-Regensburg/GraphicsApp-Reborn-Library/releases">
 * auf GitHub</a>.Hauptverantwortlicher Ansprechpartner für die Weiterentwicklung ist <a href="go.ur.de/alexanderbazo">Alexander Bazo</a>.</p>
 * <p>Mit der <i>GraphicsApp</i>-Umgebung können Programmieranfänger*innen erste, interaktive Java-Programme entwickeln. Grundlegende Konzepte sind dabei
 * eine <b>Zeichenfläche</b>, ein <i>Draw Loop</i> und ein Reihe von <b>Klassen</b> zur Repräsentation von graphischen Primitiven, Texten und Bildern auf dieser
 * Zeichenfläche. Ergänzen stehen einfache Möglichkeiten zur Ausgabe von Audio-Dateien und eine Event-basierte Möglichkeit zur Nutzung von Maus- und
 * Tastatureingaben zur Verfügung.</p>
 * <p>Alle <i>GraphicsApp</i>-Anwendungen basieren auf der Klasse <code>GraphicsApp</code>. Deren <code>draw</code>-Methode bildet die Grundlage für
 * den <i>Draw Loop</i> und wird zur Laufzeit ca. 60 mal pro Sekunde aufgerufen. Innerhalb des <i>Loops</i> können graphische Elemente erstellt,
 * bewegt und gezeichnet werden. Auf dieser Basis lassen sich statische Collagen, einfache Animationen und erste, interaktive Anwendungen bzw. Spiele umsetzen.</p>
 */

/**
 * Dies ist die abstrakte Basisklasse für alle GraphicsApp-Anwendungen. Jedes Programm erbt von dieser Klasse
 * und verfügt über die hier implementierten Funktionen. Die Programmier*innen überschreibt die `draw()`- und
 * `initialize()`-Methoden, um die spezifischen Funktionen des eigenen GraphicsApp-Programms umzusetzten. Ein
 * solches Programm kann dann über eine `main`-Methode und die Verwendung desGraphicsAppLauncher gestartet werden.
 */
public abstract class GraphicsApp extends GraphicsAppCore implements GraphicsAppKeyListener, GraphicsAppMouseListener {

    private Background background;

    public GraphicsApp() {
        super();
    }

    /**
     * Wird einmalig zu Programmbeginn aufgerufen. Hier sollte Code stehen,
     * der alles vorbereitet, was notwendig für die Programmausführung ist.
     * Zeichenbefehle haben hier keinen Platz.
     */
    public abstract void initialize();

    /**
     * Wird in einer Schleife aufgerufen, solange die GraphicsApp-Anwendung läuft. Hier sollten
     * alle GraphicsObjects aktualisiert und gezeichnet werden.
     */
    public abstract void draw();


    @Override
    public void onMouseMoved(MouseMovedEvent event) {

    }

    @Override
    public void onMousePressed(MousePressedEvent event) {

    }

    @Override
    public void onMouseReleased(MouseReleasedEvent event) {

    }

    @Override
    public void onMouseDragged(MouseDraggedEvent event) {

    }

    /**
     * Wenn Tastendrücke abgefangen werden sollen, muss diese Methode von Kindklassen überschrieben werden
     *
     * @param event Der Tasten-Event, der die Taste enthält, die gedrückt wurde
     */
    @Override
    public void onKeyPressed(KeyPressedEvent event) {

    }

    @Override
    public void onKeyReleased(KeyReleasedEvent event) {

    }

    /**
     * Zeichnet den Hintergrund der GraphicsApp-Anwendung
     *
     * @param color die Hintergrundfarbe
     */
    protected void drawBackground(Color color) {
        if (background == null) {
            background = new Background(getWidth(), getHeight());
        }
        background.setColor(color);
        background.draw();
    }

    /**
     * Setzt die Bildwiederholrate der GraphicsApp-Anwendung
     *
     * @param frameRate Bilder pro Sekunde
     */
    protected void setFrameRate(int frameRate) {
        getConfig().setFrameRate(frameRate);
    }

    /**
     * Zeigt die aktuelle Bildwiederholrate in der Titelleiste der Anwendung an
     */
    protected void showFrameRate() {
        getConfig().setFrameRateVisibility(true);
    }

    /**
     * Blendet den Maus-Cursor im Anwendungsfenster ein
     */
    protected void showCursor() {
        getConfig().setCursorVisibility(true);
    }

    /**
     * Blendet den Maus-Cursor im Anwendungsfenster aus
     */
    protected void hideCursor() {
        getConfig().setCursorVisibility(false);
    }

    public int getWidth() {
        return getConfig().getWidth();
    }

    public int getHeight() {
        return getConfig().getHeight();
    }

    public void setCanvasSize(int width, int height) {
        getConfig().setWidth(width);
        getConfig().setHeight(height);
    }
}
