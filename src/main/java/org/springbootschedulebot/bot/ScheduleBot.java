package org.springbootschedulebot.bot;

import lombok.extern.slf4j.Slf4j;
import org.springbootschedulebot.service.StartCommand;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
public class ScheduleBot extends TelegramLongPollingCommandBot {

    private final String BOT_TOKEN;
    private final String BOT_NAME;

    public ScheduleBot(@Value("${bot.token}") String token, @Value("${bot.name}") String name) {
        this.BOT_TOKEN = token;
        this.BOT_NAME = name;
        register(new StartCommand("start", "start command"));
    }


    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage();
            message.setText(update.getMessage().getText());
            message.setChatId(update.getMessage().getChatId().toString());
            try {
                execute(message);
            } catch (TelegramApiException e) {
                log.error(e.toString());
            }
        }
    }

    @Override
    public String getBotToken() {
        log.info(BOT_TOKEN);
        return BOT_TOKEN;
    }
}