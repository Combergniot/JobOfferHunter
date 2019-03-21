package com.gus.jobofferhunter.model.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RoleRepository extends CrudRepository<Role, Long> {
    @Query("select r from Role r inner join r.users u where u.username = ?1")
    Set<Role> findRolesByUsername(String username);
}
