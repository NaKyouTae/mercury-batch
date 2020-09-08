package com.mercury.service.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.process.grade.GradeProcess;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class GradeService {

	@Autowired
	private GradeProcess gradeProcess = new GradeProcess();

	public <T extends Object> T seGrades() throws Exception {
		return (T) gradeProcess.seGrades();
	}

	public <T extends Object> T seGrade(String idx) throws Exception {
		return (T) gradeProcess.seGrade(idx);
	}

	public <T extends Object> T getByStartRangeLessThanAndEndRangeGreaterThan(
			long point) throws Exception {
		return (T) gradeProcess
				.getByStartRangeLessThanAndEndRangeGreaterThan(point);
	}
}
