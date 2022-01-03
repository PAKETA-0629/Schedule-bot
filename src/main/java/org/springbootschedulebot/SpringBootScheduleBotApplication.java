package org.springbootschedulebot;

import org.springbootschedulebot.bot.ScheduleBot;
import org.springbootschedulebot.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootScheduleBotApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootScheduleBotApplication.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(context.getBean(ScheduleBot.class));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

}

