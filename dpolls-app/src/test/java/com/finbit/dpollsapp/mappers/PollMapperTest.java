package com.finbit.dpollsapp.mappers;

import com.finbit.dpollsapp.domain.Initiator;
import com.finbit.dpollsapp.domain.Poll;
import com.finbit.dpollsapp.dto.PollDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PollMapperTest {

    private ModelMapper modelMapper = new ModelMapper();
    private PollMapper pollMapper;

    @BeforeEach
    void setUp() {
        pollMapper = new PollMapper(modelMapper);
    }

    @Test
    void mapPollToDto() {

        String userName = "user";
        String email = "user@a.com";

        Initiator initiator = new Initiator();
        initiator.setName(userName);
        initiator.setEmail(email);

        String id = "id1";
        String adminKey = "abcd";
        String title = "test poll";
        String description = "this is test poll";

        Poll poll = new Poll();
        poll.setId(id);
        poll.setAdminKey(adminKey);
        poll.setTitle(title);
        poll.setDescription(description);
        poll.setInitiator(initiator);

        PollDTO dto = pollMapper.mapPollToDto(poll);

        assertEquals(id, dto.getId());
        assertEquals(adminKey, dto.getAdminKey());
        assertEquals(title, dto.getTitle());
        assertEquals(description, dto.getDescription());

        assertEquals(userName, dto.getInitiator().getName());
        assertEquals(email, dto.getInitiator().getEmail());
    }
}