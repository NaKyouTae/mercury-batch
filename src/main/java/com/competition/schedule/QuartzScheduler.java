package com.competition.schedule;

import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.competition.util.loader.ClassLoaderUtil;
import com.competition.util.quartz.CommonJobDetail;
import com.competition.util.quartz.CommonScheduler;
import com.competition.util.quartz.CommonTrigger;

public class QuartzScheduler {
	
	// 해당 클래스가 인스턴스화 되자마자 자동으로 동작 하기 위함
	public void start() throws SchedulerException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		SchedulerFactory sf = new StdSchedulerFactory();

		JobDetail job = CommonJobDetail.jobDetail("Test Job", "Is Test Job", ClassLoaderUtil.getClass("com.competition.quartz.job.UserScheduleJob"));
		
		Trigger t = CommonTrigger.trigger("Test Trigger", "Is Test Trigger", "*/15 * * * * ?", job);

		CommonScheduler.scheduler(t, job, sf);
	}
}
