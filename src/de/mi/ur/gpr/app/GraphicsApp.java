package de.mi.ur.gpr.app;

import de.mi.ur.gpr.colors.Color;
import de.mi.ur.gpr.events.GraphicsAppKeyListener;
import de.mi.ur.gpr.events.GraphicsAppMouseListener;
import de.mi.ur.gpr.events.KeyPressedEvent;
import de.mi.ur.gpr.events.MouseClickedEvent;
import de.mi.ur.gpr.graphics.Background;
import de.mi.ur.gpr.graphics.GraphicsObject;

import java.util.ArrayList;

public abstract class GraphicsApp implements GraphicsAppKeyListener, GraphicsAppMouseListener {

    private static GraphicsApp app = null;
    private Background background = null;
    private ArrayList<GraphicsObject> objects;
    private ArrayList<GraphicsObject> drawBuffer;
    private Config config;

    /*
     * Full singelton pattern might not be possible:
     *
     * On runtime, only one GraphicsApp instance is allowed but all GraphicsApps need a public constructor to be created
     * in GraphicsAppLauncher via reflection.
     */
    public GraphicsApp() {
        try {
            if (app == null) {
                app = this;
                objects = new ArrayList<GraphicsObject>();
                drawBuffer = new ArrayList<GraphicsObject>();
            } else {
                throw new OnlyOneGraphicsAppAllowedException();
            }
        } catch (OnlyOneGraphicsAppAllowedException e) {
            e.printStackTrace();
        }
    }

    public static GraphicsApp getApp() {
        return app;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public abstract void init();


    public abstract void draw();

    public GraphicsObject[] getObjects() {
        // TODO: Think about passing copies of the objects!
        return objects.toArray(new GraphicsObject[objects.size()]);
    }

    public int getWidth() {
        return config.getWidth();
    }

    public int getHeight() {
        return config.getHeight();
    }

    protected void drawBackground(Color color) {
        if (background == null) {
            background = new Background();
        }
        background.setColor(color);
        background.draw();
    }

    protected void setFrameRate(int frameRate) {
        config.setFrameRate(frameRate);
    }

    public void addObject(GraphicsObject object) {
        objects.add(object);
    }

    public void removeObject(GraphicsObject object) {
        objects.remove(object);
    }

    public void addToDrawBuffer(GraphicsObject object) {
        drawBuffer.add(object);
    }

    public GraphicsObject[] getDrawBuffer() {
        // TODO: Think about passing copies of the objects!
        return drawBuffer.toArray(new GraphicsObject[drawBuffer.size()]);
    }

    public void clearDrawBuffer() {
        drawBuffer.clear();
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {

    }

    @Override
    public void onMouseClicked(MouseClickedEvent event) {

    }
}
