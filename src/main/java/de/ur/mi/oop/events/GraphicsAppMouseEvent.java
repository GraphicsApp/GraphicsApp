package de.ur.mi.oop.events;

import java.awt.event.MouseEvent;

public abstract class GraphicsAppMouseEvent extends Event {

    private final int xPos;
    private final int yPos;
    private final MouseEventType type;

    public GraphicsAppMouseEvent(long timestamp, int xPos, int yPos, MouseEventType type) {
        super(timestamp);
        this.xPos = xPos;
        this.yPos = yPos;
        this.type = type;
    }

    public MouseEventType getType() {
        return this.type;
    }

    public int getXPos() {
        return this.xPos;
    }

    public int getYPos() {
        return this.yPos;
    }

    public static GraphicsAppMouseEvent createMouseEventFromAWT(MouseEvent event, MouseEventType type) {
        long timestamp = System.currentTimeMillis();
        int xPos = event.getX();
        int yPos = event.getY();
        MouseButton button = MouseButton.values()[event.getButton()];
        switch(type) {
            case PRESSED:
                return new MousePressedEvent(timestamp, xPos, yPos, button);
            case RELEASED:
                return new MouseReleasedEvent(timestamp, xPos, yPos, button);
            case MOVED:
                return new MouseMovedEvent(timestamp, xPos, yPos);
            case DRAGGED:
                return new MouseDraggedEvent(timestamp, xPos, yPos);
            default:
                return  null;
        }
    }

}
