package com.finbit.dpollsapp.repositories;

import com.finbit.dpollsapp.domain.Initiator;
import com.finbit.dpollsapp.domain.Poll;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class PollRepositoryImplTest {

    @Autowired
    PollRepository pollRepository;

    @BeforeEach
    void setUp() {

        Poll poll1 = new Poll();
        poll1.setId("id1");
        poll1.setTitle("title");
        poll1.setDescription("description");
        poll1.setInitiated(LocalDate.of(2017,1,1).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());

        Initiator initiator1 = new Initiator();
        initiator1.setName("user name");
        initiator1.setEmail("mike@google.com");

        poll1.setInitiator(initiator1);

        pollRepository.save(poll1);

        Poll poll2 = new Poll();
        poll2.setId("id2");
        poll2.setTitle("title 2");
        poll2.setDescription("description 2");
        poll2.setInitiated(LocalDate.of(2018,1,1).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());

        poll2.setInitiator(initiator1);

        pollRepository.save(poll2);


        Poll poll3 = new Poll();
        poll3.setId("id3");
        poll3.setTitle("title 3");
        poll3.setDescription("description 3");

        Initiator initiator2 = new Initiator();
        initiator2.setName("another user");
        initiator2.setEmail("serge@yahoo.com");
        poll3.setInitiated(LocalDate.of(2019,1,1).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());

        poll3.setInitiator(initiator2);

        pollRepository.save(poll3);
    }

    @Test
    void searchPolls() {

        // when
        List<Poll> polls = pollRepository.searchPolls("user", null, null);

        // then
        assertEquals(3, polls.size());
    }

    @Test
    void searchPollsOtherUser() {

        // when
        List<Poll> polls = pollRepository.searchPolls("another", null, null);

        // then
        assertEquals(1, polls.size());
    }

    @Test
    void searchPollsEmail() {

        // when
        List<Poll> polls = pollRepository.searchPolls("google", null, null);

        // then
        assertEquals(2, polls.size());
    }

    @Test
    void searchPollsEmpty() {

        // when
        List<Poll> polls = pollRepository.searchPolls("someone else", null, null);

        // then
        assertEquals(0, polls.size());
    }

    @Test
    void searchPollsCreatedAfter() {

        // when
        List<Poll> polls = pollRepository.searchPolls("user", LocalDate.of(2017,1,1), null);

        // then
        assertEquals(2, polls.size());
    }

    @Test
    void searchPollsCreatedBefore() {

        // when
        List<Poll> polls = pollRepository.searchPolls("user", null, LocalDate.of(2019,1,1));

        // then
        assertEquals(2, polls.size());
    }

    @Test
    void searchPollsCreatedBetween() {

        // when
        List<Poll> polls = pollRepository.searchPolls("user", LocalDate.of(2017,1,1), LocalDate.of(2019,1,1));

        // then
        assertEquals(1, polls.size());
    }
}