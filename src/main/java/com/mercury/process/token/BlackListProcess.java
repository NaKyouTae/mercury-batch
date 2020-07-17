package com.mercury.process.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercury.jpa.model.token.BlackList;
import com.mercury.jpa.repository.token.BlackListRepository;

@Component
@SuppressWarnings("unchecked")
public class BlackListProcess {
	
	@Autowired
	private BlackListRepository blackListRepository;
	
	public <T extends Object> T getBlackList() throws Exception {
		try {
			return (T) blackListRepository.findAll();
		} catch (Exception e) {
			 e.printStackTrace();
			 return (T) e;
		}
	}
	
	public <T extends Object> T deBlackList(BlackList black) throws Exception {
		try {
			blackListRepository.delete(black);
			return (T) Boolean.TRUE;
		} catch (Exception e) {
			 e.printStackTrace();
			 return (T) e;
		}
	}
}
