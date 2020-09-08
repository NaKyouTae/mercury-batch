package com.mercury.process.two;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.jpa.model.two.Two;
import com.mercury.jpa.model.word.Word;
import com.mercury.jpa.repository.two.TwoRepository;
import com.mercury.jpa.repository.word.WordRepository;

@Component
@Transactional
@SuppressWarnings("unchecked")
public class TwoProcess {

	@Autowired
	private TwoRepository twoRepository;

	@Autowired
	private WordRepository weekWordRepository;

	public <T extends Object> T getTotalPoint(String userIdx) throws Exception {
		return (T) twoRepository.getTotalPoint(userIdx);
	}

	public <T extends Object> T getPopular() throws Exception {
		String now = LocalDateTime.now()
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		Word dto = weekWordRepository
				.findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndWordGroup(
						now, now, "TWO");

		List<Two> two = twoRepository.findByWordIdx(dto.getIdx(),
				Sort.by(Sort.Direction.DESC, "point", "insertDate"));

		return (T) two;
	}

	public <T extends Object> T getList() throws Exception {
		return (T) twoRepository.findAll();
	}

	public <T extends Object> T seByUser(String userIdx) throws Exception {
		List<Two> two = twoRepository.findByUserIdx(userIdx,
				Sort.by(Sort.Direction.DESC, "insertDate"));

		return (T) two;
	}

	public <T extends Object> T seByWord() throws Exception {
		String now = LocalDateTime.now()
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		Word dto = weekWordRepository
				.findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndWordGroup(
						now, now, "TWO");

		List<Two> two = twoRepository.findByWordIdx(dto.getIdx(),
				Sort.by(Sort.Direction.DESC, "insertDate"));

		return (T) two;
	}

	public <T extends Object> T seByWordIdx(String wordIdx) throws Exception {
		return (T) twoRepository.findByWordIdx(wordIdx,
				Sort.by(Sort.Direction.DESC, "point"));
	}
}
