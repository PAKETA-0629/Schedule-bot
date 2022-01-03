package org.springbootschedulebot.util;

import lombok.Getter;

public enum Commands {

    START("/start", "start command"), HELP("/help", "help command");

    Commands(String command, String description) {
        this.command = command;
        this.description = description;
    }
    @Getter
    private final String command;
    @Getter
    private final String description;
}
