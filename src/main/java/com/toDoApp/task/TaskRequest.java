package com.toDoApp.task;
import com.toDoApp.users.Users;
public class TaskRequest {
    private String taskName;
    private String taskDescription;
    private boolean taskCompleted;
    private int userId;

    public TaskRequest(){}

    public TaskRequest(String taskName, String taskDescription, boolean taskCompleted, int userId){
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskCompleted = taskCompleted;
        this.userId = userId;
    }



    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public boolean isTaskCompleted() {
        return taskCompleted;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setTaskCompleted(boolean taskCompleted) {
        this.taskCompleted = taskCompleted;
    }

    public int getUserId() {return userId;}

    public void setUserId(Integer userId) {this.userId = userId;}
}