package com.mercury.service.quartz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.model.quartz.CustomJob;
import com.mercury.process.quartz.JobProcess;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class JobService {

	private JobProcess jobProcess;

	public JobService() throws Exception {
		this.jobProcess = ApplicationContextProvider.getBean("jobProcess");
	}

	public <T extends Object> T seJobs() throws Exception {
		return (T) jobProcess.seJobs();
	}

	public <T extends Object> T seJobByIdx(String idx) throws Exception {
		return (T) jobProcess.seJobByIdx(idx);
	}

	public <T extends Object> T seJobByTitle(String title) throws Exception {
		return (T) jobProcess.seJobByTitle(title);
	}

	public <T extends Object> T seJobByName(String name) throws Exception {
		return (T) jobProcess.seJobByName(name);
	}

	public <T extends Object> T seJobByClasz(String clasz) throws Exception {
		return (T) jobProcess.seJobByClasz(clasz);
	}

	public <T extends Object> T inJob(CustomJob job) throws Exception {
		return (T) jobProcess.inJob(job);
	}

	public <T extends Object> T upJob(CustomJob job) throws Exception {
		return (T) jobProcess.upJob(job);
	}

	public <T extends Object> T deJob(CustomJob job) throws Exception {
		return (T) jobProcess.deJob(job);
	}
}
