package de.ur.mi.oop.events;

public class KeyReleasedEvent extends GraphicsAppKeyEvent {

    public KeyReleasedEvent(long timestamp, int keyCode, char keyChar) {
        super(timestamp, keyCode, keyChar, KeyEventType.RELEASED);
    }
}
