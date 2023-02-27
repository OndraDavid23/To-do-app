package com.toDoApp.task;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.toDoApp.users.Users;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Task {
    @Id
    @SequenceGenerator(
            name = "to_do_id_sequence",
            sequenceName = "to_do_id_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy =GenerationType.SEQUENCE,
            generator = "to_do_id_sequence"
    )


    private int id;
    private String name;
    private String description;
    private Boolean complete;
    //@JsonIgnoreProperties("tasks")
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value={"tasks", "aboutMe", "email","name"})
    private Users user;

    public Task(Integer id, String name, String description, Boolean complete, Users user){
        this.id = id;
        this.name = name;
        this.description = description;
        this.complete = complete;
        this.user = user;
    }

    public Task(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {this.description = description;}
    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public Users getUser() {return user;}

    public void setUser(Users user) {this.user = user;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(name, task.name) && Objects.equals(description, task.description) && Objects.equals(complete, task.complete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, complete);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", complete=" + complete +
                '}';
    }
}