package com.mercury.util.quartz;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;

public interface CommonJobDetail {
	
	public static JobDetail jobDetail(String key, String des, Class<? extends Job> clasz, JobDataMap data) {
		return JobBuilder.newJob().ofType(clasz)
				.storeDurably()
				.setJobData(data)
				.withIdentity(key)
				.withDescription(des)
				.build();
	}
}
