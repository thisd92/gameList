package com.devth.dslistpro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devth.dslistpro.dto.GameListDTO;
import com.devth.dslistpro.entities.GameList;
import com.devth.dslistpro.repositories.GameListRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	
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
}
