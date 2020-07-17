package com.mercury.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.mercury.ApplicationContextProvider;
import com.mercury.service.token.TokenBlackService;

@Component
public class TokenBlackJob implements Job{
	private static final Logger LOGGER = LogManager.getLogger(TokenBlackJob.class);
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		 try {
			 ApplicationContext app = ApplicationContextProvider.getApplicationContext();
				
			 TokenBlackService service = app.getBean(TokenBlackService.class);
			 LOGGER.info("NewsLetter Job Start");
			 service.deTokenBlack();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
