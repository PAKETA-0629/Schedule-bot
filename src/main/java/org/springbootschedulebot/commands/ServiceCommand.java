package org.springbootschedulebot.commands;

import lombok.extern.slf4j.Slf4j;
import org.springbootschedulebot.util.Commands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
@Slf4j
abstract class ServiceCommand extends BotCommand {

    ServiceCommand(Commands command) {
        super(command.getCommand(), command.getDescription());
    }

    void sendAnswer(AbsSender absSender, Long chatId, String commandName, String userName, String text) {
        SendMessage message = new SendMessage();
        message.enableMarkdown(true);
        message.setChatId(chatId.toString());
        message.setText(text);
        try {
            absSender.execute(message);
        } catch (TelegramApiException e) {
            log.error(e.toString());
        }
    }
}
