package com.mercury.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.mercury.ApplicationContextProvider;
import com.mercury.service.token.RefreshService;

@Component
public class RefreshJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		 try {
			 ApplicationContext app = ApplicationContextProvider.getApplicationContext();
				
			 RefreshService service = app.getBean(RefreshService.class);
			 
			 service.deRefresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
