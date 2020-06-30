package com.competition;

import java.util.Arrays;

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
import com.competition.util.UUIDUtil;

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
			{
				String week_j_idx = UUIDUtil.randomString();
				String news_j_idx = UUIDUtil.randomString();
				String black_j_idx = UUIDUtil.randomString();
				String refresh_j_idx = UUIDUtil.randomString();
				
				job.saveAll(Arrays.asList(
					// New Week JOB
					CustomJob.builder().idx(week_j_idx).name("NewWeek").insertDate(DateUtil.now()).description("New Week Update User Mailege Job").clasz("UserJob").build(),
					// NewsLetter Mail JOB
					CustomJob.builder().idx(news_j_idx).name("NewsLetter").insertDate(DateUtil.now()).description("for Send NewsLetter Job").clasz("NewsLetterJob").build(),
					// Black List Token Delete JOB
					CustomJob.builder().idx(black_j_idx).name("Black").insertDate(DateUtil.now()).description("Delete Black Token Job").clasz("BlackListJob").build(),
					// Refresh Token Delete JOB
					CustomJob.builder().idx(refresh_j_idx).name("Refresh").insertDate(DateUtil.now()).description("Delete Refresh garbage Token Job").clasz("RefreshJob").build()
				));

				String week_t_idx = UUIDUtil.randomString();
				String news_t_idx = UUIDUtil.randomString();
				String black_t_idx = UUIDUtil.randomString();
				String refresh_t_idx = UUIDUtil.randomString();

				trigger.saveAll(Arrays.asList(
					// New Week Trigger
					CustomTrigger.builder().idx(week_t_idx).name("NewWeek").insertDate(DateUtil.now()).title("NewWeek Trigger").description("New Week Update User Mailege").cron("0 0/5 0 * * 2").jobTitle(week_t_idx).build(),
					// NewsLetter Mail Trigger
					CustomTrigger.builder().idx(news_t_idx).name("NewsLetter").insertDate(DateUtil.now()).title("NewsLetter Trigger").description("for Send NewsLetter Trigger").cron("0 0/5 0 * * 2").jobTitle(news_t_idx).build(),
					// Black List Token Delete Trigger
					CustomTrigger.builder().idx(black_t_idx).name("Black").insertDate(DateUtil.now()).title("Black Token Trigger").description("Delete Black List Token Trigger").cron("0 0 0 * * ?").jobTitle(black_t_idx).build(),
					// Refresh Token Delete Trigger
					CustomTrigger.builder().idx(refresh_t_idx).name("Refresh").insertDate(DateUtil.now()).title("Refresh Token Trigger").description("Delete Garbage Refresh Token Trigger").cron("0 0 0 * * ?").jobTitle(refresh_t_idx).build()
				));
				
				schedule.saveAll(Arrays.asList(
					// New Week Schedule
					CustomSchedule.builder().idx(UUIDUtil.randomString()).name("NewWeek").insertDate(DateUtil.now()).jobIdx(week_j_idx).triggerIdx(week_t_idx).build(),
					// NewsLetter Mail Schedule
					CustomSchedule.builder().idx(UUIDUtil.randomString()).name("NewsLetter").insertDate(DateUtil.now()).jobIdx(news_j_idx).triggerIdx(news_t_idx).build(),
					// Black List Token Delete Schedule
					CustomSchedule.builder().idx(UUIDUtil.randomString()).name("Black").insertDate(DateUtil.now()).jobIdx(black_j_idx).triggerIdx(black_t_idx).build(),
					// Refresh Token Delete Schedule
					CustomSchedule.builder().idx(UUIDUtil.randomString()).name("Refresh").insertDate(DateUtil.now()).jobIdx(refresh_j_idx).triggerIdx(refresh_t_idx).build()
					
				));
				
			}
			
			// Scheulder Start
			qs.start();
		};
	}
}
