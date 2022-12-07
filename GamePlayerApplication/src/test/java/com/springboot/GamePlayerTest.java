package com.springboot;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springboot.dto.InputDto;
import com.springboot.entity.GamePlayer;
import com.springboot.entity.Level;
import com.springboot.exceptions.ResourceNotFoundException;
import com.springboot.repository.GamePlayerRepository;
import com.springboot.repository.GameRepository;
import com.springboot.repository.PlayerRepository;
import com.springboot.service.GamePlayerService;

@ExtendWith(MockitoExtension.class)
public class GamePlayerTest {
	
	@Mock
	private GameRepository gameRepository;

	@Mock
	private PlayerRepository playerRepository;
	
	@Mock
	private GamePlayerRepository gamePlayerRepo;
	
	

    @InjectMocks
    private GamePlayerService service;
    
 
    @Test
    public void saveGamePlayer_thenThrowsException(){
    	InputDto request = new InputDto(1,1,Level.INVINCIBLE);
        given(gameRepository.findById(request.getGameId()))
                .willReturn(Optional.empty());

        org.junit.jupiter.api.Assertions.assertThrows(ResourceNotFoundException.class, () -> {
        	service.save(request);
        });

        verify(gamePlayerRepo, never()).save(any(GamePlayer.class));
    }

}
