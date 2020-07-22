package com.mercury.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.service.quartz.QuartzScheduleService;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/service/batch")
public class QuartzScheduleController {

	@Autowired
	private QuartzScheduleService quartzScheduleService;
	
	@DeleteMapping("/scheduler")
	public <T extends Object> T stopScheduler(@RequestBody String triggerName) throws Exception {
		try {
			return (T) quartzScheduleService.stopSchedule(triggerName);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
}
