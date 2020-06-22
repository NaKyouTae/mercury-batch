package com.competition.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.competition.jpa.model.grade.Grade;
import com.competition.jpa.model.three.Three;
import com.competition.jpa.model.two.Two;
import com.competition.jpa.model.user.User;
import com.competition.jpa.model.user.UserGrade;
import com.competition.jpa.model.word.Word;
import com.competition.jpa.repository.grade.GradeRepository;
import com.competition.jpa.repository.three.ThreeRepository;
import com.competition.jpa.repository.two.TwoRepository;
import com.competition.jpa.repository.user.UserGradeRepository;
import com.competition.jpa.repository.word.WordRepository;
import com.competition.process.user.UserProcess;

@Service
@SuppressWarnings("unchecked")
public class UserService {
	
	@Autowired
	private UserProcess userProcess;
	
	@Autowired
	private ThreeRepository threeRepository;
	@Autowired
	private TwoRepository twoRepository;
	@Autowired
	private WordRepository wordRepository;
	@Autowired
	private GradeRepository gradeRepository;
	@Autowired
	private UserGradeRepository userGradeRepository;
	
	
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
			
			Grade grade = gradeRepository.findByRange(user.getMileage());
			
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
			Word word = wordRepository.findByWord("THREE");
			
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
			Word word = wordRepository.findByWord("TWO");
			
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
