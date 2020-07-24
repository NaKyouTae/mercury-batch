package com.mercury.service.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.jpa.model.history.HistorySchedule;
import com.mercury.process.history.HistoryScheduleProcess;

@Service
@SuppressWarnings("unchecked")
public class HistoryScheduleService {

	@Autowired
	private HistoryScheduleProcess historyScheduleProcess;
	
	public <T extends Object> T seScheduleHistorys() throws Exception {
		try {
			return (T) historyScheduleProcess.seScheduleHistorys();
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seScheduleHistoryByIdx(String idx) throws Exception {
		try {
			return (T) historyScheduleProcess.seScheduleHistoryByIdx(idx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seScheduleHistoryByScheduleName(String scheduleName) throws Exception {
		try {
			return (T) historyScheduleProcess.seScheduleHistoryByScheduleName(scheduleName);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seScheduleHistoryByJobName(String jobName) throws Exception {
		try {
			return (T) historyScheduleProcess.seScheduleHistoryByJobName(jobName);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seScheduleHistoryByTriggerName(String triggerName) throws Exception {
		try {
			return (T) historyScheduleProcess.seScheduleHistoryByTriggerName(triggerName);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seScheduleHistoryByType(String type) throws Exception {
		try {
			return (T) historyScheduleProcess.seScheduleHistoryByType(type);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seScheduleHistoryByCron(String cron) throws Exception {
		try {
			return (T) historyScheduleProcess.seScheduleHistoryByCron(cron);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T deScheduleHistory(HistorySchedule schedule) throws Exception {
		try {
			return (T) historyScheduleProcess.deScheduleHistory(schedule);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
}
