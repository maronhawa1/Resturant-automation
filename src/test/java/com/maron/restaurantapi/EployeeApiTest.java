package com.maron.restaurantapi;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.util.Scanner;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EployeeApiTest {
    private final String BASE_URI = "http://localhost:9090";
    private final String USERNAME = "admin";
    private final String PASSWORD = "1234";

    @Test(description = "Verify that GET returns a list of Employees")
    @Severity(SeverityLevel.NORMAL)
    @Story("Get all Employees")
    public void testGetAllEmployees() {
        baseURI = BASE_URI;

        given()
                .auth().preemptive().basic(USERNAME, PASSWORD)
                .log().all()
                .when()
                .get("/api/employees")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(description ="Test for add new employee")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Add new employee")
    public void testAddEmployee() {

                baseURI = BASE_URI;

        given()
                .auth().preemptive().basic(USERNAME, PASSWORD)
                .header("Content-Type", "application/json")
                .body("[{ \"name_employee\": \"Edward Hawa\", \"email_employee\": \"eli@gmail.com\" , \"phone_employee\" : \"050123456\" , \"role_employee\" : \"Waiter\" }]")
                .log().all()
                .when()
                .post("/api/employees")
                .then()
                .log().all()
                .statusCode(200)
                .body("[0].name_employee", equalTo("Edward Hawa"));


    }

}
