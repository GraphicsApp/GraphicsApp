package de.ur.mi.oop.events;

public class KeyPressedEvent extends Event {


    private final int keyCode;
    private char keyChar;

    public KeyPressedEvent(long timestamp, int keyCode, char keyChar) {
        super(timestamp);
        this.keyCode = keyCode;
        this.keyChar = keyChar;
    }

    public int getKeyCode() {
        return  this.keyCode;
    }

    public char getKeyChar() {
        return this.keyChar;
    }

}
