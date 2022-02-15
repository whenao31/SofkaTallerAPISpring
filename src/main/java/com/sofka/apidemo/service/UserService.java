package com.sofka.apidemo.service;

/*
Inside this class the bussines logic is implemented.
 */

import com.sofka.apidemo.model.UserModel;
import com.sofka.apidemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//Service: Set this class as a service for Spring
@Service
public class UserService {

//    Autowired: this annotation is used to auto-configure the repository used by this Service class
    @Autowired
    UserRepository userRepository;

//    Method to retrieve all users in the DB table "user"
    public ArrayList<UserModel> getAllUsers(){
        return (ArrayList<UserModel>)userRepository.findAll();
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }
}
