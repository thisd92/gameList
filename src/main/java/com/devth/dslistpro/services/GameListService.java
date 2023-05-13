package com.devth.dslistpro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devth.dslistpro.dto.GameListDTO;
import com.devth.dslistpro.entities.GameList;
import com.devth.dslistpro.projections.GameMinProjection;
import com.devth.dslistpro.repositories.GameListRepository;
import com.devth.dslistpro.repositories.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> gameList = gameListRepository.findAll();
		return gameList.stream().map(x -> new GameListDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public GameListDTO findById(Long id){
		GameList gameList = gameListRepository.findById(id).get();
		GameListDTO dto =  new GameListDTO(gameList);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public void move(Long gamelistId, int sourceIndex, int destinationIndex) {
		
		List<GameMinProjection> list = gameRepository.searchByList(gamelistId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for(int i = min; i <= max; i++ ) {
			gameListRepository.updateBelongingPosition(gamelistId, list.get(i).getId(), i);
		}
	}
}
