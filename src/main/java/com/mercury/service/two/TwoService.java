package com.mercury.service.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.process.two.TwoProcess;

@Service
@SuppressWarnings("unchecked")
public class TwoService {
	
	@Autowired
	private TwoProcess twoProcess;
	
	public <T extends Object> T getTotalPoint(String userIdx) throws Exception {
		try {
			return (T) twoProcess.getTotalPoint(userIdx);
		} catch (Exception e) {
			return (T) e;
		}
	}
	
	public <T extends Object> T getPopular() throws Exception {
		return (T) twoProcess.getPopular();
	}
	
	public <T extends Object> T getList() throws Exception {
		return (T) twoProcess.getList();
	}
	
	public <T extends Object> T seByUser(String userIdx) throws Exception {
		return (T) twoProcess.seByUser(userIdx);
	}
	
	public <T extends Object> T seByWord() throws Exception {
		return (T) twoProcess.seByWord();
	}
}
