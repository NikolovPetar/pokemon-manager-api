package com.demo.projects.repository;

import com.demo.projects.entity.Player;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataPlayerRepository extends CrudRepository<Player, Long> {

    @Query("SELECT * FROM player WHERE external_id = :externalId")
    Optional<Player> findByExternalId(@Param("externalId") UUID externalId);
}
