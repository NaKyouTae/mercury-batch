package com.mercury.service.user;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.model.grade.Grade;
import com.mercury.jpa.model.three.Three;
import com.mercury.jpa.model.two.Two;
import com.mercury.jpa.model.user.User;
import com.mercury.jpa.model.user.UserGrade;
import com.mercury.jpa.model.word.Word;
import com.mercury.jpa.repository.grade.GradeRepository;
import com.mercury.jpa.repository.three.ThreeRepository;
import com.mercury.jpa.repository.two.TwoRepository;
import com.mercury.jpa.repository.user.UserGradeRepository;
import com.mercury.jpa.repository.word.WordRepository;
import com.mercury.process.user.UserProcess;
import com.mercury.service.grade.GradeService;

@Service
@SuppressWarnings("unchecked")
public class UserService {
	
	@Autowired
	private UserProcess userProcess = new UserProcess();
	
	@Autowired
	private ThreeRepository threeRepository;
	@Autowired
	private TwoRepository twoRepository;
	@Autowired
	private WordRepository wordRepository;
	@Autowired
	private GradeRepository gradeRepository;
	private GradeService gradeService;
	@Autowired
	private UserGradeRepository userGradeRepository;
	
	public UserService() {
		try {
			this.threeRepository = ApplicationContextProvider.getBean("threeRepository");
			this.twoRepository = ApplicationContextProvider.getBean("twoRepository");
			this.wordRepository = ApplicationContextProvider.getBean("wordRepository");
			this.gradeRepository = ApplicationContextProvider.getBean("gradeRepository");
			this.userGradeRepository = ApplicationContextProvider.getBean("userGradeRepository");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public <T extends Object> T seUsers() throws Exception {
		try {
			return (T) userProcess.seUsers();
		} catch (Exception e) {
			e.printStackTrace();
			 return (T) e;
		}
	}
	
	public <T extends Object> T seUser(String idx) throws Exception {
		try {
			return (T) userProcess.seUser(idx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T upUserGrade(User user) throws Exception {
		try {
			UserGrade userGrade = userGradeRepository.findByUserName(user.getUsername());
			
			Grade grade = gradeService.getByStartRangeLessThanAndEndRangeGreaterThan(user.getMileage());
			
			if(!userGrade.getGradeIdx().equals(grade.getIdx())) {
				userGrade.setGradeIdx(grade.getIdx());
				userGrade.setGradeName(grade.getGradeName());
				userGradeRepository.save(userGrade);
			}
			
			return (T) Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T upUserThreePoint() throws Exception {
		try {
			String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			Word word = wordRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndWordGroup(now, now,"THREE");
			
			if(word == null) return (T) Boolean.FALSE;
			
			List<Three> three = threeRepository.findByWordIdx(word.getIdx(), Sort.by(Sort.Direction.DESC, "point"));
			
			if(three.size() == 0) return (T) Boolean.FALSE;
			
			for(int i = 2; i == 0; i--) {
				if(three.get(i) == null) break;
				
				Three t = three.get(i);
				User user = seUser(t.getUserIdx());
				user.setMileage(user.getMileage() + (1000 * i+1));
				upUserGrade(user);
				userProcess.upUser(user);
			}
			
			return (T) Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
			 return (T) e;
		}
	}
	
	public <T extends Object> T upUserTwoPoint() throws Exception {
		try {
			String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			Word word = wordRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndWordGroup(now, now,"TWO");
			
			if(word == null) return (T) Boolean.FALSE;
			
			List<Two> two = twoRepository.findByWordIdx(word.getIdx(), Sort.by(Sort.Direction.DESC, "point"));
			
			if(two.size() == 0) return (T) Boolean.FALSE;
			
			for(int i = 2; i == 0; i--) {
				if(two.get(i) == null) break;
				
				Two t = two.get(i);
				User user = seUser(t.getUserIdx());
				user.setMileage(user.getMileage() + (1000 * i+1));
				upUserGrade(user);
				userProcess.upUser(user);
			}
			
			return (T) Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
}
