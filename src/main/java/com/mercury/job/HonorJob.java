package com.mercury.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.model.quartz.CustomJob;
import com.mercury.jpa.repository.quartz.JobRepository;
import com.mercury.service.honor.HonorService;
import com.mercury.util.JpaUtil;


public class HonorJob implements Job{
	
	private JobRepository jobRepository;
	
	public HonorJob() {
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
			HonorService service = ApplicationContextProvider.getBean("honorService");

			JobDataMap data = context.getMergedJobDataMap();

			CustomJob job = jobRepository.findByName(data.getString("jobname"));
			
			if(job.getExecute()) {
				JpaUtil.save(data);
				// 3행시 2행시 명예의 전당 데이터 생성
				service.inHonors();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}