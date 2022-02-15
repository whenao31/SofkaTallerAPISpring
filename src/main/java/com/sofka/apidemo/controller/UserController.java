package com.sofka.apidemo.controller;

import com.sofka.apidemo.model.UserModel;
import com.sofka.apidemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


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
}
