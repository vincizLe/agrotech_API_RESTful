package com.agrotech.agrotech.domain.repository;

import com.agrotech.agrotech.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
    //Page<User>findAll(Pageable pageable);
}
