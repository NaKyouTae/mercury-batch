package com.mercury;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mercury.jpa.model.quartz.CustomJob;
import com.mercury.jpa.model.quartz.CustomScheduler;
import com.mercury.jpa.model.quartz.CustomTrigger;
import com.mercury.jpa.repository.quartz.JobRepository;
import com.mercury.jpa.repository.quartz.SchedulerRepository;
import com.mercury.jpa.repository.quartz.TriggerRepository;
import com.mercury.util.DateUtil;
import com.mercury.util.UUIDUtil;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class MercuryBatchApplication implements WebMvcConfigurer {
	
	public static void main(String[] args) {
		SpringApplication.run(MercuryBatchApplication.class, args);
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://localhost:4300", "http://127.0.0.1:4300")
				.allowedMethods("GET", "POST", "PUT", "DELETE").exposedHeaders("AWT", "RWT", "UWT")
				.allowCredentials(true).maxAge(3600);
	}
	
	@Bean
	public CommandLineRunner runner(SchedulerRepository schedule, JobRepository job, TriggerRepository trigger) {
		return (arg) -> {
			{
				String week_j_idx = UUIDUtil.randomString();
				String news_j_idx = UUIDUtil.randomString();
				String black_j_idx = UUIDUtil.randomString();
				String refresh_j_idx = UUIDUtil.randomString();
				
				if(job.findAll().size() == 0) {
					job.saveAll(Arrays.asList(
						// New Week JOB
						CustomJob.builder().idx(week_j_idx).name("NewWeek").title("NewWeek Job").insertDate(DateUtil.now()).description("New Week Update User Mailege Job").clasz("UserJob").build(),
						// NewsLetter Mail JOB
						CustomJob.builder().idx(news_j_idx).name("NewsLetter").title("NewsLetter Job").insertDate(DateUtil.now()).description("for Send NewsLetter Job").clasz("NewsLetterJob").build(),
						// Black List Token Delete JOB
						CustomJob.builder().idx(black_j_idx).name("TokenBlack").title("Black Token Job").insertDate(DateUtil.now()).description("Delete Black Token Job").clasz("TokenBlackJob").build(),
						// Refresh Token Delete JOB
						CustomJob.builder().idx(refresh_j_idx).name("TokenRefresh").title("Refresh Token Job").insertDate(DateUtil.now()).description("Delete Refresh garbage Token Job").clasz("TokenRefreshJob").build()
					));
				}
				

				String week_t_idx = UUIDUtil.randomString();
				String news_t_idx = UUIDUtil.randomString();
				String black_t_idx = UUIDUtil.randomString();
				String refresh_t_idx = UUIDUtil.randomString();

				if(trigger.findAll().size() == 0) {
					trigger.saveAll(Arrays.asList(
						// New Week Trigger
						CustomTrigger.builder().idx(week_t_idx).name("NewWeek").insertDate(DateUtil.now()).title("NewWeek Trigger").description("New Week Update User Mailege").cron("0 5 0 ? * MON").jobTitle(week_t_idx).build(),
						// NewsLetter Mail Trigger
						CustomTrigger.builder().idx(news_t_idx).name("NewsLetter").insertDate(DateUtil.now()).title("NewsLetter Trigger").description("for Send NewsLetter Trigger").cron("0 5 0 ? * MON").jobTitle(news_t_idx).build(),
						// Black List Token Delete Trigger
						CustomTrigger.builder().idx(black_t_idx).name("TokenBlack").insertDate(DateUtil.now()).title("Black Token Trigger").description("Delete Black List Token Trigger").cron("0 0 0 * * ?").jobTitle(black_t_idx).build(),
						// Refresh Token Delete Trigger
						CustomTrigger.builder().idx(refresh_t_idx).name("TokenRefresh").insertDate(DateUtil.now()).title("Refresh Token Trigger").description("Delete Garbage Refresh Token Trigger").cron("0 0 0 * * ?").jobTitle(refresh_t_idx).build()
					));	
				}
				
				if(schedule.findAll().size() == 0) {
					schedule.saveAll(Arrays.asList(
						// New Week Schedule
						CustomScheduler.builder().idx(UUIDUtil.randomString()).name("NewWeek").insertDate(DateUtil.now()).jobIdx(week_j_idx).triggerIdx(week_t_idx).build(),
						// NewsLetter Mail Schedule
						CustomScheduler.builder().idx(UUIDUtil.randomString()).name("NewsLetter").insertDate(DateUtil.now()).jobIdx(news_j_idx).triggerIdx(news_t_idx).build(),
						// Black List Token Delete Schedule
						CustomScheduler.builder().idx(UUIDUtil.randomString()).name("TokenBlack").insertDate(DateUtil.now()).jobIdx(black_j_idx).triggerIdx(black_t_idx).build(),
						// Refresh Token Delete Schedule
						CustomScheduler.builder().idx(UUIDUtil.randomString()).name("TokenRefresh").insertDate(DateUtil.now()).jobIdx(refresh_j_idx).triggerIdx(refresh_t_idx).build()
						
					));
				}
				
			}
		};
	}
}
