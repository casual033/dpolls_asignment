package com.finbit.dpollsapp.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Poll {

    @Id
    private String id;

    private String adminKey;
    private Long latestChange;
    private Long initiated;
    private Integer participantsCount;
    private String type;
    private String preferencesType;
    private String state;
    private String locale;
    private String title;
    private String description;
    private Initiator initiator;

    private List<Option> options;

    private String optionsHash;

    private List<Participant> participants;

    private String device;
    private String levels;
    private boolean multiDay;

    private Location location;
}
