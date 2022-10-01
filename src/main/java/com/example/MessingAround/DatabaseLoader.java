package com.example.MessingAround;

import com.example.MessingAround.model.Image;
import com.example.MessingAround.model.Word;
import com.example.MessingAround.repository.ImageRepository;
import com.example.MessingAround.model.Phrase;
import com.example.MessingAround.repository.PhraseRepository;
import com.example.MessingAround.repository.WordRepository;
import com.example.MessingAround.service.PhraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ImageRepository imgRepository;
    private final PhraseRepository phraseRepository;

    private final WordRepository wordRepository;


    @Autowired
    public DatabaseLoader(ImageRepository imgRepository, PhraseRepository phraseRepository, WordRepository wordRepository) {
        this.phraseRepository = phraseRepository;
        this.imgRepository = imgRepository;
        this.wordRepository = wordRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.imgRepository.save(new Image("The mona lisa", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg/1200px-Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg", "dongslayer123"));
        this.phraseRepository.save(new Phrase("will this work?"));
        this.phraseRepository.save(new Phrase("will I get hired?"));
        this.phraseRepository.save(new Phrase("will we make it?"));
        this.phraseRepository.save(new Phrase("will I send cannibals?"));
        this.wordRepository.save(new Word("dookie"));
    }
}
