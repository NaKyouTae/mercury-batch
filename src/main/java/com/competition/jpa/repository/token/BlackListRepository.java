package com.competition.jpa.repository.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.competition.jpa.model.token.BlackList;

@Repository
public interface BlackListRepository extends JpaRepository<BlackList, Long>{
	BlackList findByToken(String token);
	BlackList findByInsertDate(String date);
}
