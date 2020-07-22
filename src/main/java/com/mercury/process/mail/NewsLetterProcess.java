package com.mercury.process.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercury.jpa.repository.mail.NewsLetterRepository;
import com.mercury.util.BeanUtil;

@Component
@SuppressWarnings("unchecked")
public class NewsLetterProcess {
	@Autowired
	private NewsLetterRepository newsLetterRepository;
	
	public NewsLetterProcess() {
		try {
			this.newsLetterRepository = (NewsLetterRepository) BeanUtil.getBean("newsLetterRepository");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public <T extends Object> T seNewsLetterByUserName(String userName) throws Exception {
		try {
			return (T) newsLetterRepository.findByUserName(userName);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seNewsLetterByUserIdx(String userIdx) throws Exception {
		try {
			return (T) newsLetterRepository.findByUserIdx(userIdx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seNewsLetters() throws Exception {
		try {
			return (T) newsLetterRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seNewsLetter(String idx) throws Exception {
		try {
			return (T) newsLetterRepository.findByIdx(idx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
}
