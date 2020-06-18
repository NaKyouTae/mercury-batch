package com.competition.service.quartz;

import java.util.List;

import org.quartz.CronTrigger;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.competition.jpa.model.quartz.QuartTrigger;
import com.competition.jpa.repository.quartz.QuartzTriggerRepository;
import com.competition.util.quartz.CommonTrigger;

@Service
@SuppressWarnings("unchecked")
public class QuartService {
	
	@Autowired
	private QuartzTriggerRepository quartzTriggerRepository;
	
	public <T extends Object> T seTriggers() throws Exception{
		try {
			return (T) quartzTriggerRepository.findAll();
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
	
	public <T extends Object> T upTriggerCron(QuartTrigger trigger) {
		try {
			Scheduler s = new StdSchedulerFactory().getScheduler();
			
			for(JobKey key : s.getJobKeys(GroupMatcher.jobGroupEquals(trigger.getJobKey()))) {				
				List<CronTrigger> triggers = (List<CronTrigger>) s.getTriggersOfJob(key);
				
				Trigger nt = triggers.get(0);
				nt = CommonTrigger.trigger(trigger.getKey(), trigger.getDescription(), trigger.getCron(), s.getJobDetail(key));
				s.rescheduleJob(nt.getKey(), nt);
			}
			
			quartzTriggerRepository.save(trigger);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (T) "";
	}
}
