package com.mercury.controller.history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.common.ControllerResponse;
import com.mercury.jpa.model.history.HistorySchedule;
import com.mercury.service.history.HistoryScheduleService;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/batch/service/history")
public class HistoryScheduleController {
	
	@Autowired
	private HistoryScheduleService historyScheduleService;
	
	@GetMapping
	public <T extends Object> T seScheduleHistorys() throws Exception {
		ControllerResponse<List<HistorySchedule>> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Search Schedule History List :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(historyScheduleService.seScheduleHistorys());
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@GetMapping("/idx")
	public <T extends Object> T seScheduleHistoryByIdx(String idx) throws Exception {
		ControllerResponse<List<HistorySchedule>> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Search Schedule History List By Idx :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(historyScheduleService.seScheduleHistoryByIdx(idx));			
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		return (T) res;
	}
	
	@GetMapping("/schedule")
	public <T extends Object> T seScheduleHistoryByScheduleName(String scheduleName) throws Exception {
		ControllerResponse<List<HistorySchedule>> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Search Schedule History List By Schedule Name :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(historyScheduleService.seScheduleHistoryByScheduleName(scheduleName));			
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		return (T) res;
	}
	
	@GetMapping("/job")
	public <T extends Object> T seScheduleHistoryByJobName(String jobName) throws Exception {
		ControllerResponse<List<HistorySchedule>> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Search Schedule History List By Job Name :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(historyScheduleService.seScheduleHistoryByJobName(jobName));	
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		return (T) res;
	}
	
	@GetMapping("/trigger")
	public <T extends Object> T seScheduleHistoryByTriggerName(String triggerName) throws Exception {
		ControllerResponse<List<HistorySchedule>> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Search Schedule History List By Trigger Name :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(historyScheduleService.seScheduleHistoryByTriggerName(triggerName));	
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		return (T) res;
	}
	
	@GetMapping("/type")
	public <T extends Object> T seScheduleHistoryByType(String type) throws Exception {
		ControllerResponse<List<HistorySchedule>> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Search Schedule History List By Type :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(historyScheduleService.seScheduleHistoryByType(type));	
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		return (T) res;
	}
	
	@GetMapping("/cron")
	public <T extends Object> T seScheduleHistoryByCron(String cron) throws Exception {
		ControllerResponse<List<HistorySchedule>> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Search Schedule History List By Cron :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(historyScheduleService.seScheduleHistoryByCron(cron));	
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		return (T) res;
	}
	
	@DeleteMapping
	public <T extends Object> T deScheduleHistory(@RequestBody HistorySchedule schedule) throws Exception {
		ControllerResponse<Boolean> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Delete Schedule History :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(historyScheduleService.deScheduleHistory(schedule));	
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		return (T) res;
	}
}
