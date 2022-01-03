package org.springbootschedulebot.config;

import org.springbootschedulebot.bot.ScheduleBot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "org.springbootschedulebot.bot")
@PropertySource("classpath:application.properties")
public class AppConfig { }
