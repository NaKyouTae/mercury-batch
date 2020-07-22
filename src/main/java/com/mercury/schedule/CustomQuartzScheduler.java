package com.mercury.schedule;

import java.util.List;

import javax.annotation.PostConstruct;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercury.jpa.model.quartz.CustomJob;
import com.mercury.jpa.model.quartz.CustomSchedule;
import com.mercury.jpa.model.quartz.CustomTrigger;
import com.mercury.jpa.repository.quartz.QuartzJobRepository;
import com.mercury.jpa.repository.quartz.QuartzScheduleRepository;
import com.mercury.jpa.repository.quartz.QuartzTriggerRepository;
import com.mercury.util.loader.ClassLoaderUtil;
import com.mercury.util.quartz.CommonJobDetail;
import com.mercury.util.quartz.CommonScheduler;
import com.mercury.util.quartz.CommonTrigger;

@Component
public class CustomQuartzScheduler {
	@Autowired
	private QuartzJobRepository jobRepo;
	
	@Autowired
	private QuartzTriggerRepository triggerRepo;
	
	@Autowired
	private QuartzScheduleRepository scheduleRepo;
	
	// 해당 클래스가 인스턴스화 되자마자 자동으로 동작 하기 위함
	@PostConstruct
	public void start() throws SchedulerException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		List<CustomSchedule> scheduls = scheduleRepo.findAll();
		
		SchedulerFactory sf = new StdSchedulerFactory();
		
		for(CustomSchedule s : scheduls){
			CustomJob jobInfo = jobRepo.findByIdx(s.getJobIdx());
			CustomTrigger triggerInfo = triggerRepo.findByIdx(s.getTriggerIdx());
			
			JobDataMap jdata = new JobDataMap();
			jdata.put("cron", triggerInfo.getCron());
			jdata.put("triggername", triggerInfo.getName());
			jdata.put("jobname", jobInfo.getName());
			jdata.put("schedulename", s.getName());
			jdata.put("message", jobInfo.getName() + " Start");
			
			JobDetail job = CommonJobDetail.jobDetail(jobInfo.getTitle(), jobInfo.getDescription(), ClassLoaderUtil.getClass("com.mercury.job." + jobInfo.getClasz()), jdata);
			
			Trigger t = CommonTrigger.trigger(triggerInfo.getTitle(), triggerInfo.getDescription(), triggerInfo.getCron(), job);
			
			CommonScheduler.scheduler(t, job, sf);
		}
	}
}
