package com.example.security.domain.repository;

import com.example.security.domain.entity.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleUserRepository extends JpaRepository<RoleUser, Long> {
}
