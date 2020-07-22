package com.mercury.service.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.process.mail.NewsLetterProcess;

@Service
@SuppressWarnings("unchecked")
public class NewsLetterService {
	@Autowired
	private NewsLetterProcess newsLetterProcess = new NewsLetterProcess();
	
	public <T extends Object> T seNewsLetterByUserName(String userName) throws Exception {
		try {
			return (T) newsLetterProcess.seNewsLetterByUserName(userName);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seNewsLetterByUserIdx(String userIdx) throws Exception {
		try {
			return (T) newsLetterProcess.seNewsLetterByUserIdx(userIdx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seNewsLetters() throws Exception {
		try {
			return (T) newsLetterProcess.seNewsLetters();
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seNewsLetter(String idx) throws Exception {
		try {
			return (T) newsLetterProcess.seNewsLetter(idx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
}
