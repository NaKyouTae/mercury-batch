package com.competition.process.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.competition.jpa.repository.grade.GradeRepository;

@Component
@SuppressWarnings("unchecked")
public class GradeProcess {

	@Autowired
	private GradeRepository gradeRepository;

	public <T extends Object> T seGrades() throws Exception {
		return (T) gradeRepository.findAll(Sort.by(Sort.Direction.ASC, "insertDate"));
	}
	
	public <T extends Object> T seGrade(String idx) throws Exception {
		return (T) gradeRepository.findByIdx(idx);
	}	
}
