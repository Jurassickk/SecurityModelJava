package com.example.SecurityModel.domain.repository;

import com.example.SecurityModel.domain.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Long> {
}
