package com.mercury.service.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.process.mail.NewsLetterProcess;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class NewsLetterService {
	@Autowired
	private NewsLetterProcess newsLetterProcess = new NewsLetterProcess();

	public <T extends Object> T seNewsLetterByUserName(String userName)
			throws Exception {
		return (T) newsLetterProcess.seNewsLetterByUserName(userName);
	}

	public <T extends Object> T seNewsLetterByUserIdx(String userIdx)
			throws Exception {
		return (T) newsLetterProcess.seNewsLetterByUserIdx(userIdx);
	}

	public <T extends Object> T seNewsLetters() throws Exception {
		return (T) newsLetterProcess.seNewsLetters();
	}

	public <T extends Object> T seNewsLetter(String idx) throws Exception {
		return (T) newsLetterProcess.seNewsLetter(idx);
	}
}
