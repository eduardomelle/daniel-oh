package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("Hola xGeek!"));
    }

    @Test
    public void testGreetingEndpoint() {
        given().when().get("/hello/greeting").then().statusCode(200).body(is("Kube Native Java with Quarkus3"));
    }

}