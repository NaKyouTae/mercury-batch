package com.mercury.service.two;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.jpa.model.word.Word;
import com.mercury.process.two.TwoProcess;
import com.mercury.service.word.WordService;

@Service
@SuppressWarnings("unchecked")
public class TwoService {
	
	@Autowired
	private TwoProcess twoProcess;
	@Autowired
	private WordService wordService;
	
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
	
	public <T extends Object> T seByWordIdx(String wordIdx) throws Exception {
		try {
			return (T) twoProcess.seByWordIdx(wordIdx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seByPrevWord() throws Exception {
		try {
			List<Word> words = wordService.seByWordGroup("TWO");
			return (T) seByWordIdx(words.get(1).getIdx());
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
}
