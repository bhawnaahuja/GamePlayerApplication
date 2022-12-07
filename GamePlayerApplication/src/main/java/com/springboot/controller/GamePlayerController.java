package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.InputDto;
import com.springboot.entity.GamePlayer;
import com.springboot.entity.Level;
import com.springboot.entity.Player;
import com.springboot.service.GamePlayerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class GamePlayerController {

	@Autowired
	private GamePlayerService service;

	@ApiOperation(value = "This Api associates a given  Player with a Game'.", responseContainer = "Contact")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"), 
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal server error occurred") })
	@PostMapping("/add")
	public GamePlayer linkPlayer(@RequestBody InputDto request) {

		return service.save(request);

	}

	@ApiOperation(value = "API to get the players on a specific level(eg. INVINCIBLE) per game}.", responseContainer = "Player")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal server error occurred") })
	@ApiParam(value = "game's {id}", required = true)
	@GetMapping("/listPlayers/{id}")
	public List<Player> getPlayers(@RequestParam("level") Level level, @PathVariable("id") Long id) {

		return service.getPlayers(level, id);
	}

	@ApiOperation(value = "Search API based on level, game and geography for auto-matching players}.", responseContainer = "Player")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"), 
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal server error occurred") })
	@ApiParam(value = "game's {id}", required = true)
	@GetMapping("/search")
	public List<Player> search(@RequestParam(value = "level", required = false) Level level,
			@RequestParam(value = "geography", required = false) String geography,
			@RequestParam(value = "gameId", required = false) Long gameId) {

		return service.queryBy(level, geography, gameId);
	}

}
