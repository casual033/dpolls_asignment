package com.finbit.dpollsapp.repositories;

import com.finbit.dpollsapp.domain.Poll;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PollRepository extends MongoRepository<Poll, String> {

    List<Poll> findByInitiator_Name(String name);

    List<Poll> findByInitiator_Email(String email);
}
