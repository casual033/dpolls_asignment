package com.finbit.dpollsapp.controllers;

import com.finbit.dpollsapp.domain.Poll;
import com.finbit.dpollsapp.dto.PollDTO;
import com.finbit.dpollsapp.dto.PollSearchDTO;
import com.finbit.dpollsapp.mappers.PollMapper;
import com.finbit.dpollsapp.services.PollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

        List<Poll> polls = pollService.searchPolls(pollSearchDTO);
        return polls.stream().map(pollMapper::mapPollToDto).collect(Collectors.toList());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<String> handleRuntimeExceptions(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
