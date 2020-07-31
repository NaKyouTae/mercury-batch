package com.mercury.process.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.model.token.TokenBlock;
import com.mercury.jpa.repository.token.TokenBlockRepository;

@Component
@SuppressWarnings("unchecked")
public class TokenBlockProcess {
	
	@Autowired
	private TokenBlockRepository blockTokenRepository;
	
	public TokenBlockProcess() {
		try {
			this.blockTokenRepository = ApplicationContextProvider.getBean("tokenBlockRepository");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public <T extends Object> T getBlockList() throws Exception {
		try {
			return (T) blockTokenRepository.findAll();
		} catch (Exception e) {
			 e.printStackTrace();
			 return (T) e;
		}
	}
	
	public <T extends Object> T deBlockList(TokenBlock block) throws Exception {
		try {
			blockTokenRepository.delete(block);
			return (T) Boolean.TRUE;
		} catch (Exception e) {
			 e.printStackTrace();
			 return (T) e;
		}
	}
}
