package org.springbootschedulebot.commands;

import lombok.extern.slf4j.Slf4j;
import org.springbootschedulebot.util.Commands;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Slf4j
@Component
public class StartCommand extends ServiceCommand {

    public StartCommand() {
        super(Commands.START);

    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String userName = (user.getUserName() != null) ? user.getUserName() :
                String.format("%s %s", user.getLastName(), user.getFirstName());
        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userName,
                "Почнемо! Якщо потрібна допомога, натисни /help");
    }
}
