package com.mercury.controller.quartz;

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
import com.mercury.jpa.model.quartz.CustomJob;
import com.mercury.service.quartz.JobService;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/batch/service/job")
public class JobController {

	@Autowired
	private JobService jobService;
	
	@GetMapping
	public <T extends Object> T seJobs() throws Exception {
		ControllerResponse<List<CustomJob>> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Search Job List :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(jobService.seJobs());
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@GetMapping("/idx")
	public <T extends Object> T seJobByIdx(String idx) throws Exception {
		ControllerResponse<CustomJob> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Search Job By Idx :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(jobService.seJobByIdx(idx));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@GetMapping("/title")
	public <T extends Object> T seJobByTitle(String title) throws Exception {
		ControllerResponse<CustomJob> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Search Job By Title :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(jobService.seJobByTitle(title));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@GetMapping("/name")
	public <T extends Object> T seJobByName(String name) throws Exception {
		ControllerResponse<CustomJob> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Search Job By Name :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(jobService.seJobByTitle(name));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@GetMapping("/clasz")
	public <T extends Object> T seJobByClasz(String clasz) throws Exception {
		ControllerResponse<CustomJob> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Search Job By Class :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(jobService.seJobByClasz(clasz));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@PostMapping
	public <T extends Object> T inJob(@RequestBody CustomJob job) throws Exception {
		ControllerResponse<CustomJob> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Insert Job :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(jobService.inJob(job));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@PutMapping
	public <T extends Object> T upJob(@RequestBody CustomJob job) throws Exception {
		ControllerResponse<CustomJob> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Update Job :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(jobService.upJob(job));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@DeleteMapping
	public <T extends Object> T deJob(@RequestBody CustomJob job) throws Exception {
		ControllerResponse<CustomJob> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Delete Job :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(jobService.deJob(job));
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		
		return (T) res;
	}
}
