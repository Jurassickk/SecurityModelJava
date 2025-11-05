package com.example.SecurityModel.domain.repository;

import com.example.SecurityModel.domain.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
