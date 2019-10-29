package de.ur.mi.oop.events;

/**
 * Elternklasse für Tasten- und Mausevents.
 */
public class Event {

    public final long timestamp;

    public Event(long timestamp) {
        this.timestamp = timestamp;
    }
}
