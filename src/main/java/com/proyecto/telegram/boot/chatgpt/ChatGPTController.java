package com.proyecto.telegram.boot.chatgpt;

import io.github.flashvayne.chatgpt.dto.ChatRequest;
import io.github.flashvayne.chatgpt.dto.ChatResponse;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chatbot")
public class ChatGPTController implements InitializingBean {
    @Autowired
    private ChatgptService chatgptService;


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("===Start ChatGPT TELEGRAM ===");

    }

    @GetMapping("/chat")
    public String chatWith(@RequestParam String mensaje){
        System.out.println(mensaje);
        return chatgptService.sendMessage(mensaje);
    }

    @GetMapping("/prompt")
    public ChatResponse prompt(@RequestParam String mensaje){
        Integer maxToken=300;
        String model="text-davinci-003";
        Double temperature=0.5;
        Double top=1.0;

        ChatRequest chatRequest=new ChatRequest(model,mensaje,maxToken,temperature,top);
        ChatResponse response=chatgptService.sendChatRequest(chatRequest);
        System.out.println("respuesta: "+response.toString());
        return response;
    }

}
