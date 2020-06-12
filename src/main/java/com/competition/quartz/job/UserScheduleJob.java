package com.competition.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.competition.quartz.service.user.UserQuartzService;

public class UserScheduleJob implements Job{
	
	@Autowired
	@Qualifier("userQuartzService")
	private UserQuartzService userQuartzService;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		userQuartzService.seUsers();
	}
}