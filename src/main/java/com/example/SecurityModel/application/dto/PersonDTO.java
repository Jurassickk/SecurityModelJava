package com.example.SecurityModel.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String documentType;
    private String documentNumber;
    private String phoneNumber;
    private String gender;
    private Boolean active;
    private String cityId;
    private Long userId;
}