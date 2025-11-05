package com.example.security.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleModulePermissionDTO {

    private Long id;
    private Long roleId;
    private Long permissionId;
    private Long moduleId;
}
