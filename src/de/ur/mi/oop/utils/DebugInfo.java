package de.ur.mi.oop.utils;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.graphics.Label;
import de.ur.mi.oop.graphics.Rectangle;

import java.util.LinkedHashMap;

/**
 * Mit dieser Klasse können Sie ein semi-transparentes Feld mit Debug-Informationen in Ihrer GraphicsApp anzeigen. Die angezeigten Informationen können
 * von beliebigen Stellen der Anwendung gesetzt und aktualisiert werden. Angezeigt werden jeweils eine Beschreibung und ein konkreter Wert. Beim ersten
 * Setzen einer Beschreibung wird die Information im Feld ergänzt, wiederholtes Setzen der gleichen Beschreibung (mit anderen Werten) führt zu Aktualisierung
 * der angezeigten Informationen. Der Aufruf der statische draw-Methode zeichnet das Feld. Fügen Sie diesem AM ENDE der draw-Methode Ihrer GraphicsApp ein.
 * <p>
 * Das Feld ist standardmäßig ausgeblendet und muss über den Aufruf der Methode DebugInfo.show() eingeblendet werden.
 * <p>
 * Öffentliche statische Methode der Klasse
 * <p>
 * DebugInfo.show() => Blendet das Feld ein
 * DebugInfo.hide() => Blendet das Feld aus
 * DebugInfo.draw() => Zeichnet das Feld
 * DebugInfo.set(String name, String value) => Fügt den Wert (value) mit der Beschreibung (name) im Feld ein bzw. aktualisiert den Wert
 * DebugInfo.set(String name, boolean value) => siehe DebugInfo.set(String name, String value)
 * DebugInfo.set(String name, boolean short) => siehe DebugInfo.set(String name, String value)
 * DebugInfo.set(String name, boolean int) => siehe DebugInfo.set(String name, String value)
 * DebugInfo.set(String name, boolean float) => siehe DebugInfo.set(String name, String value)
 * DebugInfo.set(String name, boolean double) => siehe DebugInfo.set(String name, String value)
 * DebugInfo.set(String name, boolean char) => siehe DebugInfo.set(String name, String value)
 * DebugInfo.remove(String name) => Entfernt Wert und Beschreibung des Eintrags mit der Beschreibung (name) aus dem Feld
 * <p>
 * Beispiel:
 * <p>
 * int frame;
 * <p>
 * public void initialize() {
 * DebugInfo.show();
 * }
 * <p>
 * public void draw() {
 * // Zeichnen der App-Bestandteile
 * // ...
 * <p>
 * // Anzeige der Anzahl der gezeichneten Frames
 * DebugInfo.set("FRAMES DRAWN", frame);
 * DebugInfo.draw();
 * frame++;
 * }
 */

public class DebugInfo {

    private static final int X_POSITION = 5;
    private static final int Y_POSITION = 5;
    private static final int MIN_WIDTH = 1;
    private static final int MIN_HEIGHT = 1;
    private static final int PADDING = 10;
    private static final Color BACKGROUND_COLOR = new Color(250, 250, 250, 150);
    private static final Color BORDER_COLOR = new Color(200, 200, 200, 150);
    private static final float BORDER_WEIGHT = 1;
    private static final String FONT_NAME = "Monospaced";
    private static final Color FONT_COLOR = new Color(30, 30, 30);
    private static final int FONT_SIZE = 10;
    private static final String TITLE = "### Debug Info ###";

    private static DebugInfo instance;

    private final Rectangle background;
    private final LinkedHashMap<String, Label> values;
    private boolean isVisible;

    private DebugInfo() {
        background = new Rectangle(X_POSITION, Y_POSITION, MIN_WIDTH, MIN_HEIGHT, BACKGROUND_COLOR);
        background.setBorder(BORDER_COLOR, BORDER_WEIGHT);
        values = new LinkedHashMap<>();
        isVisible = false;
        updateOrAddLabel(TITLE, "");
        pack();
    }

    private static DebugInfo getInstance() {
        if (instance == null) {
            instance = new DebugInfo();
        }
        return instance;
    }

    private void updateOrAddLabel(String name, String value) {
        Label label = values.get(name);
        if (label == null) {
            label = createLabel(name, value);
            values.put(name, label);
        } else {
            label.setText(name + ": " + value);
        }
    }

    private Label createLabel(String name, String value) {
        Label label = new Label(0, 0, name + ": " + value, FONT_COLOR);
        if (name.equals(TITLE)) {
            label.setText(TITLE);
        }
        label.setFont(FONT_NAME);
        label.setFontSize(FONT_SIZE);
        return label;
    }

    private void pack() {
        float minHeight = 0;
        float minWidth = 0;
        float x = background.getXPos() + PADDING;
        float y = background.getYPos() + PADDING;
        for (Label label : values.values()) {
            label.setPosition(x, y);
            y += FONT_SIZE + PADDING;
            minHeight += FONT_SIZE + PADDING;
            if (minWidth < label.getWidthEstimate()) {
                minWidth = label.getWidthEstimate();
            }
        }
        background.setWidth(minWidth + 2 * PADDING);
        background.setHeight(minHeight - FONT_SIZE);
    }

    private void setValue(String name, String value) {
        updateOrAddLabel(name, value);
        pack();
    }

    private void removeValue(String name) {
        values.remove(name);
        pack();
    }

    private void showInfo() {
        isVisible = true;
    }

    public void hideInfo() {
        isVisible = false;
    }

    public void drawInfo() {
        if (!isVisible) {
            return;
        }
        background.draw();
        for (Label label : values.values()) {
            label.draw();
        }
    }

    public static void set(String name, String value) {
        getInstance().setValue(name, value);
    }

    public static void set(String name, boolean value) {
        set(name, String.valueOf(value));
    }

    public static void set(String name, short value) {
        set(name, String.valueOf(value));
    }

    public static void set(String name, int value) {
        set(name, String.valueOf(value));
    }

    public static void set(String name, float value) {
        set(name, String.valueOf(value));
    }

    public static void set(String name, double value) {
        set(name, String.valueOf(value));
    }

    public static void set(String name, char value) {
        set(name, String.valueOf(value));
    }

    public static void remove(String name) {
        getInstance().removeValue(name);
    }

    public static void show() {
        getInstance().showInfo();
    }

    public static void hide() {
        getInstance().hideInfo();
    }

    public static void draw() {
        getInstance().drawInfo();
    }

}
