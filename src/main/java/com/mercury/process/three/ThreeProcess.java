package com.mercury.process.three;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.jpa.model.three.Three;
import com.mercury.jpa.model.word.Word;
import com.mercury.jpa.repository.three.ThreeRepository;
import com.mercury.jpa.repository.word.WordRepository;

@Component
@Transactional
@SuppressWarnings("unchecked")
public class ThreeProcess {
	@Autowired
	private ThreeRepository threeRepository;

	@Autowired
	private WordRepository weekWordRepository;

	public <T extends Object> T getTotalPoint(String userIdx) throws Exception {
		return (T) threeRepository.getTotalPoint(userIdx);
	}

	public <T extends Object> T getPopular() throws Exception {
		String now = LocalDateTime.now()
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		Word dto = weekWordRepository
				.findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndWordGroup(
						now, now, "THREE");

		List<Three> three = new ArrayList<>();
		if (dto == null) {
			three = null;
		} else {
			three = threeRepository.findByWordIdx(dto.getIdx(),
					Sort.by(Sort.Direction.DESC, "point", "insertDate"));
		}

		return (T) three;
	}

	public <T extends Object> T getList() throws Exception {
		return (T) threeRepository.findAll();
	}

	public <T extends Object> T seByUser(String userIdx) throws Exception {
		List<Three> three = threeRepository.findByUserIdx(userIdx,
				Sort.by(Sort.Direction.DESC, "insertDate"));

		return (T) three;
	}

	public <T extends Object> T seThreeByIdx(String idx) throws Exception {
		return (T) threeRepository.findByIdx(idx);
	}

	public <T extends Object> T seByWord() throws Exception {
		String now = LocalDateTime.now()
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		Word dto = weekWordRepository
				.findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndWordGroup(
						now, now, "THREE");

		List<Three> three = new ArrayList<>();
		if (dto == null) {
			three = null;
		} else {
			three = threeRepository.findByWordIdx(dto.getIdx(),
					Sort.by(Sort.Direction.DESC, "insertDate"));
		}

		return (T) three;
	}

	public <T extends Object> T seByWordIdx(String wordIdx) throws Exception {
		return (T) threeRepository.findByWordIdx(wordIdx,
				Sort.by(Sort.Direction.DESC, "point"));
	}
}
