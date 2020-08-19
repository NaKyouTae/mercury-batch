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
	
	public <T extends Object> T getWeekWords(String group) throws Exception {
		return (T) weekWordProcess.getWeekWords(group);
	}
	
	public <T extends Object> T seWord(String wordIdx) throws Exception {
		return (T) weekWordProcess.seWord(wordIdx);
	}
}
