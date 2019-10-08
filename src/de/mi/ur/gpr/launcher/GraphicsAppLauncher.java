package de.mi.ur.gpr.launcher;

import de.mi.ur.gpr.app.AppManager;
import de.mi.ur.gpr.app.GraphicsApp;
import de.mi.ur.gpr.app.Config;

import java.lang.reflect.InvocationTargetException;

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
        String packageName = launcherName.substring(0, launcherName.lastIndexOf(PACKAGE_DELIMITER));
        Class<?> appClass = Class.forName(packageName + PACKAGE_DELIMITER + appName);
        return (GraphicsApp) appClass.getConstructor().newInstance();
    }
}
