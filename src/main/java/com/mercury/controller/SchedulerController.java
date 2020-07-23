package com.mercury.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.common.ControllerResponse;
import com.mercury.jpa.model.quartz.CustomScheduler;
import com.mercury.service.quartz.SchedulerService;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/service/batch/scheduler")
public class SchedulerController {

	@Autowired
	private SchedulerService schedulerService;
	
	@DeleteMapping("/stop")
	public <T extends Object> T stopScheduler(@RequestBody String triggerName) throws Exception {
		ControllerResponse<Boolean> res = new ControllerResponse<>();
		try {
			return (T) schedulerService.stopSchedule(triggerName);
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@GetMapping("/idxs")
	public <T extends Object> T seSchedulerByIdx(String idx) throws Exception{
		ControllerResponse<CustomScheduler> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Search Scheduler By Index :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(schedulerService.seSchedulerByIdx(idx));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@GetMapping("/names")
	public <T extends Object> T seSchedulerByName(String name) throws Exception{
		ControllerResponse<CustomScheduler> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Search Scheduler By Name :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(schedulerService.seSchedulerByName(name));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@GetMapping("/jobs")
	public <T extends Object> T seSchedulerByJob(String job) throws Exception{
		ControllerResponse<CustomScheduler> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Search Scheduler By Job :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(schedulerService.seSchedulerByJob(job));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@GetMapping("/triggers")
	public <T extends Object> T seSchedulerByTrigger(String trigger) throws Exception{
		ControllerResponse<CustomScheduler> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Search Scheduler By Trigger :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(schedulerService.seSchedulerByTrigger(trigger));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@GetMapping("")
	public <T extends Object> T seSchedulers(String trigger) throws Exception{
		ControllerResponse<List<CustomScheduler>> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Search Scheduler List :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(schedulerService.seSchedulers());
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@PostMapping("")
	public <T extends Object> T inScheduler(@RequestBody CustomScheduler scheduler) throws Exception {
		ControllerResponse<CustomScheduler> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Insert Scheduler :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(schedulerService.inScheduler(scheduler));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@PutMapping("")
	public <T extends Object> T upScheduler(@RequestBody CustomScheduler scheduler) throws Exception {
		ControllerResponse<CustomScheduler> res = new ControllerResponse<>();
		try {
			res.setMessage("Success update Scheduler :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(schedulerService.upScheduler(scheduler));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@DeleteMapping("")
	public <T extends Object> T deScheduler(@RequestBody CustomScheduler scheduler) throws Exception {
		ControllerResponse<Boolean> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Delete Scheduler :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(schedulerService.deScheduler(scheduler));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
}
