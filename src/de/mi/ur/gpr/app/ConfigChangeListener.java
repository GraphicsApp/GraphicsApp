package de.mi.ur.gpr.app;

public interface ConfigChangeListener {

    void onSizeChanged(int newWidth, int newHeight);
    void onFrameRateChanged(int newFramerate);

}
