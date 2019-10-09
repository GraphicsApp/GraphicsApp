package de.mi.ur.gpr.graphics;

import de.mi.ur.gpr.app.Config;
import de.mi.ur.gpr.app.GraphicsApp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompoundTest {

    @BeforeEach
    void mockApp() {
        GraphicsApp app = new GraphicsApp() {
            @Override
            public void initialize() {

            }

            @Override
            public void draw() {

            }
        };
        Config config = new Config();
        app.setConfig(config);
    }

    @AfterEach
    void destroyApp() {
        GraphicsApp.getApp().destroy();
    }

    @Test
    void add() {
        Compound compound = new Compound();
        Rectangle rect = new Rectangle(10, 11, 20, 22);
        compound.add(rect);
        assertEquals(1, compound.size());
    }

    @Test
    void addRelative() {
        Compound compound = new Compound(50.f, 60.f);

        Rectangle rect = new Rectangle(0, 0, 20, 22);
        compound.addRelative(rect);
        assertEquals(20.f, compound.getWidth());
        assertEquals(22.f, compound.getHeight());
        assertEquals(50.f, rect.getXPos());
        assertEquals(60.f, rect.getYPos());

        Rectangle anotherRect = new Rectangle(23, 0, 10, 12);
        compound.addRelative(anotherRect);
        assertEquals(33.f, compound.getWidth());
        assertEquals(22.f, compound.getHeight());
        assertEquals(73.f, anotherRect.getXPos());
        assertEquals(60.f, anotherRect.getYPos());

        Rectangle andAnotherRect = new Rectangle(0, 24, 15, 16);
        compound.addRelative(andAnotherRect);
        assertEquals(33.f, compound.getWidth());
        assertEquals(40.f, compound.getHeight());
        assertEquals(50.f, andAnotherRect.getXPos());
        assertEquals(84.f, andAnotherRect.getYPos());
    }

    @Test
    void get() {
        Compound compound = new Compound();
        Rectangle rect = new Rectangle(10, 11, 20, 22);
        compound.add(rect);
        Rectangle getRect = (Rectangle) compound.get(0);
        assertEquals(rect, getRect);
    }

    @Test
    void getObjectAt() {
    }

    @Test
    void testGetObjectAt() {
    }

    @Test
    void removeAll() {
        Compound compound = new Compound();
        Rectangle rect = new Rectangle(10, 11, 20, 22);
        compound.add(rect);
        Rectangle anotherRect = new Rectangle(23, 0, 10, 10);
        compound.add(anotherRect);
        assertEquals(2, compound.size());
        compound.removeAll();
        assertEquals(0, compound.size());
        assertEquals(0, compound.getWidth());
        assertEquals(0, compound.getHeight());
    }

    @Test
    void remove() {
        Compound compound = new Compound();
        Rectangle rect = new Rectangle(10, 11, 20, 22);
        compound.add(rect);
        compound.remove(0);
        assertEquals(0, compound.size());

        compound.add(rect);
        compound.add(rect);
        compound.add(rect);
        assertEquals(3, compound.size());

        compound.remove(2);
        compound.remove(1);
        assertEquals(1, compound.size());
    }

    @Test
    void removeObject() {
        Compound compound = new Compound();
        Rectangle rect = new Rectangle(10, 11, 20, 22);
        compound.add(rect);
        assertEquals(1, compound.size());
        compound.remove(rect);
        assertEquals(0, compound.size());
    }

    @Test
    void getWidth() {
        Compound compound = new Compound();
        assertEquals(0.f, compound.getWidth());

        Rectangle rect = new Rectangle(0, 0, 20, 22);
        compound.addRelative(rect);
        assertEquals(20.f, compound.getWidth());

        Rectangle anotherRect = new Rectangle(23, 0, 10, 10);
        compound.addRelative(anotherRect);
        assertEquals(33.f, compound.getWidth());

        compound.removeAll();
        assertEquals(0.f, compound.getWidth());
    }

    @Test
    void getHeight() {
        Compound compound = new Compound();
        assertEquals(0.f, compound.getHeight());

        Rectangle rect = new Rectangle(0, 0, 20, 22);
        compound.addRelative(rect);
        assertEquals(22.f, compound.getHeight());

        Rectangle anotherRect = new Rectangle(0, 24, 10, 10);
        compound.addRelative(anotherRect);
        assertEquals(34.f, compound.getHeight());

        compound.removeAll();
        assertEquals(0.f, compound.getHeight());
    }

    @Test
    void setXPos() {
        Compound compound = new Compound();
        compound.setXPos(10.f);
        assertEquals(10.f, compound.getXPos());
    }

    @Test
    void setYPos() {
        Compound compound = new Compound();
        compound.setYPos(10.f);
        assertEquals(10.f, compound.getYPos());
    }

    @Test
    void setPosition() {
        Compound compound = new Compound();
        compound.setPosition(10.f, 20.f);
        assertEquals(10.f, compound.getXPos());
        assertEquals(20.f, compound.getYPos());
    }

    @Test
    void move() {
        Compound compound = new Compound();
        compound.setPosition(10.f, 20.f);
        compound.move(1.f, 2.f);
        assertEquals(11.f, compound.getXPos());
        assertEquals(22.f, compound.getYPos());
    }

    @Test
    void hitTest() {
    }
}