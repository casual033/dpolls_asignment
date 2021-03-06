package com.finbit.dpollsapp.repositories;

import com.finbit.dpollsapp.domain.Poll;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Repository
public class PollRepositoryImpl implements PollRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    public PollRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Poll> searchPolls(String searchTerm, LocalDate afterDate, LocalDate beforeDate) {

        final Query query = new Query();

        if(afterDate != null && beforeDate != null) {

            long afterMillis = afterDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
            long beforeMillis = beforeDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();

            query.addCriteria(Criteria.where("initiated").gt(afterMillis).lt(beforeMillis));

        } else if(afterDate != null) {

            long milliseconds = afterDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
            query.addCriteria(Criteria.where("initiated").gt(milliseconds));

        } else if(beforeDate != null) {

            long milliseconds = beforeDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
            query.addCriteria(Criteria.where("initiated").lt(milliseconds));
        }

        if(searchTerm != null) {
            query.addCriteria(TextCriteria.forDefaultLanguage().matchingAny(searchTerm));
        }

        return mongoTemplate.find(query, Poll.class);
    }
}
