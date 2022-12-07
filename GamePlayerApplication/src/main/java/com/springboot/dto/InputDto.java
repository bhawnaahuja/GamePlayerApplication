package com.springboot.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.entity.Level;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputDto {

	

	@JsonProperty
	@NotNull
	private long gameId;
	
	@JsonProperty
	@NotNull
	private long playerId;
	
	@JsonProperty
	@NotNull
	private Level level;

	
}
