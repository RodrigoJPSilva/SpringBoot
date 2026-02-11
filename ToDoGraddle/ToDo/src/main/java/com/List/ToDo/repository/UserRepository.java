package com.List.ToDo.repository;

import com.List.ToDo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findById(Long id);
    User findByEmail(String email);
}
