package com.deltixlab.io.web;

import com.deltixlab.model.Level;
import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventControllerTest {

    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    public void listAll() throws Exception {
        when()
                .get("/events")
        .then()
                .body(
                is("[" +
                        "{\"timestamp\":1470613700271,\"description\":\"Alert Event\",\"level\":\"ALERT\"}," +
                        "{\"timestamp\":1473613768516,\"description\":\"Info Event\",\"level\":\"INFO\"}" +
                        "]"
                ));
    }

    @Test
    public void listAllAlertEvents() throws Exception {
        given()
                .param("level", Level.ALERT)
        .when()
                .get("/events")
        .then()
                .body(
                is("[" +
                        "{\"timestamp\":1470613700271,\"description\":\"Alert Event\",\"level\":\"ALERT\"}" +
                        "]"
                ));
    }

    @Test
    public void listAllAlertsFromTheSpecifiedDate() throws Exception {
        given()
                .param("from", 1470613700272L)
        .when()
                .get("/events")
        .then()
                .body(
                is("[" +
                        "{\"timestamp\":1473613768516,\"description\":\"Info Event\",\"level\":\"INFO\"}" +
                        "]"
                ));
    }

    @Test
    public void listAllAlertsInRange() throws Exception {
        given()
                .param("from", 1470613700270L)
                .param("to", 1470613709270L)
        .when()
                .get("/events")
        .then()
                .body(
                is("[" +
                        "{\"timestamp\":1470613700271,\"description\":\"Alert Event\",\"level\":\"ALERT\"}" +
                        "]"
                ));
    }
}