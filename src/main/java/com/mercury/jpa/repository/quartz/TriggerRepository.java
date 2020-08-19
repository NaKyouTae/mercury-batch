package com.mercury.jpa.repository.quartz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercury.jpa.model.quartz.CustomTrigger;

@Repository
public interface TriggerRepository extends JpaRepository<CustomTrigger, Long> {
	CustomTrigger findByJobIdx(String jobkey);
	CustomTrigger findByTitle(String title);
	CustomTrigger findByName(String name);
	CustomTrigger findByIdx(String idx);
}
