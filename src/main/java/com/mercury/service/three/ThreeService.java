package com.mercury.service.three;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.jpa.model.word.Word;
import com.mercury.process.three.ThreeProcess;
import com.mercury.service.word.WordService;

@Service
@SuppressWarnings("unchecked")
public class ThreeService {
	
	@Autowired
	private ThreeProcess threeProcess;
	@Autowired
	private WordService wordService;
	
	
	public <T extends Object> T getTotalPoint(String userIdx) throws Exception {
		try {
			return (T) threeProcess.getTotalPoint(userIdx);
		} catch (Exception e) {
			return (T) e;
		}
	}
	
	public <T extends Object> T getPopular() throws Exception {
		return (T) threeProcess.getPopular();
	}
	
	public <T extends Object> T getList() throws Exception {
		return (T) threeProcess.getList();
	}

	public <T extends Object> T seByUser(String userIdx) throws Exception {
		return (T) threeProcess.seByUser(userIdx);
	}
	
	public <T extends Object> T seThreeByIdx(String idx) throws Exception {
		try {
			return (T) threeProcess.seThreeByIdx(idx);
		} catch (Exception e) {
			 e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seByWordIdx(String wordIdx) throws Exception {
		try {
			return (T) threeProcess.seByWordIdx(wordIdx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seByWord() throws Exception {
		return (T) threeProcess.seByWord();
	}
	
	public <T extends Object> T seByPrevWord() throws Exception {
		try {
			List<Word> words = wordService.seByWordGroup("THREE");
			return (T) seByWordIdx(words.get(1).getIdx());
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
}
