package com.mercury.process.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.model.user.User;
import com.mercury.jpa.repository.user.UserRepository;

@Component
@Transactional
@SuppressWarnings("unchecked")
public class UserProcess {

	@Autowired
	private UserRepository userRepository;

	public UserProcess() {
		try {
			this.userRepository = ApplicationContextProvider.getBean("userRepository");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public <T extends Object> T seUsers() throws Exception {
		return (T) userRepository.findAll();
	}

	public <T extends Object> T seUser(String idx) throws Exception {
		return (T) userRepository.findByIdx(idx);
	}

	public <T extends Object> T upUser(User user) throws Exception {
		return (T) userRepository.save(user);
	}
}
