package com.demo.projects.dto.response;

import com.demo.projects.dto.common.PlayerDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@AllArgsConstructor
@SuperBuilder
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class PlayerResponse extends PlayerDTO {

    @JsonProperty("external_id")
    private UUID externalId;
}
