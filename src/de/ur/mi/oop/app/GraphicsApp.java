package de.ur.mi.oop.app;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.events.GraphicsAppKeyListener;
import de.ur.mi.oop.events.GraphicsAppMouseListener;
import de.ur.mi.oop.events.KeyPressedEvent;
import de.ur.mi.oop.events.MouseClickedEvent;
import de.ur.mi.oop.graphics.Background;

public abstract class GraphicsApp extends GraphicsAppCore implements GraphicsAppKeyListener, GraphicsAppMouseListener {

    private Background background;

    public GraphicsApp() {
        super();
    }

    public abstract void initialize();

    public abstract void draw();

    @Override
    public void onMouseClicked(MouseClickedEvent event) {

    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {

    }

    protected void drawBackground(Color color) {
        if (background == null) {
            background = new Background();
        }
        background.setColor(color);
        background.draw();
    }

    protected void setFrameRate(int frameRate) {
        getConfig().setFrameRate(frameRate);
    }

    public int getWidth() {
        return getConfig().getWidth();
    }

    public int getHeight() {
        return getConfig().getHeight();
    }

    public void setCanvasSize(int width, int height) {
        getConfig().setWidth(width);
        getConfig().setHeight(height);
    }
}
