package com.mercury.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.model.quartz.CustomJob;
import com.mercury.jpa.repository.quartz.JobRepository;
import com.mercury.service.token.TokenRefreshService;
import com.mercury.util.JpaUtil;

public class TokenRefreshJob implements Job{
	
	private JobRepository jobRepository;
	
	public TokenRefreshJob() {
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
			TokenRefreshService service = ApplicationContextProvider.getBean("tokenRefreshService");
			JobDataMap data = context.getMergedJobDataMap();
			
			CustomJob job = jobRepository.findByName(data.getString("jobname"));

			if(job.getExecute()) {
				JpaUtil.save(data);
				service.deRefresh();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
