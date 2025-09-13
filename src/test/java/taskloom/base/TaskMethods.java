package taskloom.base;

import com.thoughtworks.gauge.Table;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import taskloom.model.TaskStatus;
import taskloom.model.request.TaskCreateRequest;
import taskloom.model.request.TaskStatusUpdate;
import taskloom.model.request.TaskUpdateRequest;

import static io.restassured.RestAssured.given;

public class TaskMethods extends BaseTest {

    public Response createTask(Table table) {
        TaskCreateRequest createRequest = new TaskCreateRequest();

        createRequest.setTitle(table.getColumnValues("title").get(0));
        createRequest.setDescription(table.getColumnValues("description").get(0));
        if (!table.getColumnValues("status").isEmpty()){
            createRequest.setStatus(TaskStatus.valueOf(table.getColumnValues("status").get(0)));
        }
        if (!table.getColumnValues("assignedUserId").isEmpty()){
            createRequest.setAssignedUserId(Integer.parseInt(table.getColumnValues("assignedUserId").get(0)));
        }
        return given()
                .spec(requestSpec)
                .contentType(ContentType.JSON)
                .body(createRequest)
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

    public Response updateTaskStatus(Table table) {
        TaskStatusUpdate taskStatusUpdate = new TaskStatusUpdate();
        taskStatusUpdate.setTaskStatus(TaskStatus.valueOf(table.getColumnValues("status").get(0)));
        int id = Integer.parseInt(table.getColumnValues("id").get(0));
        return given()
                .spec(requestSpec)
                .contentType(ContentType.JSON)
                .body(taskStatusUpdate)
                .when()
                .patch("/tasks/"+id+"/status");
    }

    public Response updateTask(Table table) {
        TaskUpdateRequest updateRequest = new TaskUpdateRequest();

        updateRequest.setTitle(table.getColumnValues("title").get(0));
        updateRequest.setDescription(table.getColumnValues("description").get(0));
        updateRequest.setStatus(TaskStatus.valueOf(table.getColumnValues("status").get(0)));
        if (!table.getColumnValues("assignedUserId").isEmpty()){
            updateRequest.setAssignedUserId(Integer.parseInt(table.getColumnValues("assignedUserId").get(0)));
        }
        int id = Integer.parseInt(table.getColumnValues("id").get(0));

        return given()
                .contentType(ContentType.JSON)
                .spec(requestSpec)
                .body(updateRequest)
                .when()
                .put("tasks/" + id);
    }
}
