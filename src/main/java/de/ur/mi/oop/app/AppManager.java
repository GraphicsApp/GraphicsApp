package de.ur.mi.oop.app;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.events.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;


/**
 * Der AppManager ist dafür zuständig, den Zeichen-Canvas zu initialisieren und
 * die Anwendungs-Eigenschaften wie Fenstergröße, Fenstertitel usw. zu setzen.
 * <p>
 * Im AppManager läuft die Zeichenschleife, welche die Grafikobjekte ständig erneut zeichnet. Er
 * gibt die Tasten- und Maus-Events an die GraphicsApp weiter.
 */
public class AppManager implements ConfigChangeListener, ActionListener, KeyListener, MouseListener, MouseMotionListener {

    private static final Color DEFAULT_BACKGROUND_COLOR = Colors.WHITE;

    private Config config;
    private GraphicsApp app;
    private Canvas canvas;
    private JFrame appFrame;
    private Timer loopTimer;

    private Cursor originalCursor;
    private Cursor blankCursor;

    private long lastFrameTime = 0;
    private int lastFPS = 0;

    public AppManager(GraphicsApp app, Config config) {
        this.app = app;
        this.config = config;
        this.app.setAppManager(this);
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
        appFrame.setResizable(false);
        appFrame.add(canvas);
        canvas.addMouseListener(this);  // MouseListener auf Canvas, damit Koordinaten Titelleiste nicht beinhalten
        canvas.addMouseMotionListener(this);
        appFrame.addKeyListener(this);
        appFrame.setVisible(true);
        originalCursor = appFrame.getContentPane().getCursor();
        blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "blank cursor");
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

    private void hideCursor() {
        appFrame.getContentPane().setCursor(blankCursor);
    }

    private void showCursor() {
        appFrame.getContentPane().setCursor(originalCursor);
    }

    public Graphics2D getGraphicsContext() {
        return (Graphics2D) canvas.getGraphics();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        long currentTime = System.currentTimeMillis();
        long delta = currentTime - lastFrameTime;
        if (delta != currentTime && delta != 0) {
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
    public void onCursorVisibilityChanged(boolean cursorVisibility) {
        if(cursorVisibility) {
            showCursor();
        } else {
            hideCursor();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Close GraphicsApp on ESCAPE
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            appFrame.dispatchEvent(new WindowEvent(appFrame, WindowEvent.WINDOW_CLOSING));
            return;
        }
        KeyPressedEvent keyPressedEvent = (KeyPressedEvent) GraphicsAppKeyEvent.createKeyEventFromAWT(e, KeyEventType.PRESSED);
        ((GraphicsAppKeyListener) app).onKeyPressed(keyPressedEvent);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        KeyReleasedEvent keyReleasedEvent = (KeyReleasedEvent) GraphicsAppKeyEvent.createKeyEventFromAWT(e, KeyEventType.RELEASED);
        ((GraphicsAppKeyListener) app).onKeyReleased(keyReleasedEvent);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        MousePressedEvent mousePressedEvent = (MousePressedEvent) GraphicsAppMouseEvent.createMouseEventFromAWT(e, MouseEventType.PRESSED);
        ((GraphicsAppMouseListener) app).onMousePressed(mousePressedEvent);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        MouseReleasedEvent mouseReleasedEvent = (MouseReleasedEvent) GraphicsAppMouseEvent.createMouseEventFromAWT(e, MouseEventType.RELEASED);
        ((GraphicsAppMouseListener) app).onMouseReleased(mouseReleasedEvent);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        MouseDraggedEvent mouseDraggedEvent = (MouseDraggedEvent) GraphicsAppMouseEvent.createMouseEventFromAWT(e, MouseEventType.DRAGGED);
        ((GraphicsAppMouseListener) app).onMouseDragged(mouseDraggedEvent);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        MouseMovedEvent mouseMovedEvent = (MouseMovedEvent) GraphicsAppMouseEvent.createMouseEventFromAWT(e, MouseEventType.MOVED);
        ((GraphicsAppMouseListener) app).onMouseMoved(mouseMovedEvent);
    }
}