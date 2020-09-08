package com.mercury.process.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.repository.grade.GradeRepository;

@Component
@Transactional
@SuppressWarnings("unchecked")
public class GradeProcess {

	@Autowired
	private GradeRepository gradeRepository;

	public GradeProcess() {
		try {
			this.gradeRepository = ApplicationContextProvider.getBean("gradeRepository");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public <T extends Object> T seGrades() throws Exception {
		return (T) gradeRepository
				.findAll(Sort.by(Sort.Direction.ASC, "insertDate"));
	}

	public <T extends Object> T seGrade(String idx) throws Exception {
		return (T) gradeRepository.findByIdx(idx);
	}

	public <T extends Object> T getByStartRangeLessThanAndEndRangeGreaterThan(
			long point) throws Exception {
		return (T) gradeRepository
				.findByStartRangeLessThanAndEndRangeGreaterThan(point, point);
	}
}
