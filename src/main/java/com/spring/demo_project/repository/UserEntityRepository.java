package com.spring.demo_project.repository;

import com.spring.demo_project.entity.UserEntity;
import com.spring.demo_project.entity.UserEntityInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    @Query("""
select u from UserEntity u 
left join fetch u.role r 
left join fetch r.permissions p
""")
    List<UserEntity> getAll();

}