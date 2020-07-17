package com.mercury.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.jpa.model.BatchStepExecution;

public interface BatchStepExecutionRepository extends JpaRepository<BatchStepExecution, Long> {
}
