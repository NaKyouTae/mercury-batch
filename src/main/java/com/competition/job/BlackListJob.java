package com.competition.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.competition.ApplicationContextProvider;
import com.competition.service.token.BlackListService;

@Component
public class BlackListJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		 try {
			 ApplicationContext app = ApplicationContextProvider.getApplicationContext();
				
			 BlackListService service = app.getBean(BlackListService.class);
			 
			 service.deBlackList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
