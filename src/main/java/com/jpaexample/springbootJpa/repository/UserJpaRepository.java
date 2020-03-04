package com.jpaexample.springbootJpa.repository;

import com.jpaexample.springbootJpa.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository  extends JpaRepository<Users, Long> {
    Users findByName(String name);
}
