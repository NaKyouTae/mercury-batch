package com.competition;

import org.quartz.SchedulerException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.competition.quartz.schedule.QuartzScheduler;

@EnableBatchProcessing
@SpringBootApplication
public class CompetitionBatchApplication {
	
	private static final QuartzScheduler qs = new QuartzScheduler();
	
	public static void main(String[] args) throws SchedulerException {
		SpringApplication.run(CompetitionBatchApplication.class, args);
	}
	@Bean
	public CommandLineRunner runner() {
		return (arg) -> {			
			qs.start();
		};
	}
}
