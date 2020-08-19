package com.mercury.process.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.model.quartz.CustomScheduler;
import com.mercury.jpa.repository.quartz.SchedulerRepository;
import com.mercury.util.DateUtil;
import com.mercury.util.UUIDUtil;

@Component
@SuppressWarnings("unchecked")
public class SchedulerProcess {
	
	@Autowired
	private SchedulerRepository schedulerRepository;
	
	public SchedulerProcess() {
		try {
			this.schedulerRepository = ApplicationContextProvider.getBean("schedulerRepository");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public <T extends Object> T seSchedulers() throws Exception{
		try {
			return (T) schedulerRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seSchedulerByIdx(String idx) throws Exception{
		try {
			return (T) schedulerRepository.findByIdx(idx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seSchedulerByJob(String job) throws Exception{
		try {
			return (T) schedulerRepository.findByJobIdx(job);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seSchedulerByName(String name) throws Exception{
		try {
			return (T) schedulerRepository.findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seSchedulerByTrigger(String trigger) throws Exception{
		try {
			return (T) schedulerRepository.findByTriggerIdx(trigger);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T inScheduler(CustomScheduler scheduler) throws Exception {
		try {
			scheduler.setIdx(UUIDUtil.randomString());
			scheduler.setInsertDate(DateUtil.now());
			return (T) schedulerRepository.save(scheduler);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T upScheduler(CustomScheduler scheduler) throws Exception {
		try {
			return (T) schedulerRepository.save(scheduler);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T deScheduler(CustomScheduler scheduler) throws Exception {
		try {
			schedulerRepository.delete(scheduler);
			return (T) Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
}
