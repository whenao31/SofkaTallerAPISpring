package com.sofka.apidemo.service;

/*
Inside this class the bussines logic is implemented.
 */

import com.sofka.apidemo.model.UserModel;
import com.sofka.apidemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

//Service: Set this class as a service for Spring
@Service
public class UserService {

//    Autowired: this annotation is used to auto-configure the repository used by this Service class
    @Autowired
    UserRepository userRepository;

//    Method to retrieve all users in the DB table "user" by using the Crud form the repository
    public ArrayList<UserModel> getAllUsers(){
        return (ArrayList<UserModel>)userRepository.findAll();
    }

//    Method to save a User in the DB table "user" by using the Crud from the repository
    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

//    Method to read a User by id by using the Crud form the repository. It might return a null.
    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }

//    Method to get a User by its priority by using the Crud from the repository.
    public ArrayList<UserModel> getByPriority(Integer priority){
        return  userRepository.findByPriority(priority);
    }

//    Method to remove a User by its id making use of the Crud from the repository.
    public boolean deleteUser(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

//    Method to get Users by its gender by using the Crud from the repository.
    public ArrayList<UserModel> getByGender(Character gender){
        return userRepository.findByGender(gender);
    }

//    Method to obtain users ordered by its name.
    public ArrayList<UserModel> getUsersOrderedByName(){
        return userRepository.findByOrderByName();
    }
}
