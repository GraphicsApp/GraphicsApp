package de.ur.mi.oop.events;

public interface GraphicsAppMouseListener {

    void onMouseClicked(MouseClickedEvent event);
    void onMouseMoved(MouseMovedEvent event);
    void onMousePressed(MousePressedEvent event);
    void onMouseReleased(MouseReleasedEvent event);
}
