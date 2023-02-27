package com.toDoApp.users;
import java.util.List;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/toDo/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Users> getUser(){return userService.getAllUsers();}

    @PostMapping
    public void addUser(@RequestBody UserRequest request){
        Users users = new Users();
        users.setName(request.getUserName());
        users.setEmail(request.getUserEmail());
        userService.addUser(users);
    }
}
