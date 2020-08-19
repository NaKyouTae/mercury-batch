package com.mercury.process.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercury.jpa.repository.word.WordRepository;

@Component
@SuppressWarnings("unchecked")
public class WordProcess {
	
	@Autowired
	private WordRepository weekWordRepository;
	
	public <T extends Object> T getLists() throws Exception {
		try {
			return (T) weekWordRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T getWeekWords(String group) throws Exception {
		try {
			return (T) weekWordRepository.findByWord(group);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
		
		
	}
	
	public <T extends Object> T seWord(String wordIdx) throws Exception {
		try {
			return (T) weekWordRepository.findByIdx(wordIdx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
}
