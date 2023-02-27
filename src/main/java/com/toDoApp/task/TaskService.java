package com.toDoApp.task;
import com.toDoApp.users.UserRepository;
import com.toDoApp.users.Users;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Integer id){
        return taskRepository.findById(id).orElse(null);
    }
    public void addTask(TaskRequest request){
        Optional<Users> userOptional = userRepository.findById(request.getUserId());
        if (!userOptional.isPresent()) {
            throw new IllegalArgumentException("User not found!!!!!!" + request.getUserId());
        }

        Users user = userOptional.get();
        Task task = new Task();
        task.setName(request.getTaskName());
        task.setDescription(request.getTaskDescription());
        task.setComplete(request.isTaskCompleted());
        task.setUser(user);
        taskRepository.save(task);
    }

    public void updateTask(Task task){
        taskRepository.save(task);
    }
    public void deleteTask(Integer id){
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
        }
        else{
            throw new NoSuchElementException();
        }
    }

}