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
import org.springframework.transaction.annotation.Transactional;

import com.mercury.jpa.model.quartz.CustomTrigger;
import com.mercury.process.quartz.TriggerProcess;
import com.mercury.util.quartz.CommonTrigger;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class TriggerService {

	@Autowired
	private TriggerProcess quartzTriggerProcess = new TriggerProcess();

	public <T extends Object> T seTriggers() throws Exception {
		return (T) quartzTriggerProcess.seTriggers();
	}

	public <T extends Object> T seNowTriggers() throws Exception {
		Scheduler s = new StdSchedulerFactory().getScheduler();
		return (T) s.getTriggerGroupNames();
	}

	public <T extends Object> T seTriggerByIdx(String idx) throws Exception {
		return (T) quartzTriggerProcess.seTriggerByIdx(idx);
	}

	public <T extends Object> T seTriggerByTitle(String title)
			throws Exception {
		return (T) quartzTriggerProcess.seTriggerByTitle(title);
	}

	public <T extends Object> T seTriggerByName(String name) throws Exception {
		return (T) quartzTriggerProcess.seTriggerByName(name);
	}

	public <T extends Object> T seTriggerByJobIdx(String jobTitle)
			throws Exception {
		return (T) quartzTriggerProcess.seTriggerByJobIdx(jobTitle);
	}

	public <T extends Object> T upTrigger(CustomTrigger trigger)
			throws Exception {
		CustomTrigger dbTrigger = seTriggerByIdx(trigger.getIdx());
		if (!trigger.getClass().equals(dbTrigger.getCron())) {
			Scheduler s = new StdSchedulerFactory().getScheduler();

			for (JobKey key : s.getJobKeys(
					GroupMatcher.jobGroupEquals(trigger.getJobIdx()))) {
				List<CronTrigger> triggers = (List<CronTrigger>) s
						.getTriggersOfJob(key);

				Trigger nt = triggers.get(0);
				nt = CommonTrigger.trigger(trigger.getTitle(),
						trigger.getDescription(), trigger.getCron(),
						s.getJobDetail(key));
				s.rescheduleJob(nt.getKey(), nt);
			}
		}

		return (T) quartzTriggerProcess.upTrigger(trigger);
	}

	public <T extends Object> T inTrigger(CustomTrigger trigger)
			throws Exception {
		return (T) quartzTriggerProcess.inTrigger(trigger);
	}

	public <T extends Object> T deTrigger(CustomTrigger trigger)
			throws Exception {
		return (T) quartzTriggerProcess.deTrigger(trigger);
	}
}
