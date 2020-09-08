package com.mercury.util;

import org.quartz.JobDataMap;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.model.history.HistorySchedule;
import com.mercury.jpa.repository.history.HistoryScheduleRepository;

public class JpaUtil {

	public static void save(JobDataMap data) throws Exception {
		HistoryScheduleRepository hsr = ApplicationContextProvider
				.getBean("historyScheduleRepository");
		HistorySchedule hs = new HistorySchedule();

		hs.setCron(data.getString("cron"));
		hs.setTriggerName(data.getString("triggername"));
		hs.setJobName(data.getString("jobname"));
		hs.setScheduleName(data.getString("schedulename"));
		hs.setMessage(data.getString("message"));
		hs.setStartDate(DateUtil.now());

		hsr.save(hs);
	}
}
