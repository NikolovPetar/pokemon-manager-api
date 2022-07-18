package com.demo.projects.service;

import com.demo.projects.entity.Player;
import com.demo.projects.enums.PlayerErrorMessage;
import com.demo.projects.exception.NotFoundException;
import com.demo.projects.repository.SpringDataPlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final SpringDataPlayerRepository repository;

    public Player save(Player player) {
        player.setExternalId(UUID.randomUUID());
        return repository.save(player);
    }

    public void deleteById(UUID externalId) {
        repository.delete(findById(externalId));
    }

    public Player findById(UUID externalId) {
        return repository.findByExternalId(externalId)
                .orElseThrow(() -> new NotFoundException(PlayerErrorMessage.PLAYER_NOT_FOUND));
    }

    public Player update(UUID externalId, Player player) {
        Player saved = findById(externalId);
        saved.setAge(player.getAge());
        saved.setDateOfBirth(player.getDateOfBirth());
        return repository.save(saved);
    }
}
