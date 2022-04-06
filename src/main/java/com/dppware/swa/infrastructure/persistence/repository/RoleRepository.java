package com.dppware.swa.infrastructure.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dppware.swa.infrastructure.persistence.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

	Role findByName(@Param("name") String name);
	

}
