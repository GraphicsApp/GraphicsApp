package de.ur.mi.oop.events;

public class MousePressedEvent extends GraphicsAppMouseEvent {

    private final MouseButton button;

    public MousePressedEvent(long timestamp, int xPos, int yPos, MouseButton button) {
        super(timestamp, xPos, yPos, MouseEventType.PRESSED);
        this.button = button;
    }

    public MouseButton getButton() {
        return button;
    }
}

