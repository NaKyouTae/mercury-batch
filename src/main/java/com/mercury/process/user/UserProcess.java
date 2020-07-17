package com.mercury.process.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercury.jpa.model.user.User;
import com.mercury.jpa.repository.user.UserRepository;

@Component
@SuppressWarnings("unchecked")
public class UserProcess {
	
	@Autowired
	private UserRepository userRepository;
	
	public <T extends Object> T seUsers() throws Exception {
		try {
			return (T) userRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			 return (T) e;
		}
	}
	
	public <T extends Object> T seUser(String idx) throws Exception {
		try {
			return (T) userRepository.findByIdx(idx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T upUser(User user) throws Exception {
		try {
			return (T) userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			 return (T) e;
		}
		
	}
}
