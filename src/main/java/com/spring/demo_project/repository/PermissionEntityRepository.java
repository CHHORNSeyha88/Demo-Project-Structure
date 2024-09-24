package com.spring.demo_project.repository;

import com.spring.demo_project.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionEntityRepository extends JpaRepository<PermissionEntity, Long> {
}