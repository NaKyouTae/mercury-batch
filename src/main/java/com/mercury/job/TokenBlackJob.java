package com.mercury.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;

import com.mercury.service.token.TokenBlackService;
import com.mercury.util.BeanUtil;
import com.mercury.util.JpaUtil;

public class TokenBlackJob implements Job{

	@Override
	public void execute(JobExecutionContext context) {
		try {
			TokenBlackService service = (TokenBlackService) BeanUtil.getBean("tokenBlackService");
			JobDataMap data = context.getMergedJobDataMap();
			JpaUtil.save(data);

			service.deTokenBlack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
