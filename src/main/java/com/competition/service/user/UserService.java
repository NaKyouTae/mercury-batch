package com.competition.service.user;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.competition.jpa.model.user.User;
import com.competition.jpa.repository.user.UserQuartzRepository;

@Service
public class UserService {
	
	@Autowired
	private UserQuartzRepository userQuartzRepository;
	
	public void seUsers() {
		List<User> users = userQuartzRepository.findAll();
		
		users.stream().filter(u -> {
			System.out.println(u.getUsername() + " ::::::: " + LocalDateTime.now());
			return true;
		});
	}
	
	public void upUserGrade() {
		
	}
	
	public void upUserPoint() {
		
	}
}
