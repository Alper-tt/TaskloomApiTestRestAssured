package taskloom.hooks;

import com.thoughtworks.gauge.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import taskloom.base.AuthContext;

import java.util.Map;

import static io.restassured.RestAssured.given;


public class Hooks {

    @BeforeSuite
    public void beforeSuite() {
        RestAssured.baseURI = System.getenv().getOrDefault("BASE_URL", "http://localhost:8080");
        given()
                .contentType(ContentType.JSON)
                .body(Map.of("username", "taskloom", "mail", "taskloom@test.com", "password", "taskloompass"))
                .when()
                .post("/auth/register");
    }


    @BeforeScenario
    public void beforeScenario() {
    }

    @BeforeSpec
    public void beforeSpec() {
    }

    @AfterStep
    public void afterStep() {
    }

    @AfterScenario
    public void afterScenario() {
    }

    @AfterSuite
    public void afterSuite() {
        AuthContext.clear();
    }
}
