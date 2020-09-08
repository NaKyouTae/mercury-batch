package com.mercury.process.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.model.quartz.CustomScheduler;
import com.mercury.jpa.repository.quartz.SchedulerRepository;
import com.mercury.util.DateUtil;
import com.mercury.util.UUIDUtil;

@Component
@Transactional
@SuppressWarnings("unchecked")
public class SchedulerProcess {

	@Autowired
	private SchedulerRepository schedulerRepository;

	public SchedulerProcess() throws Exception {
		this.schedulerRepository = ApplicationContextProvider
				.getBean("schedulerRepository");
	}

	public <T extends Object> T seSchedulers() throws Exception {
		return (T) schedulerRepository.findAll();
	}

	public <T extends Object> T seSchedulerByIdx(String idx) throws Exception {
		return (T) schedulerRepository.findByIdx(idx);
	}

	public <T extends Object> T seSchedulerByJob(String job) throws Exception {
		return (T) schedulerRepository.findByJobIdx(job);
	}

	public <T extends Object> T seSchedulerByName(String name)
			throws Exception {
		return (T) schedulerRepository.findByName(name);
	}

	public <T extends Object> T seSchedulerByTrigger(String trigger)
			throws Exception {
		return (T) schedulerRepository.findByTriggerIdx(trigger);
	}

	public <T extends Object> T inScheduler(CustomScheduler scheduler)
			throws Exception {
		scheduler.setIdx(UUIDUtil.randomString());
		scheduler.setInsertDate(DateUtil.now());
		return (T) schedulerRepository.save(scheduler);
	}

	public <T extends Object> T upScheduler(CustomScheduler scheduler)
			throws Exception {
		return (T) schedulerRepository.save(scheduler);
	}

	public <T extends Object> T deScheduler(CustomScheduler scheduler)
			throws Exception {
		schedulerRepository.delete(scheduler);
		return (T) Boolean.TRUE;
	}
}
