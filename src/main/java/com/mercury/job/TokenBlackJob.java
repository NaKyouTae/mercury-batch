package com.mercury.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercury.jpa.model.history.HistorySchedule;
import com.mercury.jpa.repository.history.HistoryScheduleRepository;
import com.mercury.service.token.TokenBlackService;
import com.mercury.util.DateUtil;

@Component
public class TokenBlackJob implements Job{
	private static final Logger LOGGER = LogManager.getLogger(TokenBlackJob.class);
	
	private static final TokenBlackService tokenBlackService = new TokenBlackService();
	
	@Autowired
	private HistoryScheduleRepository historyScheduleRepository;
	
	@Override
	public void execute(JobExecutionContext context) {
		try {
			tokenBlackService.deTokenBlack();
			JobDataMap data = context.getMergedJobDataMap();

			
			HistorySchedule hs = new HistorySchedule();
			 
			hs.setCron(data.getString("cron"));
			hs.setTriggerName(data.getString("triggername"));
			hs.setJobName(data.getString("jobname"));
			hs.setScheduleName(data.getString("schedulename"));
			hs.setMessage("TokenBlack Job Start");
			hs.setStartDate(DateUtil.now());
			
			historyScheduleRepository.save(hs);
			
			System.out.println("Block List Test");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
