package de.ur.mi.oop.events;

public class KeyPressedEvent extends GraphicsAppKeyEvent {

    public KeyPressedEvent(long timestamp, int keyCode, char keyChar) {
        super(timestamp, keyCode, keyChar, KeyEventType.PRESSED);
    }

}
