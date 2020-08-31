package com.mercury.process.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.mercury.jpa.repository.word.WordRepository;

@Component
@SuppressWarnings("unchecked")
public class WordProcess {
	
	@Autowired
	private WordRepository wordRepository;
	
	public <T extends Object> T getLists() throws Exception {
		try {
			return (T) wordRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T getNowWords(String group) throws Exception {
		try {
			return (T) wordRepository.findByWord(group);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
		
		
	}
	
	public <T extends Object> T seWord(String wordIdx) throws Exception {
		try {
			return (T) wordRepository.findByIdx(wordIdx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seByWordGroup(String group) throws Exception {
		try {
			return (T) wordRepository.findByWordGroup(group, Sort.by(Sort.Direction.DESC, "endDate"));
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
}
