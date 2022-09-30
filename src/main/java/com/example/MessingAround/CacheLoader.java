package com.example.MessingAround;

import com.example.MessingAround.config.PhraseCache;
import com.example.MessingAround.model.Phrase;
import com.example.MessingAround.service.PhraseService;
import com.example.MessingAround.utils.Trie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CacheLoader implements CommandLineRunner {

    @Autowired
    private PhraseService phraseService;

    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        List<Phrase> phrases = phraseService.getAllPhrases();
        Trie phraseCache = context.getBean(PhraseCache.class);
        phrases.forEach(phrase -> phraseCache.addWord(phrase.toString()));
    }
}
