package com.competition.jpa.repository.quartz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.competition.jpa.model.quartz.QuartzJob;

@Repository
public interface QuartzJobRepository extends JpaRepository<QuartzJob, Long> {
	QuartzJob findByKey(String key);
	QuartzJob findByIdx(String idx);
	QuartzJob findByClasz(String clasz);
}
