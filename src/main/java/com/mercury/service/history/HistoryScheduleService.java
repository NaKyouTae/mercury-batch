package com.mercury.service.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.jpa.model.history.HistorySchedule;
import com.mercury.process.history.HistoryScheduleProcess;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class HistoryScheduleService {

	@Autowired
	private HistoryScheduleProcess historyScheduleProcess;

	public <T extends Object> T seScheduleHistorys() throws Exception {
		return (T) historyScheduleProcess.seScheduleHistorys();
	}

	public <T extends Object> T seScheduleHistoryByIdx(String idx)
			throws Exception {
		return (T) historyScheduleProcess.seScheduleHistoryByIdx(idx);
	}

	public <T extends Object> T seScheduleHistoryByScheduleName(
			String scheduleName) throws Exception {
		return (T) historyScheduleProcess
				.seScheduleHistoryByScheduleName(scheduleName);
	}

	public <T extends Object> T seScheduleHistoryByJobName(String jobName)
			throws Exception {
		try {
			return (T) historyScheduleProcess
					.seScheduleHistoryByJobName(jobName);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}

	public <T extends Object> T seScheduleHistoryByTriggerName(
			String triggerName) throws Exception {
		return (T) historyScheduleProcess
				.seScheduleHistoryByTriggerName(triggerName);
	}

	public <T extends Object> T seScheduleHistoryByType(String type)
			throws Exception {
		return (T) historyScheduleProcess.seScheduleHistoryByType(type);
	}

	public <T extends Object> T seScheduleHistoryByCron(String cron)
			throws Exception {
		return (T) historyScheduleProcess.seScheduleHistoryByCron(cron);
	}

	public <T extends Object> T deScheduleHistory(HistorySchedule schedule)
			throws Exception {
		return (T) historyScheduleProcess.deScheduleHistory(schedule);
	}
}
