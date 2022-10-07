package com.example.MessingAround;

import com.example.MessingAround.model.Image;
import com.example.MessingAround.model.Word;
import com.example.MessingAround.repository.ImageRepository;
import com.example.MessingAround.model.Phrase;
import com.example.MessingAround.repository.PhraseRepository;
import com.example.MessingAround.repository.UserRepository;
import com.example.MessingAround.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ImageRepository imgRepository;
    private final PhraseRepository phraseRepository;

    private final WordRepository wordRepository;
    private final UserRepository userRepository;


    @Autowired
    public DatabaseLoader(ImageRepository imgRepository, PhraseRepository phraseRepository, WordRepository wordRepository, UserRepository userRepository) {
        this.phraseRepository = phraseRepository;
        this.imgRepository = imgRepository;
        this.wordRepository = wordRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.imgRepository.save(Image.builder().name("The mona lisa").url("https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg/1200px-Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg").owner("dongslayer123").description("poopy").build());
        this.phraseRepository.save(Phrase.builder().phrase("will this work?").build());
        this.phraseRepository.save(Phrase.builder().phrase("will I get hired?").build());
        this.phraseRepository.save(Phrase.builder().phrase("will we make it?").build());
        this.phraseRepository.save(Phrase.builder().phrase("will I send cannibals?").build());
        this.wordRepository.save(Word.builder().word("dookie").build());
    }
}
