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
//    @RequestBody: It indicates that the parameter this method uses is in the body of the HTTP request.
    public UserModel saveUser(@RequestBody UserModel user){
//        Validates the priority value is in the range 1-5
        return ((user.getPriority() >= 1) && (user.getPriority() <= 5)) ? userService.saveUser(user) : user;
    }

//   When a GET request is made and the "id" is contained in the path it calls this method
    @GetMapping( path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){
//        It retrieves the user by using its "id"
        return userService.getById(id);
    }

//    GET request made to the path "/query" and the parameters come as Request Parameters
    @GetMapping("/query")
    public ArrayList<UserModel> getUserByPriority(@RequestParam(name = "priority", required = false) Integer priority, @RequestParam(value = "gender", required = false) Character gender){
//This method will retrieve users by gender just in case no priority is given.
        if (priority == null && (gender.equals('F') || gender.equals('M'))){
////        It retrieves users by "gender" attribute
            return userService.getByGender(gender);
        }
        //        It retrieves the user by using its "priority"
        return userService.getByPriority(priority);
    }

//    DELETE request that executes the "removeById" method and receives the "id" in the path
    @DeleteMapping(path="/{id}")
    public String removeById(@PathVariable("id") Long id){
        boolean ok = userService.deleteUser(id);
        if (ok){
            return "User with id " + id + " removed.";
        }else {
            return "User with id " + id + ", could not be removed.";
        }
    }

//    //    GET request made to the path "/query" and the parameters come as Request Parameters
//    @GetMapping("/query")
//    public ArrayList<UserModel> getUserByGender(@RequestParam("gender") Character gender){
////        It retrieves users by "gender" attribute
//        return userService.getByGender(gender);
//    }

//    GET request to retrieve all the users ordered by name
    @GetMapping("/nameordered")
    public ArrayList<UserModel> getOrderedByName(){
        return userService.getUsersOrderedByName();
    }
}
