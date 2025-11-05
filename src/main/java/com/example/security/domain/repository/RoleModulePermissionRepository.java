package com.example.security.domain.repository;

import com.example.security.domain.entity.RoleModulePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleModulePermissionRepository extends JpaRepository<RoleModulePermission, Long> {
}
