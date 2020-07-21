package com.mercury.service.token;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mercury.jpa.model.token.TokenBlack;
import com.mercury.process.token.TokenBlackProcess;
import com.mercury.util.DateUtil;

@Service
@SuppressWarnings("unchecked")
public class TokenBlackService {
	
	private static final TokenBlackProcess TokenBlackProcess = new TokenBlackProcess();
	
	public <T extends Object> T getTokenBlack() throws Exception {
		try {
			return (T) TokenBlackProcess.getBlackList();
		} catch (Exception e) {
			 e.printStackTrace();
			 return (T) e;
		}
	}
	
	public <T extends Object> T deTokenBlack() throws Exception {
		try {
			Boolean result = Boolean.FALSE;
			List<TokenBlack> list = getTokenBlack();
			 
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			
			for(TokenBlack l : list) {
				Date insert = format.parse(l.getInsertDate());
				Date now = format.parse(DateUtil.now());
				
				long d = insert.getTime() - now.getTime();
				
				if(d >= 0 && 31 >= d) {
					result = TokenBlackProcess.deBlackList(l);
				}
			}
			
			return (T) result;
		} catch (Exception e) {
			 e.printStackTrace();
			 return (T) e;
		}
	}
}
