package com.mercury.process.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercury.jpa.model.quartz.CustomSchedule;
import com.mercury.jpa.repository.quartz.QuartzScheduleRepository;

@Component
@SuppressWarnings("unchecked")
public class QuartzScheduleProcess {
	
	@Autowired
	private QuartzScheduleRepository quartzScheduleRepository;
	
	public <T extends Object> T seSchedules() throws Exception{
		try {
			return (T) quartzScheduleRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seSchedule(String idx) throws Exception{
		try {
			return (T) quartzScheduleRepository.findByIdx(idx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seScheduleByJob(String idx) throws Exception{
		try {
			return (T) quartzScheduleRepository.findByJobIdx(idx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seScheduleByTrigger(String idx) throws Exception{
		try {
			return (T) quartzScheduleRepository.findByTriggerIdx(idx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T inSchedule(CustomSchedule schedule) throws Exception {
		try {
			return (T) quartzScheduleRepository.save(schedule);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T upSchedule(CustomSchedule schedule) throws Exception {
		try {
			return (T) quartzScheduleRepository.save(schedule);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T deSchedule(CustomSchedule schedule) throws Exception {
		try {
			quartzScheduleRepository.delete(schedule);
			return (T) Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
}
