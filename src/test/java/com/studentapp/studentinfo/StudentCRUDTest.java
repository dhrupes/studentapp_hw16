package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class StudentCRUDTest extends TestBase {


    @Test// get full list
    public void test001() {
        Response response=given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test// post new data and retrive id
    public void test002() {
        List<String> courses=new ArrayList<>();
        courses.add("javaa");
        courses.add("seleniumm");
        courses.add("restassuredd");

        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setFirstName("Rinkeshh");
        studentPojo.setLastName("patel");
        studentPojo.setEmail("abdc@gmail.com");
        studentPojo.setProgramme("apii testing");
        studentPojo.setCourses(courses);

        Response response=given()
                .header("Content-Type","application/json")
                .body(studentPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();


    }

    @Test// update data with id
    public void test003() {

        StudentPojo studentPojo=new StudentPojo();
        //  studentPojo.setFirstName("deep11");
        studentPojo.setEmail("xyz0112@gmail.com");
        studentPojo.setProgramme("Automation testing");

        Response response=given()
                .header("Content-Type","application/json")
                .pathParam("id","105")
                .body(studentPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test // delete above id
    public void test004() {
        Response response=given()
                .pathParam("id","105")
                .when()
                .delete("/{id}");
        response.then().statusCode(204);
        response.prettyPrint();

    }

    @Test // retrieve id and validate id has delete
    public void test005() {
        Response response =given()
                .pathParam("id","105")
                .when()
                .get("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();

    }


}
