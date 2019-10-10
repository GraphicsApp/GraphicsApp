package de.ur.mi.oop.graphics;

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;

import java.util.ArrayList;
import java.util.Iterator;

public class Compound extends GraphicsObject {

    ///////////////////////////////////////////////////////////////////////////
    // Members and constants
    ///////////////////////////////////////////////////////////////////////////

    private ArrayList<GraphicsObject> objects;
    private Rectangle backgroundRectangle;

    ///////////////////////////////////////////////////////////////////////////
    // Constructors
    ///////////////////////////////////////////////////////////////////////////

    public Compound(float x, float y) {
        super(x, y);
        this.setColor(Colors.TRANSPARENT);
        this.objects = new ArrayList<>();
        this.backgroundRectangle = new Rectangle(getXPos(), getYPos(), getWidth(), getHeight());
    }

    public Compound(float x, float y, Color backgroundColor) {
        this(x, y);
        this.setColor(backgroundColor);
        updateBackground();
    }

    public Compound(Point position) {
        this(position.getXPos(), position.getYPos());
    }

    public Compound(Point position, Color backgroundColor) {
        this(position.getXPos(), position.getYPos(), backgroundColor);
    }

    public Compound() {
        this(0.0f, 0.0f);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Drawing and Updates
    ///////////////////////////////////////////////////////////////////////////

    public void draw() {
        updateBackground();
        drawBackground();

        for (GraphicsObject object : this.objects) {
            GraphicsApp.getApp().addToDrawBuffer(object);
        }
    }

    private void updateBackground() {
        backgroundRectangle.setXPos(getXPos());
        backgroundRectangle.setYPos(getYPos());
        backgroundRectangle.setWidth(getWidth());
        backgroundRectangle.setHeight(getHeight());
        backgroundRectangle.setColor(this.getColor());
    }

    // TODO: add possibility of transparent background rectangle with only stroke
    private void drawBackground() {
        if (backgroundRectangle != null) {
            GraphicsApp.getApp().addToDrawBuffer(backgroundRectangle);
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Content Setting and Getting
    ///////////////////////////////////////////////////////////////////////////

    public void add(GraphicsObject object) {
        this.objects.add(object);
    }

    public void addRelative(GraphicsObject object) {
        this.add(object);
        object.setPosition(this.getXPos() + object.getXPos(), this.getYPos() + object.getYPos());
    }

    public GraphicsObject get(int index) {
        return (GraphicsObject)this.objects.get(index);
    }

    public GraphicsObject getObjectAt(float x, float y) {
        for(int i = this.objects.size() - 1; i >= 0; --i) {
            GraphicsObject object = (GraphicsObject)this.objects.get(i);
            if (object.hitTest(x, y)) {
                return object;
            }
        }

        return null;
    }

    public GraphicsObject getObjectAt(Point point) {
        return this.getObjectAt(point.getXPos(), point.getYPos());
    }

    public void removeAll() {
        this.objects.clear();
        this.backgroundRectangle = null;
        setColor(null);
    }

    public void remove(GraphicsObject object) {
        this.objects.remove(object);
    }

    public void remove(int index) {
        this.objects.remove(index);
    }

    public Iterator<GraphicsObject> iterator() {
        return this.objects.iterator();
    }

    public boolean contains(float x, float y) {
        return this.getObjectAt(x, y) != null;
    }

    public int size() {
        return this.objects.size();
    }

    ///////////////////////////////////////////////////////////////////////////
    // Geometry Related Getting and Setting
    ///////////////////////////////////////////////////////////////////////////

    public float getWidth() {
        float maxRightBorder = -Float.MAX_VALUE;

        if (objects.isEmpty()) {
            return 0;
        }

        for (GraphicsObject object : this.objects) {
            float rightBorder = object.getRightBorder();
            if (rightBorder > maxRightBorder) {
                maxRightBorder = rightBorder;
            }
        }

        return maxRightBorder - this.getXPos();
    }

    public float getHeight() {
        float maxBottomBorder = -Float.MAX_VALUE;

        if (objects.isEmpty()) {
            return 0;
        }

        for (GraphicsObject object : this.objects) {
            float bottomBorder = object.getBottomBorder();
            if (bottomBorder > maxBottomBorder) {
                maxBottomBorder = bottomBorder;
            }
        }

        return maxBottomBorder - this.getYPos();
    }

    public void setXPos(float x) {
        float dx = x - this.getXPos();
        super.setXPos(x);

        for (GraphicsObject object : this.objects) {
            object.move(dx, 0);
        }
    }

    public void setYPos(float y) {
        float dy = y - this.getYPos();
        super.setYPos(y);

        for (GraphicsObject object : this.objects) {
            object.move(0, dy);
        }

    }

    public void setPosition(float x, float y) {
        float dx = x - this.getXPos();
        float dy = y - this.getYPos();

        setXPos(x);
        setYPos(y);

        for (GraphicsObject object : this.objects) {
            object.move(dx, dy);
        }
    }

    public void setPosition(Point point) {
        this.setPosition(point.getXPos(), point.getYPos());
    }

    ///////////////////////////////////////////////////////////////////////////
    // Utility Methods
    ///////////////////////////////////////////////////////////////////////////

    public void move(float dx, float dy) {
        super.move(dx, dy);

        for (GraphicsObject object : this.objects) {
            object.move(dx, dy);
        }

    }

    public boolean hitTest(float x, float y) {
        double minX = Float.MAX_VALUE;
        double maxX = Float.MIN_VALUE;
        double minY = Float.MAX_VALUE;
        double maxY = Float.MIN_VALUE;

        for (GraphicsObject object : this.objects) {
            double objMinX = object.getLeftBorder();
            double objMaxX = object.getRightBorder();
            double objMinY = object.getTopBorder();
            double objMaxY = object.getBottomBorder();
            if (objMinX < minX) {
                minX = objMinX;
            }

            if (objMinX > maxX) {
                maxX = objMaxX;
            }

            if (objMinY < minY) {
                minY = objMinY;
            }

            if (objMaxY > maxY) {
                maxY = objMaxY;
            }
        }

        return x >= minX && x <= maxX && y >= minY && y <= maxY;
    }
}
