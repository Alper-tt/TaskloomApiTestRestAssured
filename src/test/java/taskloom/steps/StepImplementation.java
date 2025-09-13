package taskloom.steps;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import taskloom.base.AuthMethods;
import taskloom.base.UserMethods;
import taskloom.model.request.*;
import taskloom.base.TaskMethods;

public class StepImplementation {

    TaskMethods taskMethods = new TaskMethods();
    UserMethods userMethods = new UserMethods();
    AuthMethods authMethods = new AuthMethods();
    Response response;

    @Step("Make login request <table>")
    public void login(Table table) {
        response = authMethods.login(table);
    }

    @Step("Make register request <table>")
    public void register(Table table){
        response = authMethods.register(table);
    }

    @Step("Create task that <table>")
    public void createTask(Table table) {
        response = taskMethods.createTask(table);
    }

    @Step("Response status code should be <statusCode>")
    public void checkStatusCode(Integer statusCode) {
        Assertions.assertEquals(statusCode, response.getStatusCode());
    }

    @Step("Response type should be <type>")
    public void checkResponseType(String type) {
    }

    @Step("<field> should be <value> in response")
    public void checkField(String field, String value) {
        Assertions.assertEquals(value, response.then().extract().path(field).toString());
    }

    @Step("Delete task by id <id>")
    public void deleteTask(Integer id){
        response = taskMethods.deleteTaskById(id);
    }

    @Step("Update task that <table>")
    public void updateTask(Table table) {

        response = taskMethods.updateTask(table);
    }

    @Step("Get task by id <id>")
    public void getTaskById(Integer id){
        response = taskMethods.getTaskById(id);
    }

    @Step("Get all tasks")
    public void getAllTasks(){
        response = taskMethods.getAllTasks();
    }

    @Step("Patch task by id <table>")
    public void changeTaskStatusById(Table table){
        response = taskMethods.updateTaskStatus(table);
    }

    @Step("Create user that <table>")
    public void createUser(Table table){
        UserCreateRequest userCreateRequest = new UserCreateRequest(
                table.getColumnValues("username").get(0),
                table.getColumnValues("mail").get(0)
        );
        response = userMethods.createUser(userCreateRequest);
    }

    @Step("Update user that <table>")
    public void updateUser(Table table){
        response = userMethods.updateUser(table);
    }

    @Step("Delete user by id <id>")
    public void deleteUser(Integer id){
        response = userMethods.deleteUserById(id);
    }

    @Step("Get all users")
    public void getAllUsers(){
        response = userMethods.getAllUsers();
    }

    @Step("Get user by id <id>")
    public void getUserById(Integer id){
        response = userMethods.getUserById(id);
    }

    @Step("Get user by username <username>")
    public void getUserByUsername(String username){
        response = userMethods.getUserByUsername(username);
    }

    @Step("Get user by mail <mail>")
    public void getUserByMail(String mail){
        response = userMethods.getUserByMail(mail);
    }

    @Step("Get tasks of user by user id <id>")
    public void getTasksOfUserById(Integer id){
        response = userMethods.getTasksOfUserById(id);
    }
}
