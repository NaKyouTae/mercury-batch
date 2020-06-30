package com.competition.schedule;

import java.util.List;

import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.ApplicationContext;

import com.competition.ApplicationContextProvider;
import com.competition.jpa.model.quartz.CustomJob;
import com.competition.jpa.model.quartz.CustomSchedule;
import com.competition.jpa.model.quartz.CustomTrigger;
import com.competition.jpa.repository.quartz.QuartzJobRepository;
import com.competition.jpa.repository.quartz.QuartzScheduleRepository;
import com.competition.jpa.repository.quartz.QuartzTriggerRepository;
import com.competition.util.loader.ClassLoaderUtil;
import com.competition.util.quartz.CommonJobDetail;
import com.competition.util.quartz.CommonScheduler;
import com.competition.util.quartz.CommonTrigger;

public class QuartzScheduler {
	
	
	// 해당 클래스가 인스턴스화 되자마자 자동으로 동작 하기 위함
	public void start() throws SchedulerException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		ApplicationContext app = ApplicationContextProvider.getApplicationContext();
		
		QuartzJobRepository jobRepo = app.getBean(QuartzJobRepository.class);
		QuartzTriggerRepository triggerRepo = app.getBean(QuartzTriggerRepository.class);
		QuartzScheduleRepository scheduleRepo = app.getBean(QuartzScheduleRepository.class);
		
		
		List<CustomSchedule> scheduls = scheduleRepo.findAll();
		
		SchedulerFactory sf = new StdSchedulerFactory();
		
		for(CustomSchedule s : scheduls){
			CustomJob jobInfo = jobRepo.findByIdx(s.getJobIdx());
			CustomTrigger triggerInfo = triggerRepo.findByIdx(s.getTriggerIdx());
			
			JobDetail job = CommonJobDetail.jobDetail(jobInfo.getTitle(), jobInfo.getDescription(), ClassLoaderUtil.getClass("com.competition.job." + jobInfo.getClasz()));
			
			Trigger t = CommonTrigger.trigger(triggerInfo.getTitle(), triggerInfo.getDescription(), triggerInfo.getCron(), job);
			
			CommonScheduler.scheduler(t, job, sf);
		}
	}
}
