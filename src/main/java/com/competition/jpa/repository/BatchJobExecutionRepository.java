package com.competition.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.competition.jpa.model.BatchJobExecution;

public interface BatchJobExecutionRepository extends JpaRepository<BatchJobExecution, Long> {
}
