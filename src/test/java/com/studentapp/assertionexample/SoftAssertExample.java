package com.studentapp.assertionexample;

import com.studentapp.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class SoftAssertExample extends TestBase {

    @Test//if assertion fails, programe exit
    public void hardAssert() {
        given()
                .when()
                .get("/list")
                .then()
                .statusCode(200)
                .body("[0].id", equalTo(4))
                .body("[0].firstName", equalTo("Orson1"))
                .body("[0].lastName", equalTo("Armando"));
    }

    @Test// mutliplt validation on multiplelines
    public void softAssert() {
        given()
                .when()
                .get("/list")
                .then()
                .statusCode(200)
                .body("[0].id", equalTo(4),
                        "[0].firstName", equalTo("Orson1"),
                        "[0].lastName", equalTo("Armando"));
    }
}
