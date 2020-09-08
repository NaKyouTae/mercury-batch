package com.mercury.process.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.jpa.model.history.HistorySchedule;
import com.mercury.jpa.repository.history.HistoryScheduleRepository;

@Component
@Transactional
@SuppressWarnings("unchecked")
public class HistoryScheduleProcess {

	@Autowired
	private HistoryScheduleRepository historyScheduleRepository;

	public <T extends Object> T seScheduleHistorys() throws Exception {
		return (T) historyScheduleRepository.findAll();
	}

	public <T extends Object> T seScheduleHistoryByIdx(String idx)
			throws Exception {
		return (T) historyScheduleRepository.findByIdx(idx);
	}

	public <T extends Object> T seScheduleHistoryByScheduleName(
			String scheduleName) throws Exception {
		return (T) historyScheduleRepository.findByScheduleName(scheduleName);
	}

	public <T extends Object> T seScheduleHistoryByJobName(String jobName)
			throws Exception {
		return (T) historyScheduleRepository.findByJobName(jobName);
	}

	public <T extends Object> T seScheduleHistoryByTriggerName(
			String triggerName) throws Exception {
		return (T) historyScheduleRepository.findByTriggerName(triggerName);
	}

	public <T extends Object> T seScheduleHistoryByType(String type)
			throws Exception {
		return (T) historyScheduleRepository.findByType(type);
	}

	public <T extends Object> T seScheduleHistoryByCron(String cron)
			throws Exception {
		return (T) historyScheduleRepository.findByCron(cron);
	}

	public <T extends Object> T deScheduleHistory(HistorySchedule schedule)
			throws Exception {
		historyScheduleRepository.delete(schedule);
		return (T) Boolean.TRUE;
	}
}
