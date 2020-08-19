package com.mercury.process.two;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.mercury.jpa.model.two.Two;
import com.mercury.jpa.model.word.Word;
import com.mercury.jpa.repository.two.TwoRepository;
import com.mercury.jpa.repository.word.WordRepository;

@Component
@SuppressWarnings("unchecked")
public class TwoProcess {

	@Autowired
	private TwoRepository twoRepository;

	@Autowired
	private WordRepository weekWordRepository;
	
	public <T extends Object> T getTotalPoint(String userIdx) throws Exception {
		try {
			return (T) twoRepository.getTotalPoint(userIdx);
		} catch (Exception e) {
			return (T) e;
		}
	}
	
	public <T extends Object> T getPopular() throws Exception {
		Word dto = weekWordRepository.findByWord("TWO");
		
		List<Two> two = twoRepository.findByWordIdx(dto.getIdx(), Sort.by(Sort.Direction.DESC, "point", "insertDate"));
		
		return (T) two;
	}
	
	public <T extends Object> T getList() throws Exception {
		return (T) twoRepository.findAll();
	}
	
	public <T extends Object> T seByUser(String userIdx) throws Exception {
		List<Two> two = twoRepository.findByUserIdx(userIdx, Sort.by(Sort.Direction.DESC, "insertDate"));
		
		return (T) two;
	}
	
	public <T extends Object> T seByWord() throws Exception {
		Word dto = weekWordRepository.findByWord("TWO");
		
		List<Two> two = twoRepository.findByWordIdx(dto.getIdx(), Sort.by(Sort.Direction.DESC, "insertDate"));
		
		return (T) two;
	}
}
