package com.finbit.dpollsapp.controllers;

import com.finbit.dpollsapp.domain.Poll;
import com.finbit.dpollsapp.dto.PollDTO;
import com.finbit.dpollsapp.dto.PollSearchDTO;
import com.finbit.dpollsapp.mappers.PollMapper;
import com.finbit.dpollsapp.services.PollService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PollController {

    private final PollService pollService;
    private final PollMapper pollMapper;

    public PollController(PollService pollService, PollMapper pollMapper) {
        this.pollService = pollService;
        this.pollMapper = pollMapper;
    }

    @RequestMapping(path = "/polls")
    public List<PollDTO> findUsersPolls(@RequestBody PollSearchDTO pollSearchDTO) {

        List<Poll> polls = pollService.findPolls(pollSearchDTO);
        return polls.stream().map(pollMapper::mapPollToDto).collect(Collectors.toList());
    }
}
