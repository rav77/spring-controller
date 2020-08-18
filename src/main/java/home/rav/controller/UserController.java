package home.rav.controller;

import home.rav.model.User;
import home.rav.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String getInfo() {
        return "My users controller";
    }

    @GetMapping("/get")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/get/{id}")
    public User getUserByPath(@PathVariable int id) {
        return userService.getUser(id);
    }

    @GetMapping(value = "/get", params = "id")
    public User getUserByParam(@RequestParam int id) {
        return userService.getUser(id);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping("/del")
    public void delAllUsers() {
        userService.delAllUsers();
    }

    @DeleteMapping("/del/{id}")
    public void delUserByPath(@PathVariable int id) {
        userService.delUser(id);
    }

    @DeleteMapping(value = "/del", params = "id")
    public User delUserByParam(@PathVariable int id) {
        return userService.delUser(id);
    }

}
