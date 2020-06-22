package com.competition;

import java.util.UUID;

import org.quartz.SchedulerException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.competition.jpa.model.quartz.CustomJob;
import com.competition.jpa.model.quartz.CustomSchedule;
import com.competition.jpa.model.quartz.CustomTrigger;
import com.competition.jpa.repository.quartz.QuartzJobRepository;
import com.competition.jpa.repository.quartz.QuartzScheduleRepository;
import com.competition.jpa.repository.quartz.QuartzTriggerRepository;
import com.competition.schedule.QuartzScheduler;
import com.competition.util.DateUtil;

@EnableBatchProcessing
@SpringBootApplication
public class CompetitionBatchApplication {
	
	private static final QuartzScheduler qs = new QuartzScheduler();

	public static void main(String[] args) throws SchedulerException {
		SpringApplication.run(CompetitionBatchApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner(QuartzScheduleRepository schedule, QuartzJobRepository job, QuartzTriggerRepository trigger) {
		return (arg) -> {
//			{
//				// NewsLetter Mail JOB
//				QuartzJob j = new QuartzJob();
//				
//				String jobIdx = UUID.randomUUID().toString().replace("-", "");
//				
//				j.setIdx(jobIdx);
//				j.setName("NewsLetter");
//				j.setInsertDate(DateUtil.now());
//				j.setKey("NewsLetter Job");
//				j.setDescription("for Send NewsLetter Job");
//				j.setClasz("com.competition.job.NewsLetterJob");
//				
//				job.save(j);
//				
//				// NewsLetter Mail Trigger
//				QuartzTrigger t = new QuartzTrigger();
//				String TriggerIdx = UUID.randomUUID().toString().replace("-", "");
//				
//				t.setIdx(TriggerIdx);
//				t.setName("NewsLetter");
//				t.setInsertDate(DateUtil.now());
//				t.setKey("NewsLetter Trigger");
//				t.setDescription("for Send NewsLetter Trigger");
//				t.setCron("0 0 0 * * 2");
//				t.setJobKey(jobIdx);
//				
//				trigger.save(t);
//				
//				// NewsLetter Mail Schedule
//				QuartzSchedule s = new QuartzSchedule();
//				
//				s.setIdx(UUID.randomUUID().toString().replace("-", ""));
//				s.setName("NewsLetter");
//				s.setInsertDate(DateUtil.now());
//				s.setJobKIdx(jobIdx);
//				s.setTriggerIdx(TriggerIdx);
//				
//				schedule.save(s);
//			}
			
			{
				// New Week JOB
				CustomJob j = new CustomJob();
				
				String jobIdx = UUID.randomUUID().toString().replace("-", "");
				
				j.setIdx(jobIdx);
				j.setName("NewWeek");
				j.setInsertDate(DateUtil.now());
				j.setTitle("NewWeek Job");
				j.setDescription("New Week Update User Mailege");
				j.setClasz("com.competition.job.UserJob");
				
				job.save(j);
				
				// New Week Trigger
				CustomTrigger t = new CustomTrigger();
				String TriggerIdx = UUID.randomUUID().toString().replace("-", "");
				
				t.setIdx(TriggerIdx);
				t.setName("NewWeek");
				t.setInsertDate(DateUtil.now());
				t.setTitle("NewWeek Trigger");
				t.setDescription("New Week Update User Mailege");
//				t.setCron("0 0 0 * * 2");
				t.setCron("0/15 * * * * ?");
				t.setJobTitle(jobIdx);
				
				trigger.save(t);
				
				// New Week Schedule
				CustomSchedule s = new CustomSchedule();
				
				s.setIdx(UUID.randomUUID().toString().replace("-", ""));
				s.setName("NewWeek");
				s.setInsertDate(DateUtil.now());
				s.setJobIdx(jobIdx);
				s.setTriggerIdx(TriggerIdx);
				
				schedule.save(s);
			}
			
			// Scheulder Start
			qs.start();
		};
	}
}
