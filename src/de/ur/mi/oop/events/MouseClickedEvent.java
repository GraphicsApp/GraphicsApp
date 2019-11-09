package de.ur.mi.oop.events;

public class MouseClickedEvent extends Event {

    private final int xPos;
    private final int yPos;

    public MouseClickedEvent(long timestamp, int xPos, int yPos) {
        super(timestamp);
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getXPos() {
        return this.xPos;
    }

    public int getYPos() {
        return this.yPos;
    }
}
