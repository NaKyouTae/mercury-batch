package com.competition.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.competition.ApplicationContextProvider;
import com.competition.service.mail.MailService;

@Component
public class NewsLetterJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		 try {
			 ApplicationContext app = ApplicationContextProvider.getApplicationContext();
				
			 MailService service = app.getBean(MailService.class);
			 
			 service.sendNewsLetter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
