package com.finbit.dpollsapp.services;

import com.finbit.dpollsapp.domain.Poll;
import com.finbit.dpollsapp.dto.PollSearchDTO;
import com.finbit.dpollsapp.repositories.PollRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PollService {

    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public List<Poll> findPolls(PollSearchDTO pollSearchDTO) {

        if(pollSearchDTO.isEmailSearchTermSet()) {

            return pollRepository.findByInitiator_Email(pollSearchDTO.getUserEmail());

        } else if(pollSearchDTO.isNameSearchTermSet()) {

            return pollRepository.findByInitiator_Name(pollSearchDTO.getUserName());
        }

        return Collections.emptyList();
    }
}
