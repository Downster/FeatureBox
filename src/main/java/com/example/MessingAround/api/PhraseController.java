package com.example.MessingAround.api;

import com.example.MessingAround.model.Phrase;
import com.example.MessingAround.repository.PhraseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhraseController {
    private final PhraseRepository repository;

    PhraseController(PhraseRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/phrases")
    Iterable<Phrase> all(){
        return repository.findAll();
    }
}
