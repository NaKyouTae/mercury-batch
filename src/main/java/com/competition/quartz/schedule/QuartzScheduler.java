package com.competition.quartz.schedule;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import com.competition.quartz.job.UserScheduleJob;

@Component
public class QuartzScheduler {
	private SchedulerFactory sf;
	private Scheduler scheduler;
	
	// 해당 클래스가 인스턴스화 되자마자 자동으로 동작 하기 위함
	public void start() throws SchedulerException {
		sf = new StdSchedulerFactory();
		scheduler = sf.getScheduler();
		scheduler.start();
		
		JobDetail job = JobBuilder.newJob(UserScheduleJob.class).withIdentity("Test Job").build();
		
		Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("15 * * * * ?")).build();
		
		scheduler.scheduleJob(job, trigger);
	}
}
