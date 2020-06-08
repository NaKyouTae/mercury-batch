package com.competition.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.competition.jpa.model.BatchJobExecutionParams;

public interface BatchJobExecutionParamsRepository extends JpaRepository<BatchJobExecutionParams, Long> {
}
