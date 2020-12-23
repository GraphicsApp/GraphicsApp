package de.ur.mi.oop.graphics;

/**
 * Alle rotierbaren GraphicsObjects implementieren dieses Interface und bietet damit eine Schnittstelle
 * zum Setzen und Auslesen des aktuellen Rotationswinkels und des zu verwendenden Rotationspunkts an.
 */

public interface RotatableGraphicsObject {

    double MIN_ROTATION_ANGLE = 0;
    double MAX_ROTATION_ANGLE = 360;

    /**
     * Liefert den für die Rotation zu verwendenden Ursprungspunkt zurück
     *
     * @return Ursprungspunkt für die Rotation
     */
    public Point getRotationOrigin();

    /**
     * Liefert den aktuellen Rotationswinkel des Objects
     *
     * @return Aktueller Rotationswinkel als Radians
     */
    public double getRotationAngle();

    /**
     * Liefert den aktuellen Rotationswinkel des Objects
     *
     * @return Aktueller Rotationswinkel in Grad
     */
    public double getRotationAngleInRadians();

    /**
     * Setzt den Rotationswinkel des Objekts
     *
     * @param angle Neuer Rotationswinkel in Grad
     */
    public void setRotationAngle(double angle);
}
