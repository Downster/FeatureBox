package com.example.MessingAround;

import com.example.MessingAround.config.PhraseCache;
import com.example.MessingAround.utils.Trie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class MessingAroundApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;
	@Test
	void contextLoads() {
	}

	@Test
	public void givenTrieBean_whenSearchingInApplicationContext_thenFindIt(){
		assertNotNull(applicationContext.getBean(PhraseCache.class));
	}

	@Test
	public void givenTrie_whenSearchingForWord_theReturnTrue(){
		Trie phraseCache = applicationContext.getBean(PhraseCache.class);
		assertTrue(phraseCache.search("will this work?"));
		assertTrue(phraseCache.search("will I send cannibals?"));
	}

	@Test
	public void givenTrie_whenSearchingForPrefixes_returnAllPossibleResults(){
		Trie phraseCache = applicationContext.getBean(PhraseCache.class);
		String[] toTest = new String[]{"will this work?", "will I get hired?", "will we make it?", "will I send cannibals?" };
		assertThat(toTest).hasSameElementsAs(Arrays.asList(phraseCache.prefixList("will")));
	}

	@Test
	public void givenUsersTable_whenSearchingForEmail_returnTrue(){

	}

}
