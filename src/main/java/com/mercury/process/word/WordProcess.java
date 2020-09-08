package com.mercury.process.word;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.jpa.repository.word.WordRepository;

@Component
@Transactional
@SuppressWarnings("unchecked")
public class WordProcess {

	@Autowired
	private WordRepository wordRepository;

	public <T extends Object> T getLists() throws Exception {
		return (T) wordRepository.findAll();
	}

	public <T extends Object> T getNowWords(String group) throws Exception {
		String now = LocalDateTime.now()
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		return (T) wordRepository
				.findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndWordGroup(
						now, now, group);
	}

	public <T extends Object> T seWord(String wordIdx) throws Exception {
		return (T) wordRepository.findByIdx(wordIdx);
	}

	public <T extends Object> T seByWordGroup(String group) throws Exception {
		String now = LocalDateTime.now()
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		return (T) wordRepository
				.findByEndDateLessThanEqualAndWordGroupOrderByEndDateDesc(now,
						group);
	}

}
