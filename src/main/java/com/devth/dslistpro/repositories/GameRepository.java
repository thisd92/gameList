package com.devth.dslistpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devth.dslistpro.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
	
}
