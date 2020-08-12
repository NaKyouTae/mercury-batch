package com.mercury.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.model.quartz.CustomJob;
import com.mercury.jpa.repository.quartz.JobRepository;
import com.mercury.service.mail.MailService;
import com.mercury.util.JpaUtil;

public class NewsLetterJob implements Job{
	
	private JobRepository jobRepository;
	
	public NewsLetterJob() {
		try {
			this.jobRepository = ApplicationContextProvider.getBean("jobRepository");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		 try {
			MailService service = ApplicationContextProvider.getBean("mailService");
			JobDataMap data = context.getMergedJobDataMap();
			
			CustomJob job = jobRepository.findByName(data.getString("jobname"));
			
			if(job.getExecute()) {
				JpaUtil.save(data);
				service.sendNewsLetter();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
