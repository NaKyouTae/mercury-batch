package com.mercury.process.three;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.mercury.jpa.model.three.Three;
import com.mercury.jpa.model.word.Word;
import com.mercury.jpa.repository.three.ThreeRepository;
import com.mercury.jpa.repository.word.WordRepository;

@Component
@SuppressWarnings("unchecked")
public class ThreeProcess {
	@Autowired
	private ThreeRepository threeRepository;

	@Autowired
	private WordRepository weekWordRepository;
	
	public <T extends Object> T getTotalPoint(String userIdx) throws Exception {
		try {
			return (T) threeRepository.getTotalPoint(userIdx);
		} catch (Exception e) {
			return (T) e;
		}
	}
	
	public <T extends Object> T getPopular() throws Exception {
		try {
			Word dto = weekWordRepository.findByWord("THREE");
			
			List<Three> three = new ArrayList<>(); 
			if(dto == null) {
				three = null; 
			}else {			
				three =	threeRepository.findByWordIdx(dto.getIdx(), Sort.by(Sort.Direction.DESC, "point", "insertDate"));
			}
			
			return (T) three;
		} catch (Exception e) {
			return(T) e;
		}
	}
	
	public <T extends Object> T getList() throws Exception {
		return (T) threeRepository.findAll();
	}
	
	public <T extends Object> T seByUser(String userIdx) throws Exception {
		List<Three> three = threeRepository.findByUserIdx(userIdx, Sort.by(Sort.Direction.DESC, "insertDate"));
		
		return (T) three;
	}
	
	public <T extends Object> T seThreeByIdx(String idx) throws Exception {
		try {
			return (T) threeRepository.findByIdx(idx); 
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seByWord() throws Exception {
		Word dto = weekWordRepository.findByWord("THREE");
		
		List<Three> three = new ArrayList<>(); 
		if(dto == null) {
			three = null; 
		}else {			
			three =	threeRepository.findByWordIdx(dto.getIdx(), Sort.by(Sort.Direction.DESC, "insertDate"));
		}
		
		return (T) three;
	}

	public <T extends Object> T seByWordIdx(String wordIdx) throws Exception {
		try {
			return (T) threeRepository.findByWordIdx(wordIdx, Sort.by(Sort.Direction.DESC, "point"));
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
}
