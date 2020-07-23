package com.mercury.service.quartz;

import org.springframework.stereotype.Service;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.model.quartz.CustomJob;
import com.mercury.process.quartz.JobProcess;

@Service
@SuppressWarnings("unchecked")
public class JobService {
	
	private JobProcess jobProcess;
	
	public JobService() {
		this.jobProcess = ApplicationContextProvider.getBean("jobProcess");
	}
	
	public <T extends Object> T seJobs() throws Exception {
		try {
			return (T) jobProcess.seJobs();
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seJobByIdx(String idx) throws Exception {
		try {
			return (T) jobProcess.seJobByIdx(idx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seJobByTitle(String title) throws Exception {
		try {
			return (T) jobProcess.seJobByTitle(title);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seJobByName(String name) throws Exception {
		try {
			return (T) jobProcess.seJobByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seJobByClasz(String clasz) throws Exception {
		try {
			return (T) jobProcess.seJobByClasz(clasz);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T inJob(CustomJob job) throws Exception {
		try {
			return (T) jobProcess.inJob(job);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T upJob(CustomJob job) throws Exception {
		try {
			return (T) jobProcess.upJob(job);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T deJob(CustomJob job) throws Exception {
		try {
			return (T) jobProcess.deJob(job);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
}
