package com.example.security.infrastructure.controller;

import com.example.security.application.service.GenericCrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

public abstract class BaseController <DTO, ID>{

    protected abstract GenericCrudService<DTO, ID> getService();

    @PostMapping
    public ResponseEntity<DTO> create(@RequestBody DTO dto) {
        DTO created = getService().create(dto);
        return ResponseEntity.created(URI.create("")).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> getById(@PathVariable ID id) {
        return getService().findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping
    public ResponseEntity<List<DTO>> getAll() {
        return ResponseEntity.ok(getService().findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTO> update(@PathVariable ID id, @RequestBody DTO dto) {
        DTO updated = getService().update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }
}
