package com.example.MessingAround.config;


import com.example.MessingAround.utils.Trie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TrieCache {
    @Bean(name= "TrieCache")
    public Trie TrieCache(){
        return new Trie();
    }
}


