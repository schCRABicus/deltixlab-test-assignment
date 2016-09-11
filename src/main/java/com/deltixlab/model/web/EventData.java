package com.deltixlab.model.web;

import com.deltixlab.model.Level;
import com.deltixlab.model.db.Event;

import java.util.Date;
import java.util.Optional;

/**
 * UI representation of {@link Event} instance.
 */
public class EventData {
    private final Event event;

    public EventData() {
        this.event = new Event();
    }

    public EventData(Event event) {
        this.event = Optional.ofNullable(event).orElseGet(Event::new);
    }

    public Date getTimestamp() {
        return event.getTimestamp();
    }

    public EventData setTimestamp(Date timestamp) {
        event.setTimestamp(timestamp);
        return this;
    }

    public Level getLevel() {
        return event.getLevel();
    }

    public EventData setLevel(Level level) {
        event.setLevel(level);
        return this;
    }

    public String getDescription() {
        return event.getDescription();
    }

    public EventData setDescription(String description) {
        event.setDescription(description);
        return this;
    }
}
