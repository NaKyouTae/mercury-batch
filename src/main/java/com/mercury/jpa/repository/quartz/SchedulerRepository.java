package com.mercury.jpa.repository.quartz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercury.jpa.model.quartz.CustomScheduler;

@Repository
public interface SchedulerRepository extends JpaRepository<CustomScheduler, Long> {
	CustomScheduler findByIdx(String idx);
	CustomScheduler findByName(String name);
	CustomScheduler findByJobIdx(String job);
	CustomScheduler findByTriggerIdx(String trigger);
}
