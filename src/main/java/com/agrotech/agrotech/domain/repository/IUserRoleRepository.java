package com.agrotech.agrotech.domain.repository;

import com.agrotech.agrotech.domain.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRoleRepository extends JpaRepository<UserRole,Long> {
    Optional<UserRole>findByUserId(Long userId);
}
