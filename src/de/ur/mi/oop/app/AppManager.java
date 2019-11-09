package de.ur.mi.oop.app;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.events.GraphicsAppKeyListener;
import de.ur.mi.oop.events.GraphicsAppMouseListener;
import de.ur.mi.oop.events.KeyPressedEvent;
import de.ur.mi.oop.events.MouseClickedEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;

/**
 * Der AppManager ist dafür zuständig, den Zeichen-Canvas zu initialisieren und
 * die Anwendungs-Eigenschaften wie Fenstergröße, Fenstertitel usw. zu setzen.
 * <p>
 * Im AppManager läuft die Zeichenschleife, welche die Grafikobjekte ständig erneut zeichnet. Er
 * gibt die Tasten- und Maus-Events an die GraphicsApp weiter.
 */
public class AppManager implements ConfigChangeListener, ActionListener, KeyListener, MouseListener {

    private static final Color DEFAULT_BACKGROUND_COLOR = Colors.WHITE;

    private Config config;
    private GraphicsApp app;
    private Canvas canvas;
    private JFrame appFrame;
    private Timer loopTimer;

    private long lastFrameTime = 0;
    private int lastFPS = 0;

    public AppManager(GraphicsApp app, Config config) {
        this.app = app;
        this.config = config;
        initFrame();
    }

    public void start() {
        startLoop();
    }

    public void draw() {
        app.draw();
        canvas.setComponents(app.getDrawBuffer());
        canvas.repaint();
        app.clearDrawBuffer();
    }

    private void initFrame() {
        canvas = new Canvas();
        appFrame = new JFrame();
        appFrame.setTitle(config.getTitle());
        appFrame.setSize(config.getWidth(), config.getHeight());
        appFrame.setLocationRelativeTo(null);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.add(canvas);
        appFrame.addKeyListener(this);
        appFrame.addMouseListener(this);
        appFrame.setVisible(true);
    }

    private void startLoop() {

        loopTimer = new Timer(1000 / config.getFrameRate(), this);
        loopTimer.start();
    }

    private void showFPS(int fps) {
        if (config.shouldShowFrameRate()) {
            appFrame.setTitle("Current FPS: ~ " + fps);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        long currentTime = System.currentTimeMillis();
        long delta = currentTime - lastFrameTime;
        if (delta != currentTime) {
            int currentFPS = 1000 / (int) delta;
            if (Math.abs(currentFPS - lastFPS) > 5) {
                showFPS(currentFPS);
            }
            lastFPS = currentFPS;
        }
        draw();
        lastFrameTime = System.currentTimeMillis();
    }

    @Override
    public void onSizeChanged(int newWidth, int newHeight) {
        appFrame.getContentPane().setPreferredSize(new Dimension(newWidth, newHeight));
        appFrame.pack();
    }

    @Override
    public void onFrameRateChanged(int newFramerate) {
        if (loopTimer != null) {
            loopTimer.setDelay(1000 / newFramerate);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        long timestamp = System.currentTimeMillis();
        int keyCode = e.getKeyCode();
        // TODO: Change to actual key name
        char keyChar = e.getKeyChar();
        KeyPressedEvent keyPressedEvent = new KeyPressedEvent(timestamp, keyCode, keyChar);
        ((GraphicsAppKeyListener) app).onKeyPressed(keyPressedEvent);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        long timestamp = System.currentTimeMillis();
        int xPos = e.getX();
        int yPos = e.getY();
        MouseClickedEvent mouseClickedEvent = new MouseClickedEvent(timestamp, xPos, yPos);
        ((GraphicsAppMouseListener) app).onMouseClicked(mouseClickedEvent);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}