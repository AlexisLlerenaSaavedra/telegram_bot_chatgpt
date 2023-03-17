package com.proyecto.telegram.boot;

import com.fasterxml.jackson.databind.SequenceWriter;
import com.proyecto.telegram.boot.service.TelegramBoot;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;




@SpringBootApplication
public class BootTelegramApplication{

	public static void main(String[] args) {
		SpringApplication.run(BootTelegramApplication.class,args);

		//crea instancia del cliente chatgtp

	}

}
