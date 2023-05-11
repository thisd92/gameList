package com.devth.dslistpro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devth.dslistpro.dto.GameListDTO;
import com.devth.dslistpro.services.GameListService;

@RestController
@RequestMapping(value = "/gameList")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> gameList = gameListService.findAll();
		return gameList;
	}
	
	@GetMapping(value = "/{id}")
	public GameListDTO findById(@PathVariable Long id) {
		GameListDTO gameList = gameListService.findById(id);
		return gameList;
	}
}
