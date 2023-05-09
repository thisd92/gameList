package com.devth.dslistpro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devth.dslistpro.dto.GameMinDTO;
import com.devth.dslistpro.entities.Game;
import com.devth.dslistpro.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll() {
		List<Game> gameList = gameRepository.findAll();
		return gameList.stream().map(x -> new GameMinDTO(x)).toList();
	};
}
