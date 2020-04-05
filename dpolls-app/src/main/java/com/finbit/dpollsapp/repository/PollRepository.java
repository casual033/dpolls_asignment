package com.finbit.dpollsapp.repository;

import com.finbit.dpollsapp.domain.Poll;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PollRepository extends MongoRepository<Poll, String> {
}
