package com.example.security.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security.domain.entity.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
}
