package com.mercury.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.service.token.TokenBlockService;
import com.mercury.util.JpaUtil;

public class TokenBlockJob implements Job{

	@Override
	public void execute(JobExecutionContext context) {
		try {
			TokenBlockService service = ApplicationContextProvider.getBean("tokenBlockService");
			JobDataMap data = context.getMergedJobDataMap();
			JpaUtil.save(data);

			service.deTokenBlock();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
