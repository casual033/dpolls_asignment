package com.finbit.dpollsapp.repositories;

import com.finbit.dpollsapp.domain.Poll;

import java.time.LocalDate;
import java.util.List;

public interface PollRepositoryCustom {

    List<Poll> searchPolls(String searchTerm, LocalDate afterDate, LocalDate beforeDate);
}
