package com.example.SecurityModel.domain.repository;

import com.example.SecurityModel.domain.entity.RoleModulePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleModulePermissionRepository extends JpaRepository<RoleModulePermission, Long> {
}
