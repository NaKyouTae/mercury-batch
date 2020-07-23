package com.mercury.jpa.repository.quartz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercury.jpa.model.quartz.CustomScheduler;
import com.mercury.jpa.model.quartz.CustomTrigger;

@Repository
public interface SchedulerRepository extends JpaRepository<CustomScheduler, Long> {
	CustomTrigger findByIdx(String idx);
	CustomTrigger findByName(String name);
	CustomTrigger findByJobIdx(String job);
	CustomTrigger findByTriggerIdx(String trigger);
}
