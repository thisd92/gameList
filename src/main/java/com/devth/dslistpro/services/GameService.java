package com.devth.dslistpro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devth.dslistpro.dto.GameDTO;
import com.devth.dslistpro.dto.GameMinDTO;
import com.devth.dslistpro.entities.Game;
import com.devth.dslistpro.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> gameList = gameRepository.findAll();
		return gameList.stream().map(x -> new GameMinDTO(x)).toList();
	};
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id){
		Game game = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(game);
		return dto;
	}
}
