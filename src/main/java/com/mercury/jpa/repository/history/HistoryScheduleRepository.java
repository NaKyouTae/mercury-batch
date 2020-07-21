package com.mercury.jpa.repository.history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercury.jpa.model.history.HistorySchedule;

@Repository
public interface HistoryScheduleRepository extends JpaRepository<HistorySchedule, Long>{
	
}
