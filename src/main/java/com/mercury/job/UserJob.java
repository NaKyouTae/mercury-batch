package com.mercury.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.mercury.ApplicationContextProvider;
import com.mercury.service.user.UserService;
import com.mercury.util.DateUtil;


@Component
public class UserJob implements Job{
	private static final Logger LOGGER = LogManager.getLogger(UserJob.class);
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			ApplicationContext app = ApplicationContextProvider.getApplicationContext();
			
			UserService service = app.getBean(UserService.class);
			LOGGER.info("NewsLetter Job Start");
			// 삼행시 1~3등 포인트 지급
			service.upUserThreePoint();
			// 이행시 1~3등 포인트 지급
			service.upUserTwoPoint();
			
			System.out.println("UserJob Start : " + DateUtil.now());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}