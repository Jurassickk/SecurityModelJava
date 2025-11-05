package com.example.SecurityModel.domain.repository;

import com.example.SecurityModel.domain.entity.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleUserRepository extends JpaRepository<RoleUser, Long> {
}
