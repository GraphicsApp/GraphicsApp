package de.ur.mi.oop.app;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;

// TODO: Config is shared by App and AppManager. Check if any safety issues occur by allowing both sides to change the object.
public class Config {

    private static final int DEFAULT_WIDTH = 1280;
    private static final int DEFAULT_HEIGHT = 720;
    private static final int DEFAULT_FRAME_RATE = 60;
    private static final Color DEFAULT_BACKRGOUND_COLOR = Colors.WHITE;
    private static final Color DEFAULT_COLOR = Colors.RED;
    private static final String DEFAULT_TITLE = "GraphicsApp";

    private static final float DEFAULT_STROKE_WIDTH = 2f;

    private int width = DEFAULT_WIDTH;
    private int height = DEFAULT_HEIGHT;
    private int frameRate = DEFAULT_FRAME_RATE;
    private Color backgroundColor = DEFAULT_BACKRGOUND_COLOR;
    private float strokeWidth = DEFAULT_STROKE_WIDTH;
    private String title = DEFAULT_TITLE;

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

}
