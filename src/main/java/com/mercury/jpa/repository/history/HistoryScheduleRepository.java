package com.mercury.jpa.repository.history;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercury.jpa.model.history.HistorySchedule;

@Repository
public interface HistoryScheduleRepository extends JpaRepository<HistorySchedule, Long>{
	HistorySchedule findByIdx(String idx);
	List<HistorySchedule> findByCron(String cron);
	List<HistorySchedule> findByJobName(String jobName);
	List<HistorySchedule> findByScheduleName(String scheduleName);
	List<HistorySchedule> findByTriggerName(String triggerName);
	List<HistorySchedule> findByType(String type);
}
