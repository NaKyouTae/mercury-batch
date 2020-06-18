package com.competition.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.competition.ApplicationContextProvider;
import com.competition.service.user.UserService;


@Component
public class UserScheduleJob implements Job{
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			ApplicationContext app = ApplicationContextProvider.getApplicationContext();
			
			UserService service = app.getBean(UserService.class);
			
			service.seUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}