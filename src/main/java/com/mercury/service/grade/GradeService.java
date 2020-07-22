package com.mercury.service.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.process.grade.GradeProcess;

@Service
@SuppressWarnings("unchecked")
public class GradeService {
	
	@Autowired
	private GradeProcess gradeProcess = new GradeProcess();
	
	public <T extends Object> T seGrades() throws Exception {
		try {
			return (T) gradeProcess.seGrades();
		}catch(Exception e) {
			return (T) e;
		}
	}
	
	public <T extends Object> T seGrade(String idx) throws Exception {
		try {
			return (T) gradeProcess.seGrade(idx);
		}catch(Exception e) {
			return (T) e;
		}
	}	
}
