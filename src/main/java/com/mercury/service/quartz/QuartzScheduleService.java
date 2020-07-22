package com.mercury.service.quartz;

import java.util.List;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class QuartzScheduleService {
	
	
	public <T extends Object> T stopSchedule(String triggerName) throws Exception{
		try {
			SchedulerFactory sf = new StdSchedulerFactory();
			
			Scheduler s = sf.getScheduler();
			
			for(JobKey key : s.getJobKeys(GroupMatcher.jobGroupEquals(triggerName))) {
				
				JobDetail jobDetail = s.getJobDetail(key);
				
				List<CronTrigger> triggers = (List<CronTrigger>) s.getTriggersOfJob(key);
				TriggerKey tKey = triggers.get(0).getKey();
				Trigger trigger = s.getTrigger(tKey);
				s.scheduleJob(jobDetail, trigger);
				s.shutdown();
			}
			
			return (T) Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
}
