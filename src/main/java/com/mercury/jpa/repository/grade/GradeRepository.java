package com.mercury.jpa.repository.grade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mercury.jpa.model.grade.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long>{
	Grade findByIdx(String idx);
	@Query(value="SELECT idx, startrange, endrange, gradename, insertdate FROM grade WHERE startrange < :point AND endrange > :point", nativeQuery = true)
	Grade findByRange(Integer point);
}
