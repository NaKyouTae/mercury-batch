package com.mercury.jpa.repository.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercury.jpa.model.token.Refresh;

@Repository
public interface RefreshRepository extends JpaRepository<Refresh, Long>{
	Refresh findByToken(String token);
}
