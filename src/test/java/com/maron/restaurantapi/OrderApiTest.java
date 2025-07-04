package com.maron.restaurantapi;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Epic("Restaurant API")
@Feature("Order Management")
public class OrderApiTest {

    private final String BASE_URI = "http://localhost:9090"; // שנה לפורט שלך אם שונה

    @Test(description = "Place order with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Create order")
    public void testPlaceOrder() {
        baseURI = BASE_URI;

        // קודם כל ניצור מנה חדשה
        int dishId = given()
                .auth().preemptive().basic("admin", "1234")
                .header("Content-Type", "application/json")
                .body("{ \"name\": \"Pizza Margherita\", \"price\": 48.0 }")
                .when()
                .post("/api/dishes")
                .then()
                .statusCode(200)
                .extract()
                .path("id");

        // עכשיו ניצור הזמנה חדשה עם אותה מנה
        given()
                .auth().preemptive().basic("admin", "1234")
                .header("Content-Type", "application/json")
                .body("{ \"customerId\": 1, \"dishIds\": [" + dishId + "], \"total\": 48.0 }")

                .log().all()
                .when()
                .post("/api/orders")
                .then()
                .log().all()
                .statusCode(200);


    }
}
