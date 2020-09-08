package com.mercury.process.honor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.jpa.model.honor.Honor;
import com.mercury.jpa.repository.honor.HonorRepository;

@Component
@Transactional
@SuppressWarnings("unchecked")
public class HonorProcess {
	@Autowired
	private HonorRepository honorRepository;

	public <T extends Object> T inHonor(Honor honor) throws Exception {
		return (T) honorRepository.save(honor);
	}

	public <T extends Object> T inHonors(List<Honor> honors) throws Exception {
		return (T) honorRepository.saveAll(honors);
	}
}
