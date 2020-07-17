package com.mercury.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.jpa.model.BatchJobExecutionParams;

public interface BatchJobExecutionParamsRepository extends JpaRepository<BatchJobExecutionParams, Long> {
}
