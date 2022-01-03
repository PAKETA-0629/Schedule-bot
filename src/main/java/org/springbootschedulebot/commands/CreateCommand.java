package org.springbootschedulebot.service;

import lombok.extern.slf4j.Slf4j;
import org.springbootschedulebot.util.Commands;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.Arrays;

@Component
@Slf4j
public class CreateCommand extends ServiceCommand{

    public CreateCommand() {
        super(Commands.CREATE);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String userName = (user.getUserName() != null) ? user.getUserName() :
                String.format("%s %s", user.getLastName(), user.getFirstName());

    }
}
