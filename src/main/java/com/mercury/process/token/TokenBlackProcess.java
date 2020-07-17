package com.mercury.process.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercury.jpa.model.token.TokenBlack;
import com.mercury.jpa.repository.token.TokenBlackRepository;

@Component
@SuppressWarnings("unchecked")
public class TokenBlackProcess {
	
	@Autowired
	private TokenBlackRepository blackTokenRepository;
	
	public <T extends Object> T getBlackList() throws Exception {
		try {
			return (T) blackTokenRepository.findAll();
		} catch (Exception e) {
			 e.printStackTrace();
			 return (T) e;
		}
	}
	
	public <T extends Object> T deBlackList(TokenBlack black) throws Exception {
		try {
			blackTokenRepository.delete(black);
			return (T) Boolean.TRUE;
		} catch (Exception e) {
			 e.printStackTrace();
			 return (T) e;
		}
	}
}
