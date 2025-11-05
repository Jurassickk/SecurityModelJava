package com.example.SecurityModel.application.service;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;

public abstract class GenericCrudServiceImpl <Entity, DTO, ID> implements GenericCrudService<DTO, ID> {

    protected final JpaRepository<Entity, ID> repository;
    protected final Function<Entity, DTO> toDto;
    protected final Function<DTO, Entity> toEntity;
    protected final BiConsumer<Entity, DTO> merge;

    protected GenericCrudServiceImpl(JpaRepository<Entity, ID> repository,
                                     Function<Entity, DTO> toDto,
                                     Function<DTO, Entity> toEntity,
                                     BiConsumer<Entity, DTO> merge) {
        this.repository = repository;
        this.toDto = toDto;
        this.toEntity = toEntity;
        this.merge = merge;
    }

    @Override
    @Transactional
    public DTO create(DTO dto) {
        Entity entity = toEntity.apply(dto);
        Entity saved = repository.save(entity);
        return toDto.apply(saved);
    }

    @Override
    public Optional<DTO> findById(ID id) {
        return repository.findById(id).map(toDto);
    }

    @Override
    public List<DTO> findAll() {
        return repository.findAll().stream().map(toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public DTO update(ID id, DTO dto) {
        Entity entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Entity not found: " + id));
        merge.accept(entity, dto);
        Entity updated = repository.save(entity);
        return toDto.apply(updated);
    }

    @Override
    @Transactional
    public void delete(ID id) {
        repository.deleteById(id);
    }
}
