package com.competition.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.competition.ApplicationContextProvider;
import com.competition.service.user.UserService;
import com.competition.util.DateUtil;


@Component
public class UserJob implements Job{
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			ApplicationContext app = ApplicationContextProvider.getApplicationContext();
			
			UserService service = app.getBean(UserService.class);
			
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