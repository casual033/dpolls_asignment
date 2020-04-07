package com.finbit.dpollsapp.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PollDTO implements Serializable {

    public String id;

    private String adminKey;
    private Long latestChange;
    private Long initiated;
    private Integer participantsCount;
    private String type;
    private String preferencesType;
    private String state;
    private String locale;
    private String title;

    @JsonInclude(Include.NON_NULL)
    private String description;

    private Initiator initiator;

    private List<Option> options;

    private String optionsHash;

    private List<Participant> participants;

    private String device;
    private String levels;

    @JsonInclude(Include.NON_NULL)
    private boolean multiDay;

    @JsonInclude(Include.NON_NULL)
    private Location location;

    @Data
    public static class Initiator {

        private String name;
        private String email;
        private boolean notify;
    }

    @Data
    private static class Location {

        private String name;
        private String address;
        private String countryCode;
        private String locationId;
    }

    @Data
    private static class Option {

        @JsonInclude(Include.NON_NULL)
        private String text;
        private boolean available;

        @JsonInclude(Include.NON_NULL)
        private Long start;

        @JsonInclude(Include.NON_NULL)
        private Long end;

        @JsonInclude(Include.NON_NULL)
        private Long startDateTime;

        @JsonInclude(Include.NON_NULL)
        private Long endDateTime;

        @JsonInclude(Include.NON_NULL)
        private Long dateTime;

        @JsonInclude(Include.NON_NULL)
        private boolean allday;
    }

    @Data
    private static class Participant {

        private Integer id;

        private String name;
        private Integer[] preferences;
    }
}
