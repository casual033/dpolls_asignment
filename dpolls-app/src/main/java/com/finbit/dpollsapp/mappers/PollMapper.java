package com.finbit.dpollsapp.mappers;

import com.finbit.dpollsapp.domain.Poll;
import com.finbit.dpollsapp.dto.PollDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PollMapper {

    private final ModelMapper modelMapper;

    public PollMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PollDTO mapPollToDto(Poll poll) {

        return modelMapper.map(poll, PollDTO.class);
    }
}
