package com.example.MessingAround;

import com.example.MessingAround.config.TrieCache;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;


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
		assertNotNull(applicationContext.getBean(TrieCache.class));
	}

}
