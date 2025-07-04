package com.maron.restaurantapi;

import static io.restassured.RestAssured.*;

public class TestConsole {
    public static void main(String[] args) {
        baseURI = "http://localhost:9090";

        given()
                .auth().preemptive().basic("admin", "1234")
                .log().all()
                .when()
                .get("/api/dishes")
                .then()
                .log().all()
                .statusCode(200);

    }
}
