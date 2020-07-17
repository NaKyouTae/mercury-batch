package com.mercury.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.jpa.model.BatchJobExecution;

public interface BatchJobExecutionRepository extends JpaRepository<BatchJobExecution, Long> {
}
