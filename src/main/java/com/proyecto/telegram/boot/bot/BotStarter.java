package com.proyecto.telegram.boot.bot;

import com.proyecto.telegram.boot.service.TelegramBoot;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class BotStarter implements CommandLineRunner {
    private final TelegramBoot telegramBoot;

    public BotStarter(TelegramBoot telegramBoot) {
        this.telegramBoot = telegramBoot;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            TelegramBotsApi telegramBotsApi=new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(telegramBoot);
        }catch (TelegramApiException exception){
            exception.printStackTrace();
        }

    }
}
