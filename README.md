# deltixlab-test-assignment

# Execute the following command to launch the application:
```
mvn clean install spring-boot:run
```

# The following endpoints will be  available:


* [All events list](http://localhost:8080/events)
* [All events in time range from Mon Aug 08 2016 02:48:20 GMT+0300 to Mon Aug 08 2016 02:48:29 GMT+0300](http://localhost:8080/events?from=1470613700270&to=1470613709270)
* [All events since Mon Aug 08 2016 02:48:20 GMT+0300](http://localhost:8080/events?from=1470613700272)
* [All events with 'INFO' level](http://localhost:8080/events?level=INFO)

and any combination of the above filter parameters.