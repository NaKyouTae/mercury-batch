package com.competition.jpa.repository.quartz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.competition.jpa.model.quartz.CustomTrigger;
import com.competition.jpa.model.quartz.CustomSchedule;

@Repository
public interface QuartzScheduleRepository extends JpaRepository<CustomSchedule, Long> {
	CustomTrigger findByIdx(String idx);
	CustomTrigger findByJobIdx(String job);
	CustomTrigger findByTriggerIdx(String trigger);
}
