package com.devth.dslistpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devth.dslistpro.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

	@Modifying
	@Query(nativeQuery = true, 
	value = "UPDATE tb_belonging SET position = :newPosition WHERE gamelist_id = :gamelistId AND game_id = :gameId")
	void updateBelongingPosition(Long gamelistId, Long gameId, Integer newPosition);
	
}
