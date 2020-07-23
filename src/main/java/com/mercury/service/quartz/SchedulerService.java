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

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.model.quartz.CustomScheduler;
import com.mercury.process.quartz.SchedulerProcess;

@Service
@SuppressWarnings("unchecked")
public class SchedulerService {
	
	private SchedulerProcess schedulerProcess;
	
	public SchedulerService() {
		this.schedulerProcess = ApplicationContextProvider.getBean("schedulerProcess");
	}
	
	public <T extends Object> T stopSchedule(String idx) throws Exception{
		try {
			SchedulerFactory sf = new StdSchedulerFactory();
			
			Scheduler s = sf.getScheduler();
			
			for(JobKey key : s.getJobKeys(GroupMatcher.jobGroupEquals(idx))) {
				
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
	
	public <T extends Object> T seSchedulers() throws Exception {
		try {
			return (T) schedulerProcess.seSchedulers();
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seSchedulerByIdx(String idx) throws Exception {
		try {
			return (T) schedulerProcess.seSchedulerByIdx(idx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seSchedulerByName(String name) throws Exception {
		try {
			return (T) schedulerProcess.seSchedulerByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seSchedulerByJob(String job) throws Exception {
		try {
			return (T) schedulerProcess.seSchedulerByJob(job);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seSchedulerByTrigger(String trigger) throws Exception {
		try {
			return (T) schedulerProcess.seSchedulerByTrigger(trigger);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T inScheduler(CustomScheduler scheduler) throws Exception {
		try {
			return (T) schedulerProcess.inScheduler(scheduler);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T upScheduler(CustomScheduler scheduler) throws Exception {
		try {
			return (T) schedulerProcess.upScheduler(scheduler);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T deScheduler(CustomScheduler scheduler) throws Exception {
		try {
			return (T) schedulerProcess.deScheduler(scheduler);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
}
