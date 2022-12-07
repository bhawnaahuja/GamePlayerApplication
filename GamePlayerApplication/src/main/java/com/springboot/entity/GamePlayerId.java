package com.springboot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GamePlayerId implements Serializable{
	
	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "GAME_ID")
	    private Long gameId;

	    @Column(name = "PLAYER_ID")
	    private Long playerId;

		public Long getGameId() {
			return gameId;
		}

		public void setGameId(Long gameId) {
			this.gameId = gameId;
		}

		public Long getPlayerId() {
			return playerId;
		}

		public void setPlayerId(Long playerId) {
			this.playerId = playerId;
		}
	 
	}





