package taskloom.base;

import com.thoughtworks.gauge.Table;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import taskloom.model.request.UserCreateRequest;
import taskloom.model.request.UserUpdateRequest;

import static io.restassured.RestAssured.given;

public class UserMethods extends BaseTest{

    public Response createUser(UserCreateRequest userCreateRequest) {
        return given()
                .spec(requestSpec)
                .contentType(ContentType.JSON)
                .body(userCreateRequest)
                .when()
                .post("/user");
    }

    public Response updateUser(Table table) {
        UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
        userUpdateRequest.setUsername(table.getColumnValues("username").get(0));
        userUpdateRequest.setMail(table.getColumnValues("mail").get(0));
        int id = Integer.parseInt(table.getColumnValues("id").get(0));
        return given()
                .spec(requestSpec)
                .contentType(ContentType.JSON)
                .body(userUpdateRequest)
                .when()
                .put("/user/"+id);
    }

    public Response deleteUserById(Integer id){
        return given()
                .spec(requestSpec)
                .when()
                .delete("/user/"+id);
    }

    public Response getUserById(Integer id){
        return given()
                .spec(requestSpec)
                .when()
                .get("/user/"+id);
    }

    public Response getAllUsers(){
        return given()
                .spec(requestSpec)
                .when()
                .get("/user");
    }

    public Response getUserByUsername(String username){
        return given()
                .spec(requestSpec)
                .when()
                .get("/user/username/"+username);
    }

    public Response getUserByMail(String mail){
        return given()
                .spec(requestSpec)
                .when()
                .get("/user/mail/"+mail);
    }

    public Response getTasksOfUserById(Integer id){
        return given()
                .spec(requestSpec)
                .when()
                .get("/user/"+id+"/tasks");
    }
}
