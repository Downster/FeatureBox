package com.example.MessingAround.repository;

import com.example.MessingAround.model.Word;
import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<Word, Long> {
}
