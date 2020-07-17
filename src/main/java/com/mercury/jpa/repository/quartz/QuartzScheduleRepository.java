package com.mercury.jpa.repository.quartz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercury.jpa.model.quartz.CustomSchedule;
import com.mercury.jpa.model.quartz.CustomTrigger;

@Repository
public interface QuartzScheduleRepository extends JpaRepository<CustomSchedule, Long> {
	CustomTrigger findByIdx(String idx);
	CustomTrigger findByJobIdx(String job);
	CustomTrigger findByTriggerIdx(String trigger);
}
