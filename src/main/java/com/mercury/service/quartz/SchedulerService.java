package com.mercury.service.quartz;

import java.util.List;

import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.model.quartz.CustomJob;
import com.mercury.jpa.model.quartz.CustomScheduler;
import com.mercury.jpa.model.quartz.CustomTrigger;
import com.mercury.jpa.repository.quartz.JobRepository;
import com.mercury.jpa.repository.quartz.SchedulerRepository;
import com.mercury.jpa.repository.quartz.TriggerRepository;
import com.mercury.process.quartz.SchedulerProcess;
import com.mercury.util.loader.ClassLoaderUtil;
import com.mercury.util.quartz.CommonJobDetail;
import com.mercury.util.quartz.CommonScheduler;
import com.mercury.util.quartz.CommonTrigger;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class SchedulerService {

	private SchedulerProcess schedulerProcess;

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private TriggerRepository triggerRepository;

	@Autowired
	private SchedulerRepository schedulerRepository;

	public SchedulerService() {
		this.schedulerProcess = ApplicationContextProvider
				.getBean("schedulerProcess");
	}

	public <T extends Object> T startScheduler(String idx) throws Exception {
		CustomScheduler scheduler = schedulerRepository.findByIdx(idx);

		SchedulerFactory sf = new StdSchedulerFactory();

		CustomJob jobInfo = jobRepository.findByIdx(scheduler.getJobIdx());
		CustomTrigger triggerInfo = triggerRepository
				.findByIdx(scheduler.getTriggerIdx());

		JobDataMap jdata = new JobDataMap();
		jdata.put("cron", triggerInfo.getCron());
		jdata.put("triggername", triggerInfo.getName());
		jdata.put("jobname", jobInfo.getName());
		jdata.put("schedulename", scheduler.getName());
		jdata.put("message", jobInfo.getName() + " Start");

		JobDetail job = CommonJobDetail.jobDetail(
				jobInfo.getTitle(), jobInfo.getDescription(), ClassLoaderUtil
						.getClass("com.mercury.job." + jobInfo.getClasz()),
				jdata);

		Trigger t = CommonTrigger.trigger(triggerInfo.getTitle(),
				triggerInfo.getDescription(), triggerInfo.getCron(), job);

		CommonScheduler.scheduler(t, job, sf);

		return (T) Boolean.TRUE;
	}

	public <T extends Object> T stopSchedule(String jobIdx) throws Exception {
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler s = sf.getScheduler();

		for (JobKey key : s.getJobKeys(GroupMatcher.jobGroupEquals(jobIdx))) {

			JobDetail jobDetail = s.getJobDetail(key);

			List<CronTrigger> triggers = (List<CronTrigger>) s
					.getTriggersOfJob(key);
			TriggerKey tKey = triggers.get(0).getKey();
			Trigger trigger = s.getTrigger(tKey);
			s.unscheduleJob(tKey);
			s.scheduleJob(jobDetail, trigger);
			s.shutdown();
		}

		return (T) Boolean.TRUE;
	}

	public <T extends Object> T seSchedulers() throws Exception {
		return (T) schedulerProcess.seSchedulers();
	}

	public <T extends Object> T seSchedulerByIdx(String idx) throws Exception {
		return (T) schedulerProcess.seSchedulerByIdx(idx);
	}

	public <T extends Object> T seSchedulerByName(String name)
			throws Exception {
		return (T) schedulerProcess.seSchedulerByName(name);
	}

	public <T extends Object> T seSchedulerByJob(String job) throws Exception {
		return (T) schedulerProcess.seSchedulerByJob(job);
	}

	public <T extends Object> T seSchedulerByTrigger(String trigger)
			throws Exception {
		return (T) schedulerProcess.seSchedulerByTrigger(trigger);
	}

	public <T extends Object> T inScheduler(CustomScheduler scheduler)
			throws Exception {
		return (T) schedulerProcess.inScheduler(scheduler);
	}

	public <T extends Object> T upScheduler(CustomScheduler scheduler)
			throws Exception {
		return (T) schedulerProcess.upScheduler(scheduler);
	}

	public <T extends Object> T deScheduler(CustomScheduler scheduler)
			throws Exception {
		return (T) schedulerProcess.deScheduler(scheduler);
	}
}
