package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
