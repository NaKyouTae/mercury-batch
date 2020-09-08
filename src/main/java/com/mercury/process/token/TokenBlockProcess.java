package com.mercury.process.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.model.token.TokenBlock;
import com.mercury.jpa.repository.token.TokenBlockRepository;

@Component
@Transactional
@SuppressWarnings("unchecked")
public class TokenBlockProcess {

	@Autowired
	private TokenBlockRepository blockTokenRepository;

	public TokenBlockProcess() {
		try {
			this.blockTokenRepository = ApplicationContextProvider.getBean("tokenBlockRepository");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public <T extends Object> T getBlockList() throws Exception {
		return (T) blockTokenRepository.findAll();
	}

	public <T extends Object> T deBlockList(TokenBlock block) throws Exception {
		blockTokenRepository.delete(block);
		return (T) Boolean.TRUE;
	}
}
