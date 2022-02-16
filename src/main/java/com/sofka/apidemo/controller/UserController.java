package com.sofka.apidemo.controller;

import com.sofka.apidemo.model.UserModel;
import com.sofka.apidemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


//RestController: label that provides REST capabilities to this class
@RestController
//RequestMapping: annotation used to set the address or starting point in order to get different resources
@RequestMapping("/user")
public class UserController {
//    Autowired: this annotation is used to auto-configure the service used by this controller class
    @Autowired
    UserService userService;

//    GetMapping: It makes a call to the method as a GET request is made
    @GetMapping()
    public ArrayList<UserModel> getUsers(){
        return userService.getAllUsers();
    }
//    PostMapping: It makes a call to the method as a POST request is made
    @PostMapping()
//    @RequestBody: It indicates that the paramether this method uses is in the body of the HTTP request.
    public UserModel saveUser(@RequestBody UserModel user){
        return userService.saveUser(user);
    }

//   When a GET request is made and the "id" is contained in the path it calls this method
    @GetMapping( path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){
//        It retrieves the user by using its "id"
        return this.userService.getById(id);
    }

//    GET request made to the path "/query" and the parameters come as Request Parameters
    @GetMapping("/query")
    public ArrayList<UserModel> getUserByPriority(@RequestParam("priority") Integer priority){
//        It retrieves the user by using its "priority"
        return this.userService.getByPriority(priority);
    }

//    DELETE request that executes the "removeById" method and receives the "id" in the path
    @DeleteMapping(path="/{id}")
    public String removeById(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        if (ok){
            return "User with id " + id + " removed.";
        }else {
            return "User with id " + id + ", could not be removed.";
        }
    }
}
