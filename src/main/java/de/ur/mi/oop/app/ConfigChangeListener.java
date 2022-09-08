package de.ur.mi.oop.app;

public interface ConfigChangeListener {

    void onSizeChanged(int newWidth, int newHeight);

    void onFrameRateChanged(int newFramerate);

    void onCursorVisibilityChanged(boolean cursorVisibility);
}