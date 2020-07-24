package com.mercury.controller.quartz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.common.ControllerResponse;
import com.mercury.jpa.model.quartz.CustomTrigger;
import com.mercury.service.quartz.TriggerService;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/batch/service/trigger")
public class TriggerController {
	
	@Autowired
	private TriggerService triggerService;
	
	@GetMapping("")
	public <T extends Object> T seTriggers() throws Exception {
		ControllerResponse<List<CustomTrigger>> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Search Trigger List :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(triggerService.seTriggers());
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@GetMapping("/now")
	public <T extends Object> T seNowTriggers() throws Exception{
		ControllerResponse<List<CustomTrigger>> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Search Now Trigger List :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(triggerService.seNowTriggers());
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		return (T) res;
	}
	
	@GetMapping("/idx")
	public <T extends Object> T seTriggerByIdx(String idx) throws Exception{
		ControllerResponse<CustomTrigger> res = new ControllerResponse<>();
		
		try {
			res.setMessage("Success Search Trigger By Idx :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(triggerService.seTriggerByIdx(idx));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@GetMapping("/title")
	public <T extends Object> T seTriggerByTitle(String title) throws Exception{
		ControllerResponse<CustomTrigger> res = new ControllerResponse<>();
		
		try {
			res.setMessage("Success Search Trigger By Title :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(triggerService.seTriggerByTitle(title));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@GetMapping("/name")
	public <T extends Object> T seTriggerByName(String name) throws Exception{
		ControllerResponse<CustomTrigger> res = new ControllerResponse<>();
		
		try {
			res.setMessage("Success Search Trigger By Name :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(triggerService.seTriggerByName(name));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	public <T extends Object> T seTriggerByJobTitle(String jobTitle) throws Exception{
		ControllerResponse<CustomTrigger> res = new ControllerResponse<>();
		
		try {
			res.setMessage("Success Search Trigger By Job Title :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(triggerService.seTriggerByJobTitle(jobTitle));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	public <T extends Object> T upTriggerCron(CustomTrigger trigger) {
		ControllerResponse<CustomTrigger> res = new ControllerResponse<>();
		
		try {
			res.setMessage("Success Update Trigger Cron :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(triggerService.upTriggerCron(trigger));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	public <T extends Object> T upTrigger(CustomTrigger trigger) throws Exception {
		ControllerResponse<CustomTrigger> res = new ControllerResponse<>();
		
		try {
			res.setMessage("Success Update Trigger :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(triggerService.upTrigger(trigger));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	public <T extends Object> T inTrigger(CustomTrigger trigger) throws Exception {
		ControllerResponse<CustomTrigger> res = new ControllerResponse<>();
		
		try {
			res.setMessage("Success Insert Trigger :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(triggerService.inTrigger(trigger));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	public <T extends Object> T deTrigger(CustomTrigger trigger) throws Exception {
		ControllerResponse<CustomTrigger> res = new ControllerResponse<>();
		
		try {
			res.setMessage("Success Delete Trigger :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(triggerService.deTrigger(trigger));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}

}
