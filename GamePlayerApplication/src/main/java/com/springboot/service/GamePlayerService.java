package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.springboot.dto.InputDto;
import com.springboot.entity.Game;
import com.springboot.entity.GamePlayer;
import com.springboot.entity.Level;
import com.springboot.entity.Player;
import com.springboot.exceptions.ResourceNotFoundException;
import com.springboot.repository.GamePlayerRepository;
import com.springboot.repository.GameRepository;
import com.springboot.repository.PlayerRepository;

@Service
@Transactional
public class GamePlayerService {

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private GamePlayerRepository gamePlayerRepo;

	public GamePlayer save(InputDto request) {

		Game game = gameRepository.findById(request.getGameId())
				.orElseThrow(() -> new ResourceNotFoundException("Not found Game with ID =" + request.getGameId()));
		

		Player player = playerRepository.findById(request.getPlayerId()).orElseThrow(() -> new ResourceNotFoundException("Not found Player with ID =" + request.getPlayerId()));
		GamePlayer directory = new GamePlayer();
		directory.setLevel(request.getLevel());
		directory.setGame(game);
		directory.setPlayer(player);
		return gamePlayerRepo.save(directory);

	}

	public List<Player> getPlayers(Level level, Long gameId) {
		Game game = gameRepository.findById(gameId)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Game with ID =" + gameId));
		return playerRepository.queryByDirectory_LevelAndDirectory_Pk_GameId(level, gameId);
	}

	public List<Player> queryBy(Level level, String geography, Long gameId) {

		return playerRepository.findAll(new Specification<Player>() {
			@Override
			public Predicate toPredicate(Root<Player> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

				List<Predicate> predicates = new ArrayList<>();
				Join<GamePlayer, Player> joinPlayer = root.join("directory");
				Join<GamePlayer, Game> joinGame = joinPlayer.join("game");
				if (level != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(joinPlayer.get("level"), level)));
				}
				if (gameId != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(joinGame.get("gameId"), gameId)));
				}

				if (geography != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("geography"), geography)));
				}
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});

	}
}
