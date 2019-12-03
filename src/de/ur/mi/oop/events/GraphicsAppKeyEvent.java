package de.ur.mi.oop.events;

public abstract class GraphicsAppKeyEvent extends Event {

    private final int keyCode;
    private final char keyChar;
    private final KeyEventType type;

    public GraphicsAppKeyEvent(long timestamp, int keyCode, char keyChar, KeyEventType type) {
        super(timestamp);
        this.keyCode = keyCode;
        this.keyChar = keyChar;
        this.type = type;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public char getKeyChar() {
        return keyChar;
    }

    public KeyEventType getType() {
        return type;
    }
}
