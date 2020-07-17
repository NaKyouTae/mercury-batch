package com.mercury.process.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercury.jpa.model.token.TokenRefresh;
import com.mercury.jpa.repository.token.TokenRefreshRepository;

@Component
@SuppressWarnings("unchecked")
public class TokenRefreshProcess {
	
	@Autowired
	private TokenRefreshRepository tokenRefreshRepository;
	
	public <T extends Object> T getList() throws Exception {
		try {
			return (T) tokenRefreshRepository.findAll();
		} catch (Exception e) {
			 e.printStackTrace();
			 return (T) e;
		}
	}
	
	public <T extends Object> T deRefresh(TokenRefresh refresh) throws Exception {
		try {
			tokenRefreshRepository.delete(refresh);
			return (T) Boolean.TRUE;
		} catch (Exception e) {
			 e.printStackTrace();
			 return (T) e;
		}
	}
}
