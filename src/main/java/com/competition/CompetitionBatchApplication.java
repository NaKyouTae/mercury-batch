package com.competition;

import org.quartz.SchedulerException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.competition.quartz.schedule.QuartzScheduler;

@EnableBatchProcessing
@SpringBootApplication
public class CompetitionBatchApplication {
	
	@Autowired
	private static QuartzScheduler qs = new QuartzScheduler();
	
	public static void main(String[] args) throws SchedulerException {
		SpringApplication.run(CompetitionBatchApplication.class, args);
		qs.start();
	}

}
