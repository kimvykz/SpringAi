package kr.aisawan.SpringAi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class OpenAIService {
    @Value("${spring.ai.openai.chat.model}")
    private String model;
    private final OpenAiChatModel chatModel;


    public String chat(String message) {
        PromptTemplate promptTemplate;
        String response;

        try {
            promptTemplate = new PromptTemplate(message + " Short answer");

            ChatResponse chatResponse = chatModel.call(promptTemplate.create(OpenAiChatOptions.builder()
                    .withModel(model)
                    .withTemperature(0.5F)
                    .build()));
            response = chatResponse.getResult().getOutput().getContent();
        } catch (Exception ex) {
            log.error("Error in chat: {}", ex.getMessage());
            throw new RuntimeException(ex);
        }
        return response;
    }

}
