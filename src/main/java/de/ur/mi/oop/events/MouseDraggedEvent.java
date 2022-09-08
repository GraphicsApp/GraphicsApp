package de.ur.mi.oop.events;

public class MouseDraggedEvent extends GraphicsAppMouseEvent {

    public MouseDraggedEvent(long timestamp, int xPos, int yPos) {
        super(timestamp, xPos, yPos, MouseEventType.DRAGGED);
    }
}
