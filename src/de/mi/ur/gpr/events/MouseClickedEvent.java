package de.mi.ur.gpr.events;

public class MouseClickedEvent extends Event {

    public final int xPos;
    public final int yPos;

    public MouseClickedEvent(long timestamp, int xPos, int yPos) {
        super(timestamp);
        this.xPos = xPos;
        this.yPos = yPos;
    }
}
