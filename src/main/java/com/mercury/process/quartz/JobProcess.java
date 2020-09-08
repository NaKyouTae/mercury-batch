package com.mercury.process.quartz;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.model.quartz.CustomJob;
import com.mercury.jpa.repository.quartz.JobRepository;
import com.mercury.util.DateUtil;
import com.mercury.util.UUIDUtil;

@Component
@Transactional
@SuppressWarnings("unchecked")
public class JobProcess {

	private JobRepository jobRepository;

	public JobProcess() throws Exception {
		this.jobRepository = ApplicationContextProvider
				.getBean("jobRepository");
	}

	public <T extends Object> T seJobs() throws Exception {
		return (T) jobRepository.findAll();
	}

	public <T extends Object> T seJobByIdx(String idx) throws Exception {
		return (T) jobRepository.findByIdx(idx);
	}

	public <T extends Object> T seJobByTitle(String title) throws Exception {
		return (T) jobRepository.findByTitle(title);
	}

	public <T extends Object> T seJobByName(String name) throws Exception {
		return (T) jobRepository.findByName(name);
	}

	public <T extends Object> T seJobByClasz(String clasz) throws Exception {
		return (T) jobRepository.findByClasz(clasz);
	}

	public <T extends Object> T inJob(CustomJob job) throws Exception {
		job.setIdx(UUIDUtil.randomString());
		job.setInsertDate(DateUtil.now());
		return (T) jobRepository.save(job);
	}

	public <T extends Object> T upJob(CustomJob job) throws Exception {
		return (T) jobRepository.save(job);
	}

	public <T extends Object> T deJob(CustomJob job) throws Exception {
		jobRepository.delete(job);
		return (T) Boolean.TRUE;
	}
}
