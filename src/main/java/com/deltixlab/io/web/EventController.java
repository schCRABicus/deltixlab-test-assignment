package com.deltixlab.io.web;

import com.deltixlab.model.web.EventData;
import com.deltixlab.model.web.EventFilter;
import com.deltixlab.services.EventsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventsApi eventsApi;

    /**
     * Handles requests to the endpoint specified below:
     * <p />
     * GET /events.
     * GET /events?from=1470613400273
     * GET /events?from=1470613400273&to=1473613768517
     * GET /events?level=INFO
     *
     * <p />
     * See {@link com.deltixlab.io.web.EventControllerTest} test methods for details.
     *
     * @return Null-safe list of all available events.
     */
    @GetMapping
    public List<EventData> listFiltered(@ModelAttribute EventFilter filter) {
        return Optional.ofNullable(eventsApi.findAllFiltered(filter)).orElseGet(Collections::emptyList)
                .stream()
                .map(EventData::new)
                .collect(Collectors.toList())
                ;
    }
}
