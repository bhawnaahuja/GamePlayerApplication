package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.springboot.entity.GamePlayer;
import com.springboot.entity.GamePlayerId;


@Repository
public interface GamePlayerRepository extends JpaRepository<GamePlayer, GamePlayerId>,JpaSpecificationExecutor<GamePlayer>{
	
}
