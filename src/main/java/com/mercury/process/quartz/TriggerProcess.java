package com.mercury.process.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.model.quartz.CustomTrigger;
import com.mercury.jpa.repository.quartz.TriggerRepository;
import com.mercury.util.DateUtil;
import com.mercury.util.UUIDUtil;

@Component
@SuppressWarnings("unchecked")
public class TriggerProcess {
	
	@Autowired
	private TriggerRepository triggerRepository;
	
	public TriggerProcess() {
		try {
			this.triggerRepository = ApplicationContextProvider.getBean("triggerRepository");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public <T extends Object> T seTriggers() throws Exception {
		try {
			return (T) triggerRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seTriggerByIdx(String idx) throws Exception {
		try {
			return (T) triggerRepository.findByIdx(idx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seTriggerByTitle(String title) throws Exception {
		try {
			return (T) triggerRepository.findByTitle(title);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seTriggerByName(String name) throws Exception {
		try {
			return (T) triggerRepository.findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seTriggerByJobIdx(String jobTitle) throws Exception {
		try {
			return (T) triggerRepository.findByJobIdx(jobTitle);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T inTrigger(CustomTrigger trigger) throws Exception {
		try {
			trigger.setIdx(UUIDUtil.randomString());
			trigger.setInsertDate(DateUtil.now());
			return (T) triggerRepository.save(trigger);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T upTrigger(CustomTrigger trigger) throws Exception {
		try {
			return (T) triggerRepository.save(trigger);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	
	public <T extends Object> T deTrigger(CustomTrigger trigger) throws Exception {
		try {
			triggerRepository.delete(trigger);
			return (T) Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
			 return (T) e;
		}
	}
}
