package com.finbit.dpollsapp.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Participant {

    @Id
    private String id;

    private String name;
    private Integer[] preferences;
}
