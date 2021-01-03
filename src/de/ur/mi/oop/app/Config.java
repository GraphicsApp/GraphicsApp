package de.ur.mi.oop.app;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;

/**
 * Basiskonfiguration der GraphicsApp-Anwendung
 */

public class Config {

    private static final int DEFAULT_WIDTH = 1280;
    private static final int DEFAULT_HEIGHT = 720;
    private static final int DEFAULT_FRAME_RATE = 60;
    private static final Color DEFAULT_BACKGROUND_COLOR = Colors.WHITE;
    private static final Color DEFAULT_COLOR = Colors.RED;
    private static final boolean DEFAULT_FRAME_RATE_VISIBILITY = false;
    private static final String DEFAULT_TITLE = "GraphicsApp";
    private static final boolean DEFAULT_CURSOR_VISIBILITY = true;

    private static final float DEFAULT_STROKE_WIDTH = 2f;

    private int width = DEFAULT_WIDTH;
    private int height = DEFAULT_HEIGHT;
    private int frameRate = DEFAULT_FRAME_RATE;
    private boolean showFrameRate = DEFAULT_FRAME_RATE_VISIBILITY;
    private Color backgroundColor = DEFAULT_BACKGROUND_COLOR;
    private float strokeWidth = DEFAULT_STROKE_WIDTH;
    private String title = DEFAULT_TITLE;
    private boolean cursorVisibility = DEFAULT_CURSOR_VISIBILITY;

    private ConfigChangeListener listener;


    public void setListener(ConfigChangeListener listener) {
        this.listener = listener;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        listener.onSizeChanged(this.width, this.height);
    }

    public float getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(float strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        listener.onSizeChanged(this.width, this.height);
    }

    public int getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(int frameRate) {
        this.frameRate = frameRate;
        listener.onFrameRateChanged(this.frameRate);
    }

    public Color getDefaultColor() {
        return DEFAULT_COLOR;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getCursorVisibility() {
        return cursorVisibility;
    }

    public void setCursorVisibility(boolean isVisible) {
        this.cursorVisibility = isVisible;
        listener.onCursorVisibilityChanged(this.cursorVisibility);
    }

    public boolean shouldShowFrameRate() {
        return this.showFrameRate;
    }

    public void setFrameRateVisibility(boolean frameRateIsVisible) {
        this.showFrameRate = frameRateIsVisible;
    }

}
