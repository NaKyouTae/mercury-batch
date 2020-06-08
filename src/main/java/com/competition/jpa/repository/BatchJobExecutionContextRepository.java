package com.competition.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.competition.jpa.model.BatchJobExecutionContext;

public interface BatchJobExecutionContextRepository extends JpaRepository<BatchJobExecutionContext, Long>{
}
