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

        PollDTO dto = modelMapper.map(poll, PollDTO.class);

        return dto;
    }
}
