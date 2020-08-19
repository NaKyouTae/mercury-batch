package com.mercury.process.honor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercury.jpa.model.honor.Honor;
import com.mercury.jpa.repository.honor.HonorRepository;

@Component
@SuppressWarnings("unchecked")
public class HonorProcess {
	@Autowired
	private HonorRepository honorRepository;
	
	public <T extends Object> T inHonor(Honor honor) throws Exception{
		try {
			return (T) honorRepository.save(honor);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T inHonors(List<Honor> honors) throws Exception {
		try {
			return (T) honorRepository.saveAll(honors);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
}
