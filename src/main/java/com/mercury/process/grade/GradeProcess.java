package com.mercury.process.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.mercury.jpa.repository.grade.GradeRepository;
import com.mercury.util.BeanUtil;

@Component
@SuppressWarnings("unchecked")
public class GradeProcess {

	@Autowired
	private GradeRepository gradeRepository;
	
	public GradeProcess() {
		try {
			this.gradeRepository = (GradeRepository) BeanUtil.getBean("gradeRepository");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public <T extends Object> T seGrades() throws Exception {
		return (T) gradeRepository.findAll(Sort.by(Sort.Direction.ASC, "insertDate"));
	}
	
	public <T extends Object> T seGrade(String idx) throws Exception {
		return (T) gradeRepository.findByIdx(idx);
	}	
}
