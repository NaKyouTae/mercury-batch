package com.mercury.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.mercury.service.mail.MailService;
import com.mercury.util.BeanUtil;
import com.mercury.util.JpaUtil;

public class NewsLetterJob implements Job{
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		 try {
			MailService service = BeanUtil.getBean("mailService");
			JobDataMap data = context.getMergedJobDataMap();
			JpaUtil.save(data);

			service.sendNewsLetter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
