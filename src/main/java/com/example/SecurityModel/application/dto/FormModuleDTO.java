package com.example.SecurityModel.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormModuleDTO {

    private Long id;
    private Long formId;
    private Long moduleId;
}