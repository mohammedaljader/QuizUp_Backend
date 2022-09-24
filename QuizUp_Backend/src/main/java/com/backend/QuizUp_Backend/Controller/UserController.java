package com.backend.QuizUp_Backend.Controller;

import com.backend.QuizUp_Backend.Dto.UserDto;
import com.backend.QuizUp_Backend.Service.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllCategories() {
        List<UserDto> users = userService.getAllUsers();
        if(users != null) {
            return ResponseEntity.ok().body(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String id) {
        UserDto user = userService.getUserById(id);
        if(user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody UserDto user) {
        if (!userService.addUser(user)){
            return ResponseEntity.badRequest().body("Cannot add the user "+ user.getFullName()+ " , please try again");
        } else {
            return ResponseEntity.ok().body("User is added successfully!!");
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        boolean result = userService.deleteUser(id);
        if(result){
            return ResponseEntity.ok().body("User is deleted successfully!!");
        }
        else{
            return ResponseEntity.badRequest().body("Cannot delete the user, Please provide a valid id!");
        }
    }

    @PutMapping("/user")
    public ResponseEntity<String> updateUser(@RequestBody UserDto user) {
        if (userService.updateUser(user)) {
            return ResponseEntity.ok().body("User is edited successfully!!");
        } else {
            return ResponseEntity.badRequest().body("Cannot update the user, Please provide a valid id!");
        }
    }
}
