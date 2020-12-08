package de.ur.mi.oop.app;

import de.ur.mi.oop.graphics.GraphicsObject;

import java.lang.ref.Cleaner;
import java.util.ArrayList;

/**
 * Die GraphicsAppCore-Klasse verwaltet den Zeichenpuffer und die Konfiguration.
 */
public class GraphicsAppCore {

    private static GraphicsAppCore app = null;
    private AppManager manager;
    private ArrayList<GraphicsObject> drawBuffer;
    private Config config;

    /*
     * Full singleton pattern might not be possible:
     *
     * On runtime, only one GraphicsApp instance is allowed but all GraphicsApps need a public constructor to be created
     * in GraphicsAppLauncher via reflection.
     */
    public GraphicsAppCore() {
        try {
            if (app == null) {
                app = this;
                drawBuffer = new ArrayList<>();
            } else {
                throw new OnlyOneGraphicsAppAllowedException();
            }
        } catch (OnlyOneGraphicsAppAllowedException e) {
            e.printStackTrace();
        }
    }

    public static GraphicsApp getApp() {
        return (GraphicsApp) app;
    }

    public void setAppManager(AppManager manager) {
        this.manager = manager;
    }

    public AppManager getAppManager() {
        return manager;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public Config getConfig() {
        return config;
    }

    public void addToDrawBuffer(GraphicsObject object) {
        drawBuffer.add(object);
    }

    public GraphicsObject[] getDrawBuffer() {
        // TODO Think about passing copies of the objects!
        return drawBuffer.toArray(new GraphicsObject[0]);
    }

    public void clearDrawBuffer() {
        drawBuffer.clear();
    }

    public void destroy() {
        app = null;
    }
}
