package com.mercury.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.model.quartz.CustomJob;
import com.mercury.jpa.repository.quartz.JobRepository;
import com.mercury.service.token.TokenBlockService;
import com.mercury.util.JpaUtil;

public class TokenBlockJob implements Job{
	
	private JobRepository jobRepository;
	
	public TokenBlockJob() {
		try {
			this.jobRepository = ApplicationContextProvider.getBean("jobRepository");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void execute(JobExecutionContext context) {
		try {
			TokenBlockService service = ApplicationContextProvider.getBean("tokenBlockService");
			JobDataMap data = context.getMergedJobDataMap();
			
			CustomJob job = jobRepository.findByName(data.getString("jobname"));
			
			if(job.getExecute()) {
				JpaUtil.save(data);
				service.deTokenBlock();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
