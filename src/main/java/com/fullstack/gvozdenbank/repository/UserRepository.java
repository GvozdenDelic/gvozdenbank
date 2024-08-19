package com.fullstack.gvozdenbank.repository;

import com.fullstack.gvozdenbank.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {}
