package taskloom.steps;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import taskloom.base.UserMethods;
import taskloom.model.TaskStatus;
import taskloom.model.request.*;
import taskloom.base.TaskMethods;

public class StepImplementation {

    TaskMethods taskMethods = new TaskMethods();
    UserMethods userMethods = new UserMethods();
    Response response;

    @Step("Create task that <table>")
    public void createTask(Table table) {
        TaskCreateRequest createRequest = new TaskCreateRequest();

        createRequest.setTitle(table.getColumnValues("title").get(0));
        createRequest.setDescription(table.getColumnValues("description").get(0));
        if (!table.getColumnValues("status").isEmpty()){
            createRequest.setStatus(TaskStatus.valueOf(table.getColumnValues("status").get(0)));
        }
        if (!table.getColumnValues("assignedUserId").isEmpty()){
            createRequest.setAssignedUserId(Integer.parseInt(table.getColumnValues("assignedUserId").get(0)));
        }
        response = taskMethods.createTask(createRequest);
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
        TaskUpdateRequest updateRequest = new TaskUpdateRequest();

        updateRequest.setTitle(table.getColumnValues("title").get(0));
        updateRequest.setDescription(table.getColumnValues("description").get(0));
        updateRequest.setStatus(TaskStatus.valueOf(table.getColumnValues("status").get(0)));
        if (!table.getColumnValues("assignedUserId").isEmpty()){
            updateRequest.setAssignedUserId(Integer.parseInt(table.getColumnValues("assignedUserId").get(0)));
        }
        response = taskMethods.updateTask(Integer.parseInt(table.getColumnValues("id").get(0)), updateRequest);
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
        TaskStatusUpdate taskStatusUpdate = new TaskStatusUpdate();
        taskStatusUpdate.setTaskStatus(TaskStatus.valueOf(table.getColumnValues("status").get(0)));

        response = taskMethods.updateTaskStatus(Integer.parseInt(table.getColumnValues("id").get(0)), taskStatusUpdate);
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
        UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
        userUpdateRequest.setUsername(table.getColumnValues("username").get(0));
        userUpdateRequest.setMail(table.getColumnValues("mail").get(0));
        Integer id = Integer.parseInt(table.getColumnValues("id").get(0));
        response = userMethods.updateUser(id, userUpdateRequest);
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
