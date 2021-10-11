package de.ur.mi.oop.app;

import de.ur.mi.oop.fonts.FontPool;
import de.ur.mi.oop.graphics.*;
import de.ur.mi.oop.graphics.Label;
import de.ur.mi.oop.graphics.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Zeichenfläche zur Darstellung der einzelnen GraphicsObjects
 */
public class Canvas extends JPanel {

    private GraphicsObject[] components;
    private RenderingHints renderingHints;

    public Canvas() {
        this.setOpaque(false);
        createRenderingHints();
    }

    private void createRenderingHints() {
        renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);

    }

    public void setComponents(GraphicsObject[] components) {
        this.components = components;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHints(renderingHints);
        draw(g2d);
    }

    private void draw(Graphics2D g2d) {
        if (components != null) {
            for (GraphicsObject component : components) {
                drawComponent(g2d, component);
            }
        }
    }

    private void drawComponent(Graphics2D g2d, GraphicsObject object) {
        switch (object.getType()) {
            case ARC:
                drawArc(g2d, (Arc) object);
                break;
            case CIRCLE:
                drawCircle(g2d, (Circle) object);
                break;
            case ELLIPSE:
                drawEllipse(g2d, (Ellipse) object);
                break;
            case IMAGE:
                drawImage(g2d, (de.ur.mi.oop.graphics.Image) object);
                break;
            case LABEL:
                drawLabel(g2d, (de.ur.mi.oop.graphics.Label) object);
                break;
            case LINE:
                drawLine(g2d, (Line) object);
                break;
            case PIE_ARC:
                drawPieArc(g2d, (Arc) object);
                break;
            case BACKGROUND:
            case RECTANGLE:
                drawRectangle(g2d, (de.ur.mi.oop.graphics.Rectangle) object);
                break;
            default:
                break;
        }
    }

    private void drawArc(Graphics2D g2d, Arc arc) {
        Arc2D arcShape = new Arc2D.Float(
                arc.getXPos() - arc.getRadius(),
                arc.getYPos() - arc.getRadius(),
                arc.getRadius() * 2, arc.getRadius() * 2,
                arc.getStart(),
                arc.getEnd(),
                Arc2D.OPEN);
        drawShape(g2d, arc, arcShape);
    }

    private void drawCircle(Graphics2D g2d, Circle circle) {
        Ellipse2D circleShape = new Ellipse2D.Float(
                circle.getXPos() - circle.getRadius(),
                circle.getYPos() - circle.getRadius(),
                circle.getRadius() * 2,
                circle.getRadius() * 2);

        drawShape(g2d, circle, circleShape);
    }

    private void drawEllipse(Graphics2D g2d, Ellipse ellipse) {
        Ellipse2D ellipseShape = new Ellipse2D.Float(
                ellipse.getXPos() - ellipse.getRadiusX(),
                ellipse.getYPos() - ellipse.getRadiusY(),
                ellipse.getRadiusX() * 2,
                ellipse.getRadiusY() * 2);

        drawShape(g2d, ellipse, ellipseShape);
    }

    private void drawImage(Graphics2D g2d, de.ur.mi.oop.graphics.Image image) {
        AffineTransform rotatedTransform = getRotationTransformForObject(image);
        rotatedTransform.translate(image.getXPos(), image.getYPos());
        rotatedTransform.scale(1, 1);
        g2d.drawImage(image.getImage(), rotatedTransform, null);
    }

    private void drawLabel(Graphics2D g2d, Label label) {
        AffineTransform originalTransform = g2d.getTransform();
        /*
         * To prevent positioning errors, instead of rotating the current g2d context,
         * we only rotate the label's font.
         */
        Font originalFont = FontPool.getFont(label.getFont(), Font.PLAIN, label.getFontSize());
        g2d.setFont(originalFont.deriveFont(getRotationTransformForObject(label)));
        g2d.setColor(label.getColor().asAWTColor());
        g2d.translate(label.getXPos(), label.getYPos());
        g2d.scale(originalTransform.getScaleX(), originalTransform.getScaleY());
        g2d.drawString(label.getText(), 0, 0);
        g2d.setTransform(originalTransform);
    }

    private void drawLine(Graphics2D g2d, Line line) {
        g2d.setColor(line.getColor().asAWTColor());
        Stroke stroke = new BasicStroke(line.getLineWidth());
        g2d.setStroke(stroke);
        g2d.drawLine(
                (int) line.getXPos(),
                (int) line.getYPos(),
                (int) line.getEndpointX(),
                (int) line.getEndpointY());
    }

    private void drawPieArc(Graphics2D g2d, Arc arc) {
        Arc2D arcShape = new Arc2D.Float(
                arc.getXPos() - arc.getRadius(),
                arc.getYPos() - arc.getRadius(),
                arc.getRadius() * 2, arc.getRadius() * 2,
                arc.getStart(),
                arc.getEnd(),
                Arc2D.PIE);
        drawShape(g2d, arc, arcShape);
    }

    private void drawRectangle(Graphics2D g2d, de.ur.mi.oop.graphics.Rectangle rect) {
        Rectangle2D rectShape = new Rectangle.Float(
                rect.getXPos(),
                rect.getYPos(),
                rect.getWidth(),
                rect.getHeight());

        drawShape(g2d, rect, rectShape);
    }

    private void drawShape(Graphics2D g2d, GraphicsObject graphicsObject, Shape shape) {
        g2d.setPaint(graphicsObject.getColor().asAWTColor());
        g2d.fill(shape);
        if (graphicsObject.getBorderWeight() != 0.f) {
            Stroke stroke = new BasicStroke(graphicsObject.getBorderWeight());
            Color strokeColor = graphicsObject.getBorderColor().asAWTColor();
            g2d.setStroke(stroke);
            g2d.setPaint(strokeColor);
            g2d.draw(shape);
        }
    }

    /**
     * Return an AffineTransform instance to draw a rotated version of an given GraphicsObject.
     *
     * @param object The object to be rotated
     * @return The AffineTransform to be applied before or during drawing
     */
    private AffineTransform getRotationTransformForObject(RotatableGraphicsObject object) {
        double rotationAngleInRadians = object.getRotationAngleInRadians();
        Point rotationOrigin = object.getRotationOrigin();
        return AffineTransform.getRotateInstance(rotationAngleInRadians, rotationOrigin.getXPos(), rotationOrigin.getYPos());
    }

}
