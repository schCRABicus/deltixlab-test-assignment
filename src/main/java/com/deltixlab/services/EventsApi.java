package com.deltixlab.services;

import com.deltixlab.model.db.Event;
import com.deltixlab.model.web.EventFilter;

import java.util.List;

public interface EventsApi {

    List<Event> findAllFiltered(EventFilter filter);
}
