package com.maron.restaurantapi;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Epic("Restaurant API")
@Feature("Dish Management")
public class DishApiTest {

    private final String BASE_URI = "http://localhost:9090";
    private final String USERNAME = "admin";
    private final String PASSWORD = "1234";

    @Test(description = "Test for gell all dishes")
    @Severity(SeverityLevel.NORMAL)
    @Story("Get all dishes")
    public void testGetAllDishes() {
        baseURI = BASE_URI;

        given()
                .auth().preemptive().basic(USERNAME, PASSWORD)
                .log().all()
                .when()
                .get("/api/dishes")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(description = "Test add dish successful")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Add new dish")
    public void testAddDish() {
        baseURI = BASE_URI;

        given()
                .auth().preemptive().basic(USERNAME, PASSWORD)
                .header("Content-Type", "application/json")
                .body("{ \"name\": \"kharouf\", \"price\": 65.0 }")
                .log().all()
                .when()
                .post("/api/dishes")
                .then()
                .log().all()
                .statusCode(200)
                .body("name", equalTo("kharouf"));
    }
}

    