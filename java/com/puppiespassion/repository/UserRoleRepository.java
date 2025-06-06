package com.puppiespassion.repository;

import com.puppiespassion.model.User;
import com.puppiespassion.model.UserRole;
import com.puppiespassion.model.enums.UserRolesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByUserRole(UserRolesEnum userRolesEnum);
}
