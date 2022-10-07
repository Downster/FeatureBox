package com.example.MessingAround.repository;

import com.example.MessingAround.model.User;
import com.example.MessingAround.model.Word;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
