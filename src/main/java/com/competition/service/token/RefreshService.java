package com.competition.service.token;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.competition.jpa.model.token.Refresh;
import com.competition.process.token.RefreshProcess;
import com.competition.util.DateUtil;

@Service
@SuppressWarnings("unchecked")
public class RefreshService {
	
	@Autowired
	private RefreshProcess refreshProcess;
	
	public <T extends Object> T getList() throws Exception {
		try {
			return (T) refreshProcess.getList();
		} catch (Exception e) {
			 e.printStackTrace();
			 return (T) e;
		}
	}
	
	public <T extends Object> T deRefresh() throws Exception {
		try {
			
			Boolean result = Boolean.FALSE;
			List<Refresh> list = getList();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			
			for(Refresh l : list) {
				Date insert = format.parse(l.getInsertDate());
				Date now = format.parse(DateUtil.now());
				
				long d = insert.getTime() - now.getTime();
				
				if(d >= 0 && 31 >= d) {
					result = refreshProcess.deRefresh(l);
				}
			}
			
			return (T) result;
		} catch (Exception e) {
			 e.printStackTrace();
			 return (T) e;
		}
	}
}
