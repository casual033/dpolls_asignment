package com.finbit.dpollsapp.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Option {

    private String text;
    private boolean available;

    private Long start;
    private Long end;
    private Long startDateTime;
    private Long endDateTime;
    private Long dateTime;

    private boolean allday;
}
