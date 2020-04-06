package com.finbit.dpollsapp.services;

import com.finbit.dpollsapp.domain.Poll;
import com.finbit.dpollsapp.dto.PollSearchDTO;
import com.finbit.dpollsapp.repositories.PollRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PollService {

    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @Transactional(readOnly = true)
    public List<Poll> searchPolls(PollSearchDTO pollSearchDTO) {

        return pollRepository.searchPolls(pollSearchDTO.getSearchTerm(),
                pollSearchDTO.getAfterDate(), pollSearchDTO.getBeforeDate());
    }
}
