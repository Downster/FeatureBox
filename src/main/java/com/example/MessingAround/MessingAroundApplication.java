package com.example.MessingAround;

import com.example.MessingAround.config.TrieCache;
import com.example.MessingAround.model.Phrase;
import com.example.MessingAround.service.PhraseService;
import com.example.MessingAround.utils.Trie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class MessingAroundApplication {


	public static void main(String[] args) {

		SpringApplication.run(MessingAroundApplication.class, args);
	}

}
