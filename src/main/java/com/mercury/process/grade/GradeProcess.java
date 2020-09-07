package com.mercury.process.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.repository.grade.GradeRepository;

@Component
@SuppressWarnings("unchecked")
public class GradeProcess {

	@Autowired
	private GradeRepository gradeRepository;
	
	public GradeProcess() {
		try {
			this.gradeRepository = ApplicationContextProvider.getBean("gradeRepository");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public <T extends Object> T seGrades() throws Exception {
		try {
			return (T) gradeRepository.findAll(Sort.by(Sort.Direction.ASC, "insertDate"));
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seGrade(String idx) throws Exception {
		try {
			return (T) gradeRepository.findByIdx(idx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T getByStartRangeLessThanAndEndRangeGreaterThan(long point) throws Exception {
		try {
			return (T) gradeRepository.findByStartRangeLessThanAndEndRangeGreaterThan(point, point);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
}
