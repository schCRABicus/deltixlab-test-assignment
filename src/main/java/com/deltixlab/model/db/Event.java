package com.deltixlab.model.db;

import com.deltixlab.model.Level;

import java.util.Date;

public class Event {

    private Date timestamp;
    private Level level;
    private String description;

    public Date getTimestamp() {
        return timestamp;
    }

    public Event setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public Event setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Event setDescription(String description) {
        this.description = description;
        return this;
    }
}
