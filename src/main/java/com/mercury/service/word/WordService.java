package com.mercury.service.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.process.word.WordProcess;

@Service
@SuppressWarnings("unchecked")
public class WordService {
	
	@Autowired
	private WordProcess weekWordProcess;
	
	public <T extends Object> T getLists() throws Exception {
		return (T) weekWordProcess.getLists();
	}
	
	public <T extends Object> T getNowWords(String group) throws Exception {
		return (T) weekWordProcess.getNowWords(group);
	}
	
	public <T extends Object> T seWord(String wordIdx) throws Exception {
		return (T) weekWordProcess.seWord(wordIdx);
	}
	
	public <T extends Object> T seByWordGroup(String group) throws Exception {
		try {
			return (T) weekWordProcess.seByWordGroup(group);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
}
