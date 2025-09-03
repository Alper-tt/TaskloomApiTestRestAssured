package taskloom.hooks;

import com.thoughtworks.gauge.*;
import io.restassured.RestAssured;

public class Hooks {

    @BeforeSuite
    public void beforeSuite() {
        RestAssured.baseURI = System.getenv().getOrDefault("BASE_URL", "http://localhost:8080");
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
    }
}
