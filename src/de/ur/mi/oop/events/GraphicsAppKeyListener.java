package de.ur.mi.oop.events;


public interface GraphicsAppKeyListener {

    void onKeyPressed(KeyPressedEvent event);
    void onKeyTyped(KeyTypedEvent event);
    void onKeyReleased(KeyReleasedEvent event);
}
