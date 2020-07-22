package com.mercury.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.service.user.UserService;
import com.mercury.util.JpaUtil;


public class UserJob implements Job{
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			UserService service = ApplicationContextProvider.getBean("userService");

			JobDataMap data = context.getMergedJobDataMap();
			JpaUtil.save(data);
			
			// 삼행시 1~3등 포인트 지급
			service.upUserThreePoint();
			// 이행시 1~3등 포인트 지급
			service.upUserTwoPoint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}