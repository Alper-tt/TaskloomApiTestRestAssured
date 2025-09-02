package taskloom.model.request;

import lombok.Getter;
import lombok.Setter;
import taskloom.model.TaskStatus;

@Getter
@Setter
public class TaskStatusUpdate{
    TaskStatus taskStatus;
}
