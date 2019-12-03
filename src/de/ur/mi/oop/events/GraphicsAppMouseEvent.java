package de.ur.mi.oop.events;

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

}
