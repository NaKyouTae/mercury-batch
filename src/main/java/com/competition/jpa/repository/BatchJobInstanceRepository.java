package com.competition.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.competition.jpa.model.BatchJobInstance;

@Repository
public interface BatchJobInstanceRepository extends JpaRepository<BatchJobInstance, Long> {
}
