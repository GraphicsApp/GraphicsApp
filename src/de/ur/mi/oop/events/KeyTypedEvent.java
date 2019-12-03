package de.ur.mi.oop.events;

public class KeyTypedEvent extends GraphicsAppKeyEvent {

    public KeyTypedEvent(long timestamp, int keyCode, char keyChar) {
        super(timestamp, keyCode, keyChar, KeyEventType.TYPED);
    }
}
