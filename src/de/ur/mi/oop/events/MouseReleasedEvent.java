package de.ur.mi.oop.events;

public class MouseReleasedEvent extends GraphicsAppMouseEvent {

        private final MouseButton button;

        public MouseReleasedEvent(long timestamp, int xPos, int yPos, MouseButton button) {
            super(timestamp, xPos, yPos, MouseEventType.RELEASED);
            this.button = button;
        }

        public MouseButton getButton() {
            return button;
        }
    }

