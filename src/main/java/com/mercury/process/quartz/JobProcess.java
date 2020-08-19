package com.mercury.process.quartz;

import org.springframework.stereotype.Component;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.model.quartz.CustomJob;
import com.mercury.jpa.repository.quartz.JobRepository;
import com.mercury.util.DateUtil;
import com.mercury.util.UUIDUtil;

@Component
@SuppressWarnings("unchecked")
public class JobProcess {
	
	private JobRepository jobRepository;
	
	
	public JobProcess() {
		this.jobRepository = ApplicationContextProvider.getBean("jobRepository");
	}
	
	public <T extends Object> T seJobs() throws Exception {
		try {
			return (T) jobRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seJobByIdx(String idx) throws Exception {
		try {
			return (T) jobRepository.findByIdx(idx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seJobByTitle(String title) throws Exception {
		try {
			return (T) jobRepository.findByTitle(title);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seJobByName(String name) throws Exception {
		try {
			return (T) jobRepository.findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seJobByClasz(String clasz) throws Exception {
		try {
			return (T) jobRepository.findByClasz(clasz);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T inJob(CustomJob job) throws Exception {
		try {
			job.setIdx(UUIDUtil.randomString());
			job.setInsertDate(DateUtil.now());
			return (T) jobRepository.save(job);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T upJob(CustomJob job) throws Exception {
		try {
			return (T) jobRepository.save(job);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T deJob(CustomJob job) throws Exception {
		try {
			jobRepository.delete(job);
			return (T) Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
}
