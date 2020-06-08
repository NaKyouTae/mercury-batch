package com.competition.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.competition.jpa.model.BatchStepExecution;

public interface BatchStepExecutionRepository extends JpaRepository<BatchStepExecution, Long> {
}
