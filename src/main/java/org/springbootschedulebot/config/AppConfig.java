package org.springbootschedulebot.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "org.springbootschedulebot.bot")
@ComponentScan(basePackages = "org.springbootschedulebot.commands")
@PropertySource("classpath:application.properties")
public class AppConfig { }
