package com.mercury.process.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.model.quartz.CustomTrigger;
import com.mercury.jpa.repository.quartz.TriggerRepository;
import com.mercury.util.DateUtil;
import com.mercury.util.UUIDUtil;

@Component
@Transactional
@SuppressWarnings("unchecked")
public class TriggerProcess {

	@Autowired
	private TriggerRepository triggerRepository;

	public TriggerProcess() {
		try {
			this.triggerRepository = ApplicationContextProvider.getBean("triggerRepository");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public <T extends Object> T seTriggers() throws Exception {
		return (T) triggerRepository.findAll();
	}

	public <T extends Object> T seTriggerByIdx(String idx) throws Exception {
		return (T) triggerRepository.findByIdx(idx);
	}

	public <T extends Object> T seTriggerByTitle(String title)
			throws Exception {
		return (T) triggerRepository.findByTitle(title);
	}

	public <T extends Object> T seTriggerByName(String name) throws Exception {
		return (T) triggerRepository.findByName(name);
	}

	public <T extends Object> T seTriggerByJobIdx(String jobTitle)
			throws Exception {
		return (T) triggerRepository.findByJobIdx(jobTitle);
	}

	public <T extends Object> T inTrigger(CustomTrigger trigger)
			throws Exception {
		trigger.setIdx(UUIDUtil.randomString());
		trigger.setInsertDate(DateUtil.now());
		return (T) triggerRepository.save(trigger);
	}

	public <T extends Object> T upTrigger(CustomTrigger trigger)
			throws Exception {
		return (T) triggerRepository.save(trigger);
	}

	public <T extends Object> T deTrigger(CustomTrigger trigger)
			throws Exception {
		triggerRepository.delete(trigger);
		return (T) Boolean.TRUE;
	}
}
