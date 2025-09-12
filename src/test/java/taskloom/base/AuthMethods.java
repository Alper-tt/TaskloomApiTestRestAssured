package taskloom.base;

import com.thoughtworks.gauge.Table;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import taskloom.model.request.LoginRequest;
import taskloom.model.request.RegisterRequest;

import static io.restassured.RestAssured.given;

public class AuthMethods extends BaseTest{

    public Response register(Table table) {
        RegisterRequest registerRequest = new RegisterRequest(
                table.getColumnValues("username").get(0),
                table.getColumnValues("mail").get(0),
                table.getColumnValues("password").get(0)
        );
        return given()
                .spec(requestSpec)
                .contentType(ContentType.JSON)
                .body(registerRequest)
                .when()
                .post("/auth/register");
    }

    public Response login(Table table) {
        LoginRequest loginRequest = new LoginRequest(
                table.getColumnValues("username").get(0),
                table.getColumnValues("password").get(0)
        );
        return given()
                .spec(requestSpec)
                .contentType(ContentType.JSON)
                .body(loginRequest)
                .when()
                .post("/auth/login");
    }
}