package com.competition.quartz.util;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

public interface CommonTrigger {
	
	public static Trigger trigger(String key, String des, String cronEx, JobDetail job) {
		return TriggerBuilder.newTrigger()
				.forJob(job)
				.withIdentity(key)
				.withDescription(des)
				.withSchedule(CronScheduleBuilder.cronSchedule(cronEx))
				.build();
	}
}
