package com.demo.projects.controller;

import com.demo.projects.dto.request.CreatePlayerRequest;
import com.demo.projects.dto.request.UpdatePlayerRequest;
import com.demo.projects.dto.response.PlayerResponse;
import com.demo.projects.mapper.PlayerMapper;
import com.demo.projects.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(value = "players", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService service;
    private final PlayerMapper mapper;

    @GetMapping("{playerId}")
    @ResponseStatus(HttpStatus.OK)
    public PlayerResponse getPlayerById(@PathVariable("playerId") UUID playerId) {
        return mapper.toPlayerResponse(service.findById(playerId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerResponse createPlayer(@RequestBody @Valid CreatePlayerRequest dto) {
        return mapper.toPlayerResponse(service.save(mapper.toPlayer(dto)));
    }

    @PutMapping("{playerId}")
    @ResponseStatus(HttpStatus.OK)
    public PlayerResponse updatePlayer(@PathVariable("playerId") UUID playerId, @RequestBody @Valid UpdatePlayerRequest dto) {
        return mapper.toPlayerResponse(service.update(playerId, mapper.toPlayer(dto)));
    }

    @DeleteMapping("{playerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlayer(@PathVariable("playerId") UUID playerId) {
        service.deleteById(playerId);
    }
}
