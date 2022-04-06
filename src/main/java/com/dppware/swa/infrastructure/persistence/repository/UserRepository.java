package com.dppware.swa.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dppware.swa.infrastructure.persistence.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(@Param("email") String email);
	
	User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	
    List<User> findByName(@Param("name") String name);
    
    List<User> findAllByHobbiesContaining(@Param("hobbies") String hobbies);
}
