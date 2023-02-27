package com.toDoApp.task;
import com.toDoApp.users.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/toDo")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping
    public void createTask(@RequestBody TaskRequest request){
        taskService.addTask(request);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer id){
        try{
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
        }
        catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public void updateTask(@PathVariable Integer id, @RequestBody TaskRequest request){
        Task task = taskService.getTaskById(id);
        task.setName(request.getTaskName());
        task.setDescription(request.getTaskDescription());
        task.setComplete(request.isTaskCompleted());
        taskService.updateTask(task);
    }
}