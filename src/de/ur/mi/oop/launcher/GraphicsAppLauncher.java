package de.ur.mi.oop.launcher;

import de.ur.mi.oop.app.AppManager;
import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.app.Config;

import java.lang.reflect.InvocationTargetException;

/**
 * Der GraphicsAppLauncher startet eine GraphicsApp-Anwendung
 */
public class GraphicsAppLauncher {

    public static final String PACKAGE_DELIMITER = ".";

    public static void launch(String appName) {
        Config config = new Config();
        launch(appName, config);
    }

    public static void launch(String appName, Config config) {
        try {
            config.setTitle(appName);
            GraphicsApp app = getGraphicsAppInstance(appName);
            AppManager appManager = new AppManager(app, config);
            config.setListener(appManager);
            app.setConfig(config);
            app.initialize(); // calls GraphicsApp.init once
            appManager.start(); // starts loop to call GraphicsApp.draw repeatedly
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static GraphicsApp getGraphicsAppInstance (String appName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        StackTraceElement[] stackTraceElements = new Exception().getStackTrace();
        String launcherName = stackTraceElements[stackTraceElements.length-1].getClassName();

        String className = "";

        int packageNameCutOffIndex = launcherName.lastIndexOf(PACKAGE_DELIMITER);
        if (packageNameCutOffIndex != -1) {
            String packageName = launcherName.substring(0, launcherName.lastIndexOf(PACKAGE_DELIMITER));
            className = packageName + PACKAGE_DELIMITER + appName;
        } else {
            className = appName;
        }

        Class<?> appClass = Class.forName(className);
        return (GraphicsApp) appClass.getConstructor().newInstance();
    }
}
