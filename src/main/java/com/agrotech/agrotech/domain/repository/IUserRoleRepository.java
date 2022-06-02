package com.agrotech.agrotech.domain.repository;

import com.agrotech.agrotech.domain.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRoleRepository extends JpaRepository<UserRole,Long> {
}
