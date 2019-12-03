package de.ur.mi.oop.events;

public class MouseClickedEvent extends GraphicsAppMouseEvent {

    private final MouseButton button;

    public MouseClickedEvent(long timestamp, int xPos, int yPos, MouseButton button) {
        super(timestamp,xPos,yPos, MouseEventType.CLICK);
        this.button = button;
    }

    public MouseButton getButton() {
        return button;
    }


}
