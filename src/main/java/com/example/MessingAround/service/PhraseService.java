package com.example.MessingAround.service;

import com.example.MessingAround.model.Phrase;
import com.example.MessingAround.repository.PhraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhraseService {

    @Autowired
    private PhraseRepository phraseRepository;

    public List<Phrase> getAllPhrases(){
        List<Phrase> phrases = new ArrayList<Phrase>();
        phraseRepository.findAll().forEach(phrases::add);
        return phrases;
    }


}
