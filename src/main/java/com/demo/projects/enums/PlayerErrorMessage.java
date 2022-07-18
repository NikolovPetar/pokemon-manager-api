package com.demo.projects.enums;

import com.demo.projects.exception.ErrorMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PlayerErrorMessage implements ErrorMessage {

    PLAYER_NOT_FOUND("PLAYER_001", "Player not found."),
    ARGUMENT_NOT_VALID("PLAYER_002", "Invalid input format.");

    private final String code;
    private final String message;
}
