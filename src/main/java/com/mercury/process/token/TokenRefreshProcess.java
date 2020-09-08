package com.mercury.process.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.model.token.TokenRefresh;
import com.mercury.jpa.repository.token.TokenRefreshRepository;

@Component
@Transactional
@SuppressWarnings("unchecked")
public class TokenRefreshProcess {

	@Autowired
	private TokenRefreshRepository tokenRefreshRepository;

	public TokenRefreshProcess() {
		try {
			this.tokenRefreshRepository = ApplicationContextProvider.getBean("tokenRefreshRepository");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public <T extends Object> T getList() throws Exception {
		return (T) tokenRefreshRepository.findAll();
	}

	public <T extends Object> T deRefresh(TokenRefresh refresh)
			throws Exception {
		tokenRefreshRepository.delete(refresh);
		return (T) Boolean.TRUE;
	}
}
