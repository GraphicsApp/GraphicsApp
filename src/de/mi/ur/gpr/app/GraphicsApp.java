package de.mi.ur.gpr.app;

import de.mi.ur.gpr.colors.Color;
import de.mi.ur.gpr.events.GraphicsAppKeyListener;
import de.mi.ur.gpr.events.GraphicsAppMouseListener;
import de.mi.ur.gpr.events.KeyPressedEvent;
import de.mi.ur.gpr.events.MouseClickedEvent;
import de.mi.ur.gpr.graphics.Background;

public abstract class GraphicsApp extends GraphicsAppCore implements GraphicsAppKeyListener, GraphicsAppMouseListener {

    private Background background;

    public GraphicsApp() {
        super();
    }

    public abstract void init();

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
}
