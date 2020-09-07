package com.mercury.grade;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.mercury.jpa.model.grade.Grade;
import com.mercury.service.grade.GradeService;

@SpringBootTest
@ActiveProfiles("local")
@EnableConfigurationProperties
public class GradeTest {

	@Autowired
	private GradeService gradeService;
	
	@Test
	public void test() {
		try {
			Grade grade = gradeService.getByStartRangeLessThanAndEndRangeGreaterThan(30);
			System.out.println(grade.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
