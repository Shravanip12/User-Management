package com.Entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepo extends CrudRepository<User, Integer>{

}
