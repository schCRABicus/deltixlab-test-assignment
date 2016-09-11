package com.deltixlab.model.web;

import com.deltixlab.model.Level;

import java.util.Date;
import java.util.Optional;

public class EventFilter {

    private Date from;
    private Date to;
    private Level level;

    public Date getFrom() {
        return from;
    }

    public EventFilter setFrom(Long from) {
        this.from = Optional.ofNullable(from).map(Date::new).orElse(null);
        return this;
    }

    public Date getTo() {
        return to;
    }

    public EventFilter setTo(Long to) {
        this.to = Optional.ofNullable(to).map(Date::new).orElse(null);
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public EventFilter setLevel(Level level) {
        this.level = level;
        return this;
    }
}
