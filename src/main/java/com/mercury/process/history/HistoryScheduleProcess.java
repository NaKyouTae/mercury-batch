package com.mercury.process.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercury.jpa.model.history.HistorySchedule;
import com.mercury.jpa.repository.history.HistoryScheduleRepository;

@Component
@SuppressWarnings("unchecked")
public class HistoryScheduleProcess {

	
	@Autowired
	private HistoryScheduleRepository historyScheduleRepository;
	
	public <T extends Object> T seScheduleHistorys() throws Exception {
		try {
			return (T) historyScheduleRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seScheduleHistoryByIdx(String idx) throws Exception {
		try {
			return (T) historyScheduleRepository.findByIdx(idx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seScheduleHistoryByScheduleName(String scheduleName) throws Exception {
		try {
			return (T) historyScheduleRepository.findByScheduleName(scheduleName);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seScheduleHistoryByJobName(String jobName) throws Exception {
		try {
			return (T) historyScheduleRepository.findByJobName(jobName);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seScheduleHistoryByTriggerName(String triggerName) throws Exception {
		try {
			return (T) historyScheduleRepository.findByTriggerName(triggerName);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seScheduleHistoryByType(String type) throws Exception {
		try {
			return (T) historyScheduleRepository.findByType(type);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seScheduleHistoryByCron(String cron) throws Exception {
		try {
			return (T) historyScheduleRepository.findByCron(cron);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T deScheduleHistory(HistorySchedule schedule) throws Exception {
		try {
			historyScheduleRepository.delete(schedule);
			return (T) Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
}
