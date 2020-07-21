package com.mercury.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercury.service.token.TokenRefreshService;

@Component
public class TokenRefreshJob implements Job{
	private static final Logger LOGGER = LogManager.getLogger(TokenRefreshJob.class);
	
	@Autowired
	private TokenRefreshService tokenRefreshService;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		 try {
			 LOGGER.info("NewsLetter Job Start");
			 tokenRefreshService.deRefresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
