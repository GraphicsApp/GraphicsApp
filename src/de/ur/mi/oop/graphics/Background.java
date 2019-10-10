package de.ur.mi.oop.graphics;

import de.ur.mi.oop.app.GraphicsApp;

public class Background extends Rectangle {

    // TODO: Remove dependency to GraphicsApp by injecting correct witdth and height
    public Background() {
        super(0,0, GraphicsApp.getApp().getWidth(), GraphicsApp.getApp().getHeight());
        this.type = GraphicsObjectType.BACKGROUND;
    }

}
