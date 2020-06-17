package com.competition.quartz.schedule;

import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.competition.quartz.job.UserScheduleJob;
import com.competition.quartz.util.CommonJobDetail;
import com.competition.quartz.util.CommonScheduler;
import com.competition.quartz.util.CommonTrigger;

public class QuartzScheduler {
	private SchedulerFactory sf = new StdSchedulerFactory();
	
	// 해당 클래스가 인스턴스화 되자마자 자동으로 동작 하기 위함
//	@PostConstruct
	public void start() throws SchedulerException {
		JobDetail job = CommonJobDetail.jobDetail("Test Job", "Is Test Job", UserScheduleJob.class);
		
		Trigger t = CommonTrigger.trigger("Test Trigger", "Is Test Trigger", "*/15 * * * * ?", job);

		CommonScheduler.scheduler(t, job, sf);
	}
}
