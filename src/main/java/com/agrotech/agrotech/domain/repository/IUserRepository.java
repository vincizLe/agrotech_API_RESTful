package com.agrotech.agrotech.domain.repository;

import com.agrotech.agrotech.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Long> {
    //Page<User>findAll(Pageable pageable);
    Optional<User>findByEmailAndPassword(String email,String password);
}
