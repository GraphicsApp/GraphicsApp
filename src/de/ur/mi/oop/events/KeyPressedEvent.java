package de.ur.mi.oop.events;

public class KeyPressedEvent extends Event {


    public final int keyCode;
    public char keyChar;

    public KeyPressedEvent(long timestamp, int keyCode, char keyChar) {
        super(timestamp);
        this.keyCode = keyCode;
        this.keyChar = keyChar;
    }

}
