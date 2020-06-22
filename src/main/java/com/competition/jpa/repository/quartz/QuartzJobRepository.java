package com.competition.jpa.repository.quartz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.competition.jpa.model.quartz.CustomJob;

@Repository
public interface QuartzJobRepository extends JpaRepository<CustomJob, Long> {
	CustomJob findByTitle(String key);
	CustomJob findByIdx(String idx);
	CustomJob findByClasz(String clasz);
}
