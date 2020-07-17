package com.mercury.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.jpa.model.BatchJobExecutionContext;

public interface BatchJobExecutionContextRepository extends JpaRepository<BatchJobExecutionContext, Long>{
}
