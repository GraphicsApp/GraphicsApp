package de.mi.ur.gpr.graphics;

import de.mi.ur.gpr.app.GraphicsApp;

public class Background extends Rectangle {

    // TODO: Remove dependency to GraphicsApp by injecting correct witdth and height
    public Background() {
        super(0,0, GraphicsApp.getApp().getWidth(), GraphicsApp.getApp().getHeight());
        this.type = GraphicsObjectType.BACKGROUND;
    }



}
