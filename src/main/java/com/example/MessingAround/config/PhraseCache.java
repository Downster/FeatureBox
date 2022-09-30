package com.example.MessingAround.config;


import com.example.MessingAround.utils.Trie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PhraseCache extends Trie{
    @Bean(name= "PhraseCache")
    public Trie PhraseCache(){
        return new Trie();
    }
}


