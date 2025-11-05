package com.example.SecurityModel.domain.repository;

import com.example.SecurityModel.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
