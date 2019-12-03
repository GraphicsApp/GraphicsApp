package de.ur.mi.oop.events;


public class MouseMovedEvent extends GraphicsAppMouseEvent {

    public MouseMovedEvent(long timestamp, int xPos, int yPos) {
        super(timestamp, xPos, yPos, MouseEventType.MOVED);
    }
}
