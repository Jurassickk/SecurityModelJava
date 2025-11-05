package com.example.SecurityModel.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "person")
public class Person extends BaseEntity{

    private String firstName;
    private String lastName;
    private String documentType;
    private String documentNumber;
    private String phoneNumber;
    private String gender;
    private boolean active = true;
    private String cityId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
