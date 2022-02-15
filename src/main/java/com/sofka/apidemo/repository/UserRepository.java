package com.sofka.apidemo.repository;

/*
This interface is the bridge between the bussiness logic(Services) and the data layer.
Here you can have different data sources
 */

import com.sofka.apidemo.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Repository: Indicates this interface is a data access point
@Repository
//this interface is created to carry out the CRUD to the UserModel associated with te db table "user"
public interface UserRepository extends CrudRepository<UserModel, Long> {
}
