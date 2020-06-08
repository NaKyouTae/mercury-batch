package com.competition.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.competition.jpa.model.BatchStepExecutionContext;

public interface BatchStepExecutionContextRepository extends JpaRepository<BatchStepExecutionContext, Long> {
}
