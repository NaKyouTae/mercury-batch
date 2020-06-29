package com.competition.process.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.competition.jpa.model.token.Refresh;
import com.competition.jpa.repository.token.RefreshRepository;

@Component
@SuppressWarnings("unchecked")
public class RefreshProcess {
	
	@Autowired
	private RefreshRepository refreshRepository;
	
	public <T extends Object> T getList() throws Exception {
		try {
			return (T) refreshRepository.findAll();
		} catch (Exception e) {
			 e.printStackTrace();
			 return (T) e;
		}
	}
	
	public <T extends Object> T deRefresh(Refresh refresh) throws Exception {
		try {
			refreshRepository.delete(refresh);
			return (T) Boolean.TRUE;
		} catch (Exception e) {
			 e.printStackTrace();
			 return (T) e;
		}
	}
}
