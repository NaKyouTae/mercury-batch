package com.mercury.service.token;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.jpa.model.token.BlackList;
import com.mercury.process.token.BlackListProcess;
import com.mercury.util.DateUtil;

@Service
@SuppressWarnings("unchecked")
public class BlackListService {
	
	@Autowired
	private BlackListProcess blackListProcess;
	
	public <T extends Object> T getBlackList() throws Exception {
		try {
			return (T) blackListProcess.getBlackList();
		} catch (Exception e) {
			 e.printStackTrace();
			 return (T) e;
		}
	}
	
	public <T extends Object> T deBlackList() throws Exception {
		try {
			Boolean result = Boolean.FALSE;
			List<BlackList> list = getBlackList();
			 
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			
			for(BlackList l : list) {
				Date insert = format.parse(l.getInsertDate());
				Date now = format.parse(DateUtil.now());
				
				long d = insert.getTime() - now.getTime();
				
				if(d >= 0 && 31 >= d) {
					result = blackListProcess.deBlackList(l);
				}
			}
			
			return (T) result;
		} catch (Exception e) {
			 e.printStackTrace();
			 return (T) e;
		}
	}
}
