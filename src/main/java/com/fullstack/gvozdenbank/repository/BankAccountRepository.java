package com.fullstack.gvozdenbank.repository;

import com.fullstack.gvozdenbank.entities.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccountEntity, Long> {}
