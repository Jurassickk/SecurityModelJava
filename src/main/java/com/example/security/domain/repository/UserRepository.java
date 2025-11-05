package com.example.security.domain.repository;

import com.example.security.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query("SELECT r.name FROM User u JOIN u.roleUsers ru JOIN ru.role r WHERE u.email = :email")
    List<String> findRolesByUserEmail(String email);
}
