package com.competition.util.quartz;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;

public interface CommonJobDetail {
	
	public static JobDetail jobDetail(String key, String des, Class<? extends Job> clasz) {
		return JobBuilder.newJob().ofType(clasz)
				.storeDurably()
				.withIdentity(key)
				.withDescription(des)
				.build();
	}
}
