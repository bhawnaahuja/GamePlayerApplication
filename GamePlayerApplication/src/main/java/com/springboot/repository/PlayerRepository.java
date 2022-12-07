package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.springboot.entity.Level;
import com.springboot.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long>,JpaSpecificationExecutor<Player>{
	
	
	List<Player> queryByDirectory_LevelAndDirectory_Pk_GameId(Level level,Long gameId);
	
	

}
