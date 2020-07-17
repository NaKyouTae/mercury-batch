package com.mercury.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.mercury.ApplicationContextProvider;
import com.mercury.service.token.TokenRefreshService;

@Component
public class TokenRefreshJob implements Job{
	private static final Logger LOGGER = LogManager.getLogger(TokenRefreshJob.class);
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		 try {
			 ApplicationContext app = ApplicationContextProvider.getApplicationContext();
				
			 TokenRefreshService service = app.getBean(TokenRefreshService.class);
			 LOGGER.info("NewsLetter Job Start");
			 service.deRefresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
