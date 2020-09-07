package com.mercury.jpa.repository.word;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercury.jpa.model.word.Word;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
	Word findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndWordGroup(String startDate, String endDate, String wordGroup);
	List<Word> findByEndDateLessThanEqualAndWordGroupOrderByEndDateDesc(String endDate, String wordGroup);
	Word findByIdx(String wordIdx);
}
