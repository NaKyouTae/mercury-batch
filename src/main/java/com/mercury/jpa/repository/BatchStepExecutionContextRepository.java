package com.mercury.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.jpa.model.BatchStepExecutionContext;

public interface BatchStepExecutionContextRepository extends JpaRepository<BatchStepExecutionContext, Long> {
}
