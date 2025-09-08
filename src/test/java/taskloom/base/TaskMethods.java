package taskloom.base;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import taskloom.model.request.TaskCreateRequest;
import taskloom.model.request.TaskStatusUpdate;
import taskloom.model.request.TaskUpdateRequest;

import static io.restassured.RestAssured.given;

public class TaskMethods extends BaseTest {

    public Response createTask(TaskCreateRequest taskCreateRequest) {
        return given()
                .spec(requestSpec)
                .contentType(ContentType.JSON)
                .body(taskCreateRequest)
                .when()
                .post("/tasks");
    }

    public Response getAllTasks() {
        return given()
                .spec(requestSpec)
                .when()
                .get("/tasks");
    }

    public Response getTaskById(Integer id) {
        return given()
                .spec(requestSpec)
                .when()
                .get("/tasks/" + id);
    }

    public Response deleteTaskById(Integer id){
        return given()
                .spec(requestSpec)
                .when()
                .delete("/tasks/" + id);
    }

    public Response updateTaskStatus(Integer id, TaskStatusUpdate taskStatusUpdate) {
        return given()
                .spec(requestSpec)
                .contentType(ContentType.JSON)
                .body(taskStatusUpdate)
                .when()
                .patch("/tasks/"+id+"/status");
    }

    public Response updateTask(Integer id, TaskUpdateRequest taskUpdateRequest) {
        return given()
                .contentType(ContentType.JSON)
                .spec(requestSpec)
                .body(taskUpdateRequest)
                .when()
                .put("tasks/" + id);
    }
}
