package com.proyecto.telegram.boot.service;

import com.proyecto.telegram.boot.chatgpt.ChatGPTController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
@Service
public class TelegramBoot extends TelegramLongPollingBot {

    @Autowired
    ChatGPTController chatGPTController;
    @Override
    public void onUpdateReceived(Update update) {
        Message message=update.getMessage();
        if (message != null && message.hasText() ) {
            String text=message.getText().toLowerCase();
            if (text.equals("/start")){
                SendMessage response=new SendMessage(message.getChatId().toString(),"Hola como estas soy TELEGRAM_BOT_GPT un gusto");
                try {
                    execute(response);
                }catch (TelegramApiException exception){
                    exception.printStackTrace();
                }
            } else {
                chatGPTController.chatWith(text);
                SendMessage responseGTP = new SendMessage(message.getChatId().toString(), chatGPTController.chatWith(text));


                try {
                    execute(responseGTP);
                } catch (TelegramApiException exception) {
                    exception.printStackTrace();
                }

            }
            }

        }



    @Override
    public String getBotUsername() {
        return "nombre del bot creado telegram";
    }

    @Override
    public String getBotToken() {
        return "colocar api-key-chatgpt generada";
    }
}
