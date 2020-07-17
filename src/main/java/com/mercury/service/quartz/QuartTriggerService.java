package com.mercury.service.quartz;

import java.util.List;

import org.quartz.CronTrigger;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.jpa.model.quartz.CustomTrigger;
import com.mercury.process.quartz.QuartzTriggerProcess;
import com.mercury.util.quartz.CommonTrigger;

@Service
@SuppressWarnings("unchecked")
public class QuartTriggerService {
	
	@Autowired
	private QuartzTriggerProcess quartzTriggerProcess;
	
	public <T extends Object> T seTriggers() throws Exception{
		try {
			return (T) quartzTriggerProcess.seTriggers();
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seNowTriggers() throws Exception{
		try {
			Scheduler s = new StdSchedulerFactory().getScheduler();
			return (T) s.getTriggerGroupNames(); 
		} catch (Exception e) {
			return (T) e;
		}
	}
	
	public <T extends Object> T upTriggerCron(CustomTrigger trigger) {
		try {
			Scheduler s = new StdSchedulerFactory().getScheduler();
			
			for(JobKey key : s.getJobKeys(GroupMatcher.jobGroupEquals(trigger.getJobTitle()))) {				
				List<CronTrigger> triggers = (List<CronTrigger>) s.getTriggersOfJob(key);
				
				Trigger nt = triggers.get(0);
				nt = CommonTrigger.trigger(trigger.getTitle(), trigger.getDescription(), trigger.getCron(), s.getJobDetail(key));
				s.rescheduleJob(nt.getKey(), nt);
			}
			
			quartzTriggerProcess.upTriggerCron(trigger);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (T) "";
	}
}
