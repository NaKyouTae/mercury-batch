package com.mercury.process.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercury.jpa.model.quartz.CustomTrigger;
import com.mercury.jpa.repository.quartz.QuartzTriggerRepository;

@Component
@SuppressWarnings("unchecked")
public class QuartzTriggerProcess {
	
	@Autowired
	private QuartzTriggerRepository quartzTriggerRepository;
	
	public <T extends Object> T seTriggers() throws Exception {
		try {
			return (T) quartzTriggerRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T inTrigger(CustomTrigger trigger) throws Exception {
		try {
			return (T) quartzTriggerRepository.save(trigger);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T upTrigger(CustomTrigger trigger) throws Exception {
		try {
			return (T) quartzTriggerRepository.save(trigger);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T upTriggerCron(CustomTrigger trigger) throws Exception {
		try {
			return (T) quartzTriggerRepository.save(trigger);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T deTrigger(CustomTrigger trigger) throws Exception {
		try {
			quartzTriggerRepository.delete(trigger);
			return (T) Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
			 return (T) e;
		}
	}
}
