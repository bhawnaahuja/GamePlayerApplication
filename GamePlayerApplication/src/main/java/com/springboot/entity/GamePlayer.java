package com.springboot.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity

public class GamePlayer {

	@EmbeddedId
	@JsonIgnore
	private GamePlayerId pk =new GamePlayerId();

	@ManyToOne
	@MapsId("gameId")
	@JoinColumn(name = "GAME_ID")
	private Game game;

	@ManyToOne
	@MapsId("playerId")
	@JoinColumn(name = "PLAYER_ID")
	private Player player;

	@Enumerated(EnumType.STRING)
	private Level level;

	
	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public GamePlayerId getPk() {
		return pk;
	}

	public void setPk(GamePlayerId pk) {
		this.pk = pk;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}