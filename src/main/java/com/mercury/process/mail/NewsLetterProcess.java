package com.mercury.process.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.repository.mail.NewsLetterRepository;

@Component
@Transactional
@SuppressWarnings("unchecked")
public class NewsLetterProcess {
	@Autowired
	private NewsLetterRepository newsLetterRepository;

	public NewsLetterProcess() {
		try {
			this.newsLetterRepository = ApplicationContextProvider.getBean("newsLetterRepository");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public <T extends Object> T seNewsLetterByUserName(String userName)
			throws Exception {
		return (T) newsLetterRepository.findByUserName(userName);
	}

	public <T extends Object> T seNewsLetterByUserIdx(String userIdx)
			throws Exception {
		return (T) newsLetterRepository.findByUserIdx(userIdx);
	}

	public <T extends Object> T seNewsLetters() throws Exception {
		return (T) newsLetterRepository.findAll();
	}

	public <T extends Object> T seNewsLetter(String idx) throws Exception {
		return (T) newsLetterRepository.findByIdx(idx);
	}
}
