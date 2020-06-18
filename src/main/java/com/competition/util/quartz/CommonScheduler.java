package com.competition.util.quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;

public interface CommonScheduler {

	public static Scheduler scheduler(Trigger trigger, JobDetail job, SchedulerFactory factory) throws SchedulerException{
		Scheduler scheduler = factory.getScheduler();
		scheduler.scheduleJob(job, trigger);
		scheduler.start();
		return scheduler;
	}
}
