package com.deltixlab.services.impl;

import com.deltixlab.model.Level;
import com.deltixlab.model.db.Event;
import com.deltixlab.model.web.EventFilter;
import com.deltixlab.services.EventsApi;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StubEventsService implements EventsApi {

    private static final Event ALERT_MONTH_AGO_EVENT = new Event()
            .setTimestamp(Date.from(Instant.ofEpochMilli(1470613700271L)))
            .setLevel(Level.ALERT)
            .setDescription("Alert Event");
    private static final Event INFO_THIS_MONTH_EVENT = new Event()
            .setTimestamp(Date.from(Instant.ofEpochMilli(1473613768516L)))
            .setLevel(Level.INFO)
            .setDescription("Info Event");

    @Override
    public List<Event> findAllFiltered(EventFilter filter) {
        return Stream.of(ALERT_MONTH_AGO_EVENT, INFO_THIS_MONTH_EVENT)
                .filter(event -> Objects.isNull(filter.getFrom()) || !event.getTimestamp().before(filter.getFrom()))
                .filter(event -> Objects.isNull(filter.getTo()) || !event.getTimestamp().after(filter.getTo()))
                .filter(event -> Objects.isNull(filter.getLevel()) || event.getLevel() == filter.getLevel())
                .collect(Collectors.toList())
                ;
    }
}
