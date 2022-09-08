package de.ur.mi.oop.graphics;

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Diese Klasse definiert ein grafisches Objekt, das aus einer Sammlung von anderen
 * grafische Objekten besteht. Nach dem Aufbau können die internen Objekte wie eine Einheit
 * behandelt werden.
 */
public class Compound extends GraphicsObject {

    ///////////////////////////////////////////////////////////////////////////
    // Members and constants
    ///////////////////////////////////////////////////////////////////////////

    private ArrayList<GraphicsObject> objects;
    private Rectangle backgroundRectangle;

    ///////////////////////////////////////////////////////////////////////////
    // Constructors
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Erzeugt ein neues Compound-Objekt ohne interne Komponenten an der angegebenen Position.
     *
     * @param x Die x-Position in Pixeln
     * @param y Die y-Position in Pixeln
     */
    public Compound(float x, float y) {
        super(x, y);
        this.setColor(Colors.TRANSPARENT);
        this.objects = new ArrayList<>();
        this.backgroundRectangle = new Rectangle(getXPos(), getYPos(), getWidth(), getHeight());
    }

    /**
     * Erzeugt ein neues Compound-Objekt ohne interne Komponenten an der angegebenen Position
     * mit einer Hintergrundfarbe.
     *
     * @param x               Die x-Position in Pixeln
     * @param y               Die y-Position in Pixeln
     * @param backgroundColor Hintergrundfarbe
     */
    public Compound(float x, float y, Color backgroundColor) {
        this(x, y);
        this.setColor(backgroundColor);
        updateBackground();
    }

    /**
     * Erzeugt ein neues Compound Objekt ohne interne Komponenten an der mittels Point-Objekt angegebenen Position.
     *
     * @param position Point-Objekt, welches die Stelle markiert
     */
    public Compound(Point position) {
        this(position.getXPos(), position.getYPos());
    }

    /**
     * Erzeugt ein neues Compound-Objekt ohne interne Komponenten an der mittels Point-Objekt angegebenen Position
     * mit einer Hintergrundfarbe.
     *
     * @param position        Point-Objekt, welches die Stelle markiert
     * @param backgroundColor Hintergrundfarbe
     */
    public Compound(Point position, Color backgroundColor) {
        this(position.getXPos(), position.getYPos(), backgroundColor);
    }

    /**
     * Erzeugt ein neues Compound-Objekt ohne interne Komponenten an der Stelle (0, 0).
     */
    public Compound() {
        this(0.0f, 0.0f);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Drawing and Updates
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Zeichnet das Compound und alle hinzugefügten Objekte.
     */
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

    // TODO: Add possibility of transparent background rectangle with only stroke
    private void drawBackground() {
        if (backgroundRectangle != null) {
            GraphicsApp.getApp().addToDrawBuffer(backgroundRectangle);
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Content Setting and Getting
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Fügt dem Compound ein Grafikobjekt hinzu. Das hinzugefügte Objekt behält seine
     * absolute Position.
     *
     * @param object Das Grafikobjekt, das hinzugefügt werden soll
     */
    public void add(GraphicsObject object) {
        this.objects.add(object);
    }

    /**
     * Fügt dem Compound ein Grafikobjekt hinzu. Das hinzugefügte Objekt wird positioniert
     * bezogen auf die Position der Verbindung.
     *
     * @param object Das Grafikobjekt, das hinzugefügt werden soll
     */
    public void addRelative(GraphicsObject object) {
        this.add(object);
        object.setPosition(this.getXPos() + object.getXPos(), this.getYPos() + object.getYPos());
    }

    /**
     * Liefert das Objekt am angegebenen Index, die Nummerierung geht von hinten nach vorne
     * (oberstes Objekt hat den höchsten Index).
     *
     * @param index Der Index des zurückzugebenden Objekts
     * @return Das Objekt mit dem angegebenen Index
     */
    public GraphicsObject get(int index) {
        return this.objects.get(index);
    }

    /**
     * Liefert das oberste Grafikobjekt, das den Punkt (x, y) enthält, oder
     * null, wenn kein solches Objekt existiert. Die Koordinaten müssen Absolutwerte sein.
     *
     * @param x Die x-Koordinate des Punktes
     * @param y Die y-Koordinate des Punktes
     * @return Das Objekt an der angegebenen Stelle oder null, wenn kein solches Objekt vorhanden ist.
     */
    public GraphicsObject getObjectAt(float x, float y) {
        for (int i = this.objects.size() - 1; i >= 0; --i) {
            GraphicsObject object = this.objects.get(i);
            if (object.hitTest(x, y)) {
                return object;
            }
        }

        return null;
    }

    /**
     * Liefert das oberste Grafikobjekt, das den Punkt an der Stelle Point enthält, oder
     * null, wenn kein solches Objekt existiert. Die Koordinaten müssen Absolutwerte sein.
     *
     * @param point Die Koordinaten des Punktes
     * @return Das Objekt an der angegebenen Stelle oder null, wenn kein solches Objekt vorhanden ist.
     */
    public GraphicsObject getObjectAt(Point point) {
        return this.getObjectAt(point.getXPos(), point.getYPos());
    }

    /**
     * Entfernt alle Objekte aus diesem Compound.
     */
    public void removeAll() {
        this.objects.clear();
        this.backgroundRectangle = null;
        setColor(null);
    }

    /**
     * Entfernt ein Objekt aus diesem Compound.
     *
     * @param object Das zu entfernende Objekt
     */
    public void remove(GraphicsObject object) {
        this.objects.remove(object);
    }

    /**
     * Entfernt ein Objekt aus diesem Compound.
     *
     * @param index Der Index des zu entfernenden Objekts
     */
    public void remove(int index) {
        this.objects.remove(index);
    }

    /**
     * Liefert einen Iterator, der die Elemente innerhalb dieses Compounds
     * in der Standardrichtung durchläuft, von hinten nach vorne.
     *
     * @return Ein Iterator, der durch die Elemente des Compounds iteriert, von
     * hinten nach vorne
     */
    public Iterator<GraphicsObject> iterator() {
        return this.objects.iterator();
    }

    /**
     * Überprüft, ob sich ein Punkt "innerhalb" des Compounds befindet,
     * was bedeutet, dass er sich innerhalb einer der Komponenten befindet.
     *
     * @param x Die x-Koordinate des zu prüfenden Punktes.
     * @param y Die y-Koordinate des zu prüfenden Punktes.
     * @return true, wenn sich der Punkt (x, y) innerhalb des Compounds befindet,
     * und false andernfalls
     */
    public boolean contains(float x, float y) {
        return this.getObjectAt(x, y) != null;
    }

    /**
     * Liefert die Anzahl der Objekte.
     *
     * @return Die Anzahl der Objekte in diesem Compound.
     */
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

    /**
     * Bewegt das Compound und alle darin enthaltenen Objekte
     * um die angegebene Verschiebung in x- und y-Richtung
     *
     * @param dx Delta-X - Verschiebung in x-Richtung
     * @param dy Delta-Y - Verschiebung in y-Richtung
     */
    public void move(float dx, float dy) {
        super.move(dx, dy);

        for (GraphicsObject object : this.objects) {
            object.move(dx, dy);
        }

    }

    /**
     * Prüft, ob am angegebenen Punkt ein GraphicsObject liegt
     *
     * @param x Die x-Koordinate des zu prüfenden Punktes.
     * @param y Die y-Koordinate des zu prüfenden Punktes.
     * @return true, wenn sich der Punkt (x, y) innerhalb eines enthaltenen GraphicObjects befindet,
     * und false andernfalls
     */
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

            if (objMaxX > maxX) {
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
