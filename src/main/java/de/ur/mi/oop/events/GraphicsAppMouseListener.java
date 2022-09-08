package de.ur.mi.oop.events;

public interface GraphicsAppMouseListener {

    void onMouseMoved(MouseMovedEvent event);
    void onMousePressed(MousePressedEvent event);
    void onMouseReleased(MouseReleasedEvent event);
    void onMouseDragged(MouseDraggedEvent event);

}
