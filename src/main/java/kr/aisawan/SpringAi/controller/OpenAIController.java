package kr.aisawan.SpringAi.controller;

import kr.aisawan.SpringAi.service.OpenAIService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/openai")
@RequiredArgsConstructor
public class OpenAIController {
    private final OpenAIService openAIService;

    @GetMapping("/chat")
    String askQuestion(@RequestParam String question) {
        return openAIService.chat(question);
    }
}
