package com.spring.demo_project.repository;

import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    @Query("select r from RoleEntity r where r.name like :query")
   Optional<RoleEntity> findAllByQuery(String query);
}