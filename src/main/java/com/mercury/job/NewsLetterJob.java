package com.mercury.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.mercury.ApplicationContextProvider;
import com.mercury.service.mail.MailService;

@Component
public class NewsLetterJob implements Job{
	private static final Logger LOGGER = LogManager.getLogger(NewsLetterJob.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		 try {
			 ApplicationContext app = ApplicationContextProvider.getApplicationContext();
				
			 MailService service = app.getBean(MailService.class);
			 LOGGER.info("NewsLetter Job Start");
			 service.sendNewsLetter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
