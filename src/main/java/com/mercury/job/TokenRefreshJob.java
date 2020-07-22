package com.mercury.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.service.token.TokenRefreshService;
import com.mercury.util.JpaUtil;

public class TokenRefreshJob implements Job{
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		 try {
			TokenRefreshService service = ApplicationContextProvider.getBean("tokenRefreshService");
			JobDataMap data = context.getMergedJobDataMap();
			JpaUtil.save(data);
			
			service.deRefresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
