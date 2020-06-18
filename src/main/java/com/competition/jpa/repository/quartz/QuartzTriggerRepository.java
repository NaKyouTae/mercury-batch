package com.competition.jpa.repository.quartz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.competition.jpa.model.quartz.QuartTrigger;

@Repository
public interface QuartzTriggerRepository extends JpaRepository<QuartTrigger, Long> {
	QuartTrigger findByJobKey(String jobkey);
	QuartTrigger findByKey(String key);
	QuartTrigger findByIdx(String idx);
}
