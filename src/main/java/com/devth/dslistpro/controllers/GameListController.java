package com.devth.dslistpro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devth.dslistpro.dto.GameListDTO;
import com.devth.dslistpro.dto.GameMinDTO;
import com.devth.dslistpro.services.GameListService;
import com.devth.dslistpro.services.GameService;

@RestController
@RequestMapping(value = "/gameList")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> gameList = gameListService.findAll();
		return gameList;
	}
	
	@GetMapping(value = "/{gamelistId}/games")
	public List<GameMinDTO> findById(@PathVariable Long gamelistId) {
		List<GameMinDTO> gameList = gameService.findByList(gamelistId);
		return gameList;
	}
}
