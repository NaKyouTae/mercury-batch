package com.mercury.service.honor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.jpa.model.honor.Honor;
import com.mercury.jpa.model.three.Three;
import com.mercury.jpa.model.two.Two;
import com.mercury.jpa.model.word.Word;
import com.mercury.process.honor.HonorProcess;
import com.mercury.service.three.ThreeService;
import com.mercury.service.two.TwoService;
import com.mercury.service.word.WordService;
import com.mercury.util.UUIDUtil;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class HonorService {
	@Autowired
	private HonorProcess honorProcess;

	@Autowired
	private ThreeService threeService;

	@Autowired
	private TwoService twoService;

	@Autowired
	private WordService wordService;

	public <T extends Object> T inHonors() throws Exception {
		List<Three> three = threeService.seByPrevWord();
		List<Two> two = twoService.seByPrevWord();

		List<Three> limit_three = three.stream().limit(3)
				.collect(Collectors.toList());
		List<Two> limit_two = two.stream().limit(3)
				.collect(Collectors.toList());

		List<Honor> honorList = new ArrayList<>();

		for (Three t : limit_three) {
			Honor h = new Honor();

			h.setIdx(UUIDUtil.randomString());
			h.setUserName(t.getUserName());
			h.setContentIdx(t.getIdx());
			h.setContentOne(t.getContentOne());
			h.setContentTwo(t.getContentTwo());
			h.setContentThree(t.getContentThree());
			h.setPoint(t.getPoint());
			h.setWord(t.getWord());
			h.setCreateDate(t.getInsertDate());

			Word word = wordService.seWord(t.getWordIdx());

			h.setStartDate(word.getStartDate());
			h.setEndDate(word.getEndDate());

			honorList.add(h);
		}

		for (Two t : limit_two) {
			Honor h = new Honor();

			h.setIdx(UUIDUtil.randomString());
			h.setUserName(t.getUserName());
			h.setContentIdx(t.getIdx());
			h.setContentOne(t.getContentOne());
			h.setContentTwo(t.getContentTwo());
			h.setContentThree(null);
			h.setPoint(t.getPoint());
			h.setWord(t.getWord());
			h.setCreateDate(t.getInsertDate());

			Word word = wordService.seWord(t.getWordIdx());

			h.setStartDate(word.getStartDate());
			h.setEndDate(word.getEndDate());

			honorList.add(h);
		}

		return (T) honorProcess.inHonors(honorList);
	}
}
