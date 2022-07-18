package com.demo.projects.mapper;

import com.demo.projects.dto.request.CreatePlayerRequest;
import com.demo.projects.dto.request.UpdatePlayerRequest;
import com.demo.projects.dto.response.PlayerResponse;
import com.demo.projects.entity.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(source = "age", target = "age")
    PlayerResponse toPlayerResponse(Player entity);
    Player toPlayer(CreatePlayerRequest dto);
    Player toPlayer(UpdatePlayerRequest dto);

}
